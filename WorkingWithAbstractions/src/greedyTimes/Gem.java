package greedyTimes;

public
class Gem extends BasicItem {
    public static long totalGemAmount;

    public
    Gem (String name, long amount) {
        super (name, amount);
    }


    @Override
    public
    int compareTo (BasicItem o) {
        return 0;
    }
}

