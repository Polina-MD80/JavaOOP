
package GreedyTime;


public
class Main {

    public static
    void main (String[] args) {
        ConsoleReader myReader = new ConsoleReader ();
        Parser        parser = new Parser (myReader);

        Bag           bag      = new Bag (parser.parsToLong (myReader));
        String[] safe = parser.split (myReader);

        for (int i = 0; i < safe.length; i += 2) {
            String name   = safe[i];
            long   amount = Long.parseLong (safe[i + 1]);
            bag.putTheItemInTheBagIfPossible (name, amount);
        }
        Bag.printTheTreasuresInTheBag ();

    }


}
