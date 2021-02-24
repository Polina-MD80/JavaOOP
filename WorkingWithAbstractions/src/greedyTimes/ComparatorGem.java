package greedyTimes;

import java.util.Comparator;

public
class ComparatorGem implements Comparator<Gem> {



    @Override
    public
    int compare (Gem first, Gem second) {
        int result =  Long.compare (second.amount, first.amount);
        if (result==0){
            result = second.name.compareTo (first.name);
        }
        return result;
    }
}
