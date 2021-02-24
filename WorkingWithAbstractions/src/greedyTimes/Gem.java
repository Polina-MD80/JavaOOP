package greedyTimes;

public
class Gem extends Item implements Comparable<Gem> {
    public static long totalGemAmount;
    private Item item;

    public
    Gem (Item item) {
        super (item.name, item.amount);
        setItem (item);
    }

    private
    void setItem (Item item) {

        long tempoGemAmount = item.getAmount () + totalGemAmount;
        if (tempoGemAmount <= Gold.totalGoldAmount &&
            tempoGemAmount >= Cash.totalCashAmount &&
            Bag.totalBagAmount + item.getAmount () <= Bag.CAPACITY) {
            totalGemAmount += item.getAmount ();
            this.item = item;
        } else {
            throw new NullPointerException ("Can not put the item in the bag");
        }

    }

    public
    Item getItem () {
        return item;
    }

    @Override
    public
    String toString () {
        return String.format ("##%s - %d", this.item.getName (), this.item.getAmount ());
    }

    @Override
    public
    int compareTo (Gem other) {
        long result = other.name.compareTo (this.name);
        if (result == 0) {
            result = Long.compare (this.amount,other.amount);
        }
        return (int) result;

    }
}

