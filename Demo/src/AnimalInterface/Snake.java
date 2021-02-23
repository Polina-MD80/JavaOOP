package AnimalInterface;

import AnimalInterface.Animal;

public
class Snake implements Animal {
    @Override
    public
    void eat () {
        System.out.println ("Eating eggs");
    }
}
