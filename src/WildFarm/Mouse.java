package WildFarm;

public
class Mouse extends Mammal {

    public
    Mouse (String animalType, String animalName, Double animalWeight, String livingRegion) {
        super (animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    protected
    void makeSound () {
        System.out.println ("SQUEEEAAAK!");
    }

    @Override
    protected
    void eat (Food food) {
        if (food instanceof Vegetable) {
            super.eat (food);
        } else {
            System.out.println ("Mice are not eating that type of food!");
        }
    }
}

