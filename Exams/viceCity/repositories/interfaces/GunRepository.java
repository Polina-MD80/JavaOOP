package viceCity.repositories.interfaces;

import viceCity.models.guns.Gun;

import java.util.*;

public class GunRepository implements Repository{
   List<Gun> models;

    public GunRepository() {
        this.models = new LinkedList<>();
    }

    @Override
    public Collection <Gun> getModels() {
        return Collections.unmodifiableList(models);
    }

    @Override
    public void add(Object model) {
        models.add((Gun) model);
    }

    @Override
    public boolean remove(Object model) {
        Gun gun = (Gun) model;
      if (find(gun.getName())!=null){
          models.remove(gun);
          return true;
      }
      return false;
    }

    @Override
    public Object find(String name) {
        return models.stream().filter(g -> g.getName().equals(name)).findFirst().orElse(null);
    }
}
