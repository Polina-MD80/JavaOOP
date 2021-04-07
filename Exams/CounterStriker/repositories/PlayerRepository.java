package CounterStriker.repositories;

import CounterStriker.models.players.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static CounterStriker.common.ExceptionMessages.INVALID_PLAYER_REPOSITORY;

public class PlayerRepository implements Repository<Player> {
    private Collection<Player> models;

    public PlayerRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection<Player> getModels() {
        return this.models;
    }

    @Override
    public void add(Player model) {
        if (model == null){
            throw new NullPointerException(INVALID_PLAYER_REPOSITORY);
        }
       this.models.add(model);
    }

    @Override
    public boolean remove(Player model) {
        String username = model.getUsername();
        if (findByName(username)!=null){
            this.models.removeIf(player -> player.getUsername().equals(username));
            return true;
        }
        return false;
    }

    @Override
    public Player findByName(String name) {
        return this.models.stream().filter(p->p.getUsername().equals(name)).findFirst().orElse(null);
    }
}
