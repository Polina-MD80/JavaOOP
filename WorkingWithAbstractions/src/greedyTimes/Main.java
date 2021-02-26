
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

            try {
                if (name.length () == 3) {
                    Cash cash = new Cash (name,amount);
                    if (cash.acceptItem ()){
                    bag.addCashInBag (cash);}
                } else if (name.toLowerCase ().endsWith (("gem"))) {
                    Gem gem = new Gem (name,amount);
                    bag.addGemInBag (gem);
                } else if (name.equalsIgnoreCase ("gold")) {
                    Gold gold = new Gold (name,amount);
                    bag.addGoldInBag (gold);
                }

            } catch (NullPointerException ignored) {
            }
        }
        System.out.println (bag);


    }
}