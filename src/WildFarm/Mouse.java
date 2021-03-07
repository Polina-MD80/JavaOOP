package WildFarm;

public
class Mouse extends Mammal {
    private static final String SOUND = "SQUEEEAAAK!";

    public
    Mouse (String animalType, String animalName, Double animalWeight, String livingRegion) {
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
            System.out.println ("Mice are not eating that type of food!");
        }
    }
}

