package WildFarm;

public
class Tiger extends Felime{
    private static final String SOUND = "ROAAR!!!";
    public
    Tiger (String animalType, String animalName, Double animalWeight, String livingRegion) {
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
        if (food.getClass ().getSimpleName ().equals ("Meat")) {
            super.setFoodEaten (food.getQuantity ());
        } else {
            System.out.println ("Tigers are not eating that type of food!");
        }
    }
}
