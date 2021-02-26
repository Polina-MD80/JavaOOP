package greedyTimes;

public
class Cash extends BasicItem implements Comparable<Gem>{

    public static long totalCashAmount = 0;


    public
    Cash (String name, long amount) {
        super (name, amount);
    }

    public boolean acceptItem(){
        if (Bag.totalBagAmount + getAmount ()<=Bag.CAPACITY && totalCashAmount + getAmount () < Gem.totalGemAmount){
            addAmount ();return true;
        }
        return false;
    }





    @Override
    public
    int compareTo (Gem o) {
        return 0;
    }
}
