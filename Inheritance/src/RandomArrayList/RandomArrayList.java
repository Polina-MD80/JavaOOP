package RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public
class RandomArrayList <T> extends ArrayList<T> {
    private Random random;

    public RandomArrayList (){
        this.random = new Random ();
    }

    public T getRandomElement(){
        int index = this.random.nextInt (100);
        return super.remove (index);
    }
}
