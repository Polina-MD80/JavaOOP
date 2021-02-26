package greedyTimes;

public
class Gold extends BasicItem {
    public static long totalGoldAmount = 0;


    public
    Gold (String name, long amount) {
        super (name, amount);
    }


    @Override
    public
    int compareTo (BasicItem o) {
        return 0;
    }
}
