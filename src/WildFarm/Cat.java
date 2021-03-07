package WildFarm;

import java.text.DecimalFormat;

public
class Cat extends Felime{
    private static final String SOUND = "Meowwww";
    private String breed;
    public
    Cat (String animalType, String animalName, Double animalWeight, String livingRegion, String breed) {
        super (animalType, animalName, animalWeight, livingRegion);
        this.breed = breed;
    }

    public
    String getBreed () {
        return breed;
    }

    @Override
    protected
    void makeSound () {
        System.out.println ("Meowwww");
    }

    @Override
    protected
    void eat (Food food) {
     super.setFoodEaten (food.getQuantity ());
    }

    @Override
    public
    String toString () {

        return String.format ("%s[%s, %s, %s, %s, %d]", getClass ().getSimpleName (), getAnimalName (),
        getBreed (), format ().format (getAnimalWeight ()),getLivingRegion (),getFoodEaten ());
    }
}
