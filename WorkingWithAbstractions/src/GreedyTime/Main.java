
package GreedyTime;


public
class Main {

    public static
    void main (String[] args) {
        ConsoleReader myReader = new ConsoleReader ();

        Bag           bag      = new Bag (Long.parseLong (myReader.readLine ()));
        String[] safe = openTheSafe (myReader);

        for (int i = 0; i < safe.length; i += 2) {
            String name   = safe[i];
            long   amount = Long.parseLong (safe[i + 1]);
            bag.putTheItemInTheBagIfPossible (name, amount);
        }
        Bag.printTheTreasuresInTheBag ();

    }


    private static
    String[] openTheSafe (ConsoleReader myReader) {
        return myReader.readLine ().split ("\\s+");
    }

}
