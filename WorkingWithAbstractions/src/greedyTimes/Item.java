package greedyTimes;

public
class Item {
    String name;
    long amount;

    public
    Item (String name, long amount) {
        this.name = name;
        this.amount = amount;
    }

    public
    String getName () {
        return name;
    }

    public
    long getAmount () {
        return amount;
    }

    @Override
    public
    String toString () {
        return String.format ("##%s - %d", this.name , this.amount);
    }
}