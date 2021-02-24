package greedyTimes;

public
class Gold extends Item{
    public static long totalGoldAmount = 0;
    private Item item;

    public
    Gold (Item item) {
        super (item.name, item.amount);
        setItem (item);
    }

    public
    Item getItem () {
        return item;
    }

    public
    void setItem (Item item) {
        long tempoBagTotalAmount = Bag.totalBagAmount + item.amount;
        if (tempoBagTotalAmount <= Bag.CAPACITY) {
            totalGoldAmount += item.getAmount ();
            this.item = item;
        }else {
            throw new NullPointerException("Can not put the item in the bag");
        }
    }

    public static
    long getTotalAmount () {
        return totalGoldAmount;
    }

    @Override
    public
    String toString () {
        return String.format ("<Gold> $%d%n##Gold - %d",totalGoldAmount,totalGoldAmount);
    }
}
