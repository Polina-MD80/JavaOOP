package CounterStriker.repositories;

import CounterStriker.models.guns.Gun;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static CounterStriker.common.ExceptionMessages.INVALID_GUN_REPOSITORY;

public class GunRepository implements Repository<Gun>{
    private Collection<Gun> models;

    public GunRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection<Gun> getModels() {
        return Collections.unmodifiableCollection(this.models);
    }

    @Override
    public void add(Gun model) {
     if (model == null){
         throw new NullPointerException(INVALID_GUN_REPOSITORY);
     }
     this.models.add(model);
    }

    @Override
    public boolean remove(Gun model) {
        String name = model.getName();
        if (findByName(name)!=null){
            models.removeIf(g-> g.getName().equals(name));
            return true;
        }
        return false;
    }

    @Override
    public Gun findByName(String name) {
        return this.models.stream().filter(g->g.getName().equals(name)).findFirst().orElse(null);
    }
}
