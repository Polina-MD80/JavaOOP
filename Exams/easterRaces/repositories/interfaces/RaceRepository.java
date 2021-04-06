package easterRaces.repositories.interfaces;

import easterRaces.entities.drivers.Driver;
import easterRaces.entities.racers.Race;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class RaceRepository implements Repository<Race> {
    Collection<Race> models;

    public RaceRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Race getByName(String name) {
        return models.stream().filter(r -> r.getName().equals(name))
                .findFirst().orElse(null);
    }

    @Override
    public Collection<Race> getAll() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(Race model) {
        models.add(model);
    }

    @Override
    public boolean remove(Race model) {
        Race race = models.stream().filter(r -> r.getName().equals(model.getName())).findFirst().orElse(null);
        if (race != null) {
            models.remove(race);
            return true;
        }
        return false;
    }
}
