package WildFarm;

public
class Zebra extends Mammal{

    public
    Zebra (String animalType, String animalName, Double animalWeight, String livingRegion) {
        super (animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    protected
    void makeSound () {
        System.out.println ("Zs");
    }

    @Override
    protected
    void eat (Food food) {
        if (food instanceof Vegetable) {
            super.eat (food);
        } else {
            System.out.println ("Zebras are not eating that type of food!");
        }
    }
}
