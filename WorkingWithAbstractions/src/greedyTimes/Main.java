
package greedyTimes;


public
class Main {


    public static
    void main (String[] args) {

        ConsoleReader myReader = new ConsoleReader ();
        Bag           bag      = new Bag ();
        Bag.CAPACITY = Long.parseLong (myReader.readLine ());
        String[] safe = myReader.readLine ().split ("\\s+");

        for (int i = 0; i < safe.length; i += 2) {
            String name   = safe[i];
            long   amount = Long.parseLong (safe[i + 1]);
            Item   item   = new Item (name, amount);
            try {
                if (item.getName ().length () == 3) {
                    Cash cash = new Cash (item);
                    bag.addCashInBag (cash);
                } else if (item.getName ().toLowerCase ().endsWith (("gem"))) {
                    Gem gem = new Gem (item);
                    bag.addGemInBag (gem);
                } else if (item.getName ().equalsIgnoreCase ("gold")) {
                    Gold gold = new Gold (item);
                    bag.addGoldInBag (gold);
                }

            } catch (NullPointerException ignored) {
            }
        }
        System.out.println (bag);


    }
}