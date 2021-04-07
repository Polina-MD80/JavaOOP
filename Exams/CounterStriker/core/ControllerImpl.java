package CounterStriker.core;

import CounterStriker.Main;
import CounterStriker.models.field.Field;
import CounterStriker.models.field.FieldImpl;
import CounterStriker.models.guns.Gun;
import CounterStriker.models.guns.Pistol;
import CounterStriker.models.guns.Rifle;
import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.PlayerImpl;
import CounterStriker.models.players.Terrorist;
import CounterStriker.repositories.GunRepository;
import CounterStriker.repositories.PlayerRepository;
import CounterStriker.repositories.Repository;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

import static CounterStriker.common.ExceptionMessages.*;
import static CounterStriker.common.OutputMessages.SUCCESSFULLY_ADDED_GUN;
import static CounterStriker.common.OutputMessages.SUCCESSFULLY_ADDED_PLAYER;

public class ControllerImpl implements Controller {
    private Field field;
    private Repository<Player> playerRepository;
    private Repository<Gun> gunRepository;

    public ControllerImpl() {
        this.field = new FieldImpl();
        this.playerRepository = new PlayerRepository();
        this.gunRepository = new GunRepository();
    }

    @Override
    public String addGun(String type, String name, int bulletsCount) {
        Gun gun;
        switch (type) {
            case "Pistol":
                gun = new Pistol(name, bulletsCount);
                break;
            case "Rifle":
                gun = new Rifle(name, bulletsCount);
                break;
            default:
                throw new IllegalArgumentException(INVALID_GUN_TYPE);
        }
        gunRepository.add(gun);
        return String.format(SUCCESSFULLY_ADDED_GUN, gun.getName());
    }

    @Override
    public String addPlayer(String type, String username, int health, int armor, String gunName) {
        if (this.gunRepository.findByName(gunName) == null) {
            throw new NullPointerException(GUN_CANNOT_BE_FOUND);
        }
        Gun gun = this.gunRepository.findByName(gunName);
        Player player;
        switch (type) {
            case "CounterTerrorist":
                player = new CounterTerrorist(username, health, armor, gun);
                break;
            case "Terrorist":
                player = new Terrorist(username, health, armor, gun);
                break;
            default:
                throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }
        this.playerRepository.add(player);
        return String.format(SUCCESSFULLY_ADDED_PLAYER, player.getUsername());
    }

    @Override
    public String startGame() {
        Collection<Player> alivePlayers = playerRepository.getModels().stream()
                .filter(Player::isAlive).collect(Collectors.toList());
        return this.field.start(alivePlayers);
    }

    @Override
    public String report() {
        return this.playerRepository.getModels().stream()
                .sorted(Comparator.comparing(Player::getUsername))
                .sorted(Comparator.comparingInt(Player::getHealth).reversed())
                .sorted(Comparator.comparing(f -> f.getClass().getSimpleName()))
                .map(Object::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
