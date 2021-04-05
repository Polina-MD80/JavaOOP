package viceCity.core.interfaces;

import viceCity.models.guns.Gun;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.neighbourhood.Neighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

import static viceCity.common.ConstantMessages.*;

public class ControllerImpl implements Controller {
    private Player mainPlayer;
    private ArrayDeque<Gun> gunQueue;
    private Map<String, Player> civilPlayers;
    private Neighbourhood neighbourhood;


    public ControllerImpl() {
        this.mainPlayer = new MainPlayer();
        this.gunQueue = new ArrayDeque<>();
        this.civilPlayers = new LinkedHashMap<>();
        this.neighbourhood = new GangNeighbourhood();

    }

    private int civilCount() {
        return civilPlayers.size();
    }

    @Override
    public String addPlayer(String name) {
        civilPlayers.put(name, new CivilPlayer(name));

        return String.format(PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        try {
            Class<?> aClass = Class.forName("viceCity.models.guns." + type);
            Gun gun = (Gun) aClass.getDeclaredConstructor(String.class).newInstance(name);
            gunQueue.offer(gun);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            return GUN_TYPE_INVALID;
        }
        return String.format(GUN_ADDED, name, type);
    }

    @Override
    public String addGunToPlayer(String name) {

        Player player = null;
        Gun gun;
        if (gunQueue.isEmpty()) {
            return GUN_QUEUE_IS_EMPTY;
        }
        if (name.equals("Vercetti")) {
            player = mainPlayer;
            gun = gunQueue.poll();
            player.getGunRepository().add(gun);
            return String.format(GUN_ADDED_TO_MAIN_PLAYER, gun.getName(), player.getName());
        } else {
            if (civilPlayers.containsKey(name)) {
                player = civilPlayers.get(name);
                gun = gunQueue.poll();
                player.getGunRepository().add(gun);
                return String.format(GUN_ADDED_TO_CIVIL_PLAYER, gun.getName(), player.getName());
            }

        }
        return CIVIL_PLAYER_DOES_NOT_EXIST;

    }

    @Override
    public String fight() {
        int initialCivilCount = civilCount();
        List<Player> playersCollection = new ArrayList<>(civilPlayers.values());
        neighbourhood.action(mainPlayer,playersCollection);

        if (mainPlayer.getLifePoints() == 100 && initialCivilCount == 0) {
            return FIGHT_HOT_HAPPENED;
        }
        if (mainPlayer.getLifePoints() == 100 && initialCivilCount == civilCount()) {
            if (civilPlayers.values().stream().allMatch(p -> p.getLifePoints() == 50)) {
                return FIGHT_HOT_HAPPENED;
            }
        }
        playersCollection.removeIf(player -> !player.isAlive());
        civilPlayers.keySet().removeIf(k-> playersCollection.stream().noneMatch(player -> player.getName().equals(k)));


        return String.format(FIGHT_HAPPENED + "%n" + MAIN_PLAYER_LIVE_POINTS_MESSAGE + "%n"
                        + MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE + "%n" +
                        CIVIL_PLAYERS_LEFT_MESSAGE,
                mainPlayer.getLifePoints(), initialCivilCount - civilCount(), civilCount());
    }
}
