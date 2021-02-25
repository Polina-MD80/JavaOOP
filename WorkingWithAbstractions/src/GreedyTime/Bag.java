package GreedyTime;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public
class Bag {
    private final long capacity;
    private static long currantSum;
    private static long currantGold;
    private static long currantGem;
    private static long currantCash;
    private static LinkedHashMap<String, Map<String, Long>> bagMap;

    public
    Bag (long capacity) {
        this.capacity = capacity;
        bagMap = new LinkedHashMap<> (3);
        bagMap.put ("Gold", new HashMap<> ());
        bagMap.put ("Gem", new HashMap<> ());
        bagMap.put ("Cash", new HashMap<> ());
    }

    public static
    void calculateCurrantSums () {
        currantSum = getCurrantSum ();
        currantGold = getSum ("Gold");
        currantGem = getSum ("Gem");
        currantCash = getSum ("Cash");
    }

    private static
    long getCurrantSum () {
        return bagMap.values ().stream ().map (Map::values).flatMap (Collection::stream).mapToLong (e -> e).sum ();
    }

    private static
    long getSum (String typeOfItem) {
        return bagMap.get (typeOfItem).values ().stream ().mapToLong (e -> e).sum ();
    }

    public
    void putTheItemInTheBagIfPossible (String name, long amount) {
        calculateCurrantSums ();
        if (name.length () == 3) {

            if ((amount + currantCash) <= currantGem && currantSum + amount <= this.capacity) {
                bagMap.get ("Cash").putIfAbsent (name, 0L);
                putItemInMapBag (name, amount, "Cash");
            }

        } else if (name.toLowerCase ().endsWith ("gem")) {

            if (currantGold >= currantGem + amount && currantSum + amount <= this.capacity) {
                bagMap.get ("Gem").putIfAbsent (name, 0L);
                putItemInMapBag (name, amount, "Gem");
            }
        } else if (name.equalsIgnoreCase ("gold")) {

            if (currantSum + amount <= this.capacity) {
                bagMap.get ("Gold").putIfAbsent ("Gold", 0L);
                putItemInMapBag ("Gold", amount, "Gold");
            }
        }
    }

    private static
    void putItemInMapBag (String name, long amount, String cash) {
        long newAmount = bagMap.get (cash).get (name) + amount;
        bagMap.get (cash).put (name, newAmount);
    }

    public static
    void printTheTreasuresInTheBag () {
        for (Map.Entry<String, Map<String, Long>> typeOfTreasure : bagMap.entrySet ()) {
            if (!typeOfTreasure.getValue ().isEmpty ()) {
                Long sumValues = typeOfTreasure.getValue ().values ().stream ().mapToLong (l -> l).sum ();
                System.out.printf ("<%s> $%s%n", typeOfTreasure.getKey (), sumValues);
                typeOfTreasure.getValue ().entrySet ().stream ().sorted ((e1, e2) -> e2.getKey ().compareTo (e1.getKey ())).forEach (subType -> System.out.printf ("##%s - %d%n", subType.getKey (), subType.getValue ()));

            }

        }
    }
}
