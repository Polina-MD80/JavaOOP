package greedyTimes;

public
class Cash extends Item implements Comparable<Cash>{
    public static long totalCashAmount = 0;
    private Item item;

    public
    Cash (Item item) {
        super (item.name, item.amount);
        setItem (item);
    }

    public
    void setItem (Item item) {
        long tempoCashAmount  = totalCashAmount + item.amount;
        long tempoTotalAmount = Bag.getTotalBagAmount () + item.amount;
        if (tempoCashAmount <= Gem.totalGemAmount && tempoTotalAmount <= Bag.CAPACITY) {
            totalCashAmount += item.getAmount ();
            this.item = item;
        }else {
            throw new NullPointerException("Can not put the item in the bag");
        }
    }

    public
    Item getItem () {
        return item;
    }


    @Override
    public
    int compareTo (Cash other) {
        long result = other.name.compareTo (this.name);
        if (result == 0) {
            result = Long.compare (this.amount,other.amount);
        }
        return (int) result;

    }
}
