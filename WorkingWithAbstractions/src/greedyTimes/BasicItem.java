package greedyTimes;

public abstract
class BasicItem implements Item{
    private static long totalAmount ;
    private String name;
    private long amount;

    protected
    BasicItem (String name, long amount) {
        this.name = name;
        this.amount = amount;
    }
    public void addAmount(){
        totalAmount += amount;
    }

    @Override
    public
    String getName () {
        return this.name;
    }

    @Override
    public
    long getAmount () {
        return this.amount;
    }

    @Override
    public
    String toString () {
        return "##"+ name + " - " + amount;
    }
}
