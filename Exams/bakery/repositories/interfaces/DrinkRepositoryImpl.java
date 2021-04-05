package bakery.repositories.interfaces;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.interfaces.Drink;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static bakery.common.ExceptionMessages.FOOD_OR_DRINK_EXIST;

public class DrinkRepositoryImpl implements DrinkRepository<Drink>{
    Collection<Drink> models;

    public DrinkRepositoryImpl() {
        this.models =new ArrayList<>();
    }

    @Override
    public Drink getByNameAndBrand(String drinkName, String drinkBrand) {

        return this.models.stream().filter(d-> d.getName().equals(drinkName)
                &&d.getBrand().equals(drinkBrand)).findFirst().orElse(null);
    }

    @Override
    public Collection<Drink> getAll() {
        return Collections.unmodifiableCollection(this.models);
    }

    @Override
    public void add(Drink drink) {

        this.models.add(drink);
    }
}
