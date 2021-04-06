package easterRaces.repositories.interfaces;

import easterRaces.entities.cars.Car;
import easterRaces.entities.drivers.Driver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CarRepository implements Repository<Car> {
    Collection<Car> models;

    public CarRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Car getByName(String name) {
        return models.stream().filter(c-> c.getModel().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Collection<Car> getAll() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(Car model) {
     models.add(model);
    }

    @Override
    public boolean remove(Car model) {
        Car car = models.stream().filter(c-> c.getModel().equals(model.getModel())).findFirst().orElse(null);
        if (car!=null){
            models.remove(car);
            return true;
        }
        return false;
    }
}
