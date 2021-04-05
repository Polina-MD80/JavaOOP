package bakery.repositories.interfaces;

import bakery.entities.bakedFoods.interfaces.BakedFood;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static bakery.common.ExceptionMessages.FOOD_OR_DRINK_EXIST;

public class FoodRepositoryImpl implements FoodRepository<BakedFood> {
    Collection<BakedFood> models;

    public FoodRepositoryImpl() {
        this.models = new ArrayList<>();
    }

    @Override
    public BakedFood getByName(String name) {
        return this.models.stream().filter(f->f.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Collection<BakedFood> getAll() {
        return Collections.unmodifiableCollection(this.models);
    }

    @Override
    public void add(BakedFood food) {

        this.models.add(food);
    }
}
