package WildFarm;

public
class Zebra extends Mammal{
    private static final String SOUND = "Zs";
    public
    Zebra (String animalType, String animalName, Double animalWeight, String livingRegion) {
        super (animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    protected
    void makeSound () {
        System.out.println (SOUND);
    }

    @Override
    protected
    void eat (Food food) {
        if (food.getClass ().getSimpleName ().equals ("Vegetable")) {
            super.setFoodEaten (food.getQuantity ());
        } else {
            System.out.println ("Zebras are not eating that type of food!");
        }
    }
}
