package AnimalInterface;

import AnimalInterface.Animal;
import AnimalInterface.Goat;

import java.util.List;

public
class Main {
    public static
    void main (String[] args) {
        List<Animal> animals = List.of (new Snake (),new Goat (),new Wolf ());
        List<Mammal> mammals = List.of (new Goat (),new Wolf ());

        for (Animal animal : animals) {
            animal.eat ();
        }
        for (Mammal mammal : mammals) {
            mammal.eat ();
            mammal.drinkMilk (10);
        }
    }
}
