
package GreedyTime;

import java.util.*;

public
class Main {
    public static
    void main (String[] args) {

        Scanner  scanner  = new Scanner (System.in);
        long     capacity = Long.parseLong (scanner.nextLine ());
        String[] safe     = scanner.nextLine ().split ("\\s+");

        LinkedHashMap<String, Map<String, Long>> bag = createTheBag ();

        for (int i = 0; i < safe.length; i += 2) {
            String name   = safe[i];
            long   amount = Long.parseLong (safe[i + 1]);

            long currantSum  = getCurrantSum (bag);
            long currantGold = getSum (bag, "Gold");
            long currantGem  = getSum (bag, "Gem");
            long currantCash = getSum (bag, "Cash");


            putTheItemInTheBag(capacity, bag, name, amount, currantSum, currantGold, currantGem, currantCash);
        }
        printTheTreasuresInTheBag (bag);

    }

    private static
    long getCurrantSum (LinkedHashMap<String, Map<String, Long>> bag) {
        return bag.values ().stream ().map (Map::values).flatMap (Collection::stream).mapToLong (e -> e).sum ();
    }

    private static
    void printTheTreasuresInTheBag (LinkedHashMap<String, Map<String, Long>> bag) {
        for (Map.Entry<String, Map<String, Long>> typeOfTreasure : bag.entrySet ()) {
            if (!typeOfTreasure.getValue ().isEmpty ()) {
                Long sumValues = typeOfTreasure.getValue ().values ().stream ().mapToLong (l -> l).sum ();
                System.out.printf ("<%s> $%s%n", typeOfTreasure.getKey (), sumValues);
                typeOfTreasure.getValue ().entrySet ().stream ().sorted ((e1, e2) -> e2.getKey ().compareTo (e1.getKey ())).forEach (subType -> System.out.printf ("##%s - %d%n", subType.getKey (), subType.getValue ()));

            }

        }
    }


    private static
    LinkedHashMap<String, Map<String, Long>> createTheBag () {
        LinkedHashMap<String, Map<String, Long>> bag = new LinkedHashMap<> (3);
        bag.put ("Gold", new HashMap<> ());
        bag.put ("Gem", new HashMap<> ());
        bag.put ("Cash", new HashMap<> ());
        return bag;
    }

    private static
    void  putTheItemInTheBag(long capacity, LinkedHashMap<String, Map<String, Long>> bag, String name, long amount, long currantSum, long currantGold, long currantGem, long currantCash) {
        if (name.length () == 3) {

            if ((amount + currantCash) <= currantGem && currantSum + amount <= capacity) {
                bag.get ("Cash").putIfAbsent (name, 0L);
                long newAmount = bag.get ("Cash").get (name) + amount;
                bag.get ("Cash").put (name, newAmount);
            }

        } else if (name.toLowerCase ().endsWith ("gem")) {

            if (currantGold >= currantGem + amount && currantSum + amount <= capacity) {
                bag.get ("Gem").putIfAbsent (name, 0L);
                long newAmount = bag.get ("Gem").get (name) + amount;
                bag.get ("Gem").put (name, newAmount);
            }
        } else if (name.equalsIgnoreCase ("gold")) {

            if (currantSum + amount <= capacity) {
                bag.get ("Gold").putIfAbsent ("Gold", 0L);
                long newAmount = bag.get ("Gold").get ("Gold") + amount;
                bag.get ("Gold").put ("Gold", newAmount);
            }
        }
    }

    private static
    long getSum (LinkedHashMap<String, Map<String, Long>> bag, String gold) {
        return bag.get (gold).values ().stream ().mapToLong (e -> e).sum ();
    }
}
