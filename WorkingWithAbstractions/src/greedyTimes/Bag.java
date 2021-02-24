package greedyTimes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static greedyTimes.Gold.totalGoldAmount;

public
class Bag {
    public static long totalBagAmount = 0;
    public static long CAPACITY;
    private List<Gold> goldList;
    private List<Gem> gemList;
    private List<Cash> cashList;

    public
    Bag () {
        this.goldList = new ArrayList<> ();
        this.gemList = new ArrayList<> ();
        this.cashList = new ArrayList<> ();
    }

    public
    void addGoldInBag (Gold gold) {
        goldList.add (gold);
        totalBagAmount += gold.getItem ().getAmount ();
    }

    public
    void addGemInBag (Gem gem) {
        gemList.add (gem);
        totalBagAmount += gem.getItem ().getAmount ();
    }

    public
    void addCashInBag (Cash cash) {
        cashList.add (cash);
        totalBagAmount += cash.getItem ().getAmount ();
    }

    public static
    void setTotalBagAmount (long totalBagAmount) {
        Bag.totalBagAmount = totalBagAmount;
    }

    public static
    long getTotalBagAmount () {
        return totalBagAmount;
    }


    @Override
    public
    String toString () {
        StringBuilder sb = new StringBuilder ();
        if (!goldList.isEmpty ()) {
           sb.append (String.format ("<Gold> $%d%n##Gold - %d%n", totalGoldAmount, totalGoldAmount));
            if (!gemList.isEmpty ()) {
                sb.append ("<Gem> $").append (Gem.totalGemAmount);
                gemList.stream ().sorted (Gem::compareTo)
                        .forEach (gem -> sb.append (System.lineSeparator ()).append (gem.toString ()));
                sb.append (System.lineSeparator ());
            }
            if (!cashList.isEmpty ()) {
                sb.append ("<Cash> $").append (Cash.totalCashAmount);
                cashList.stream ().sorted (Cash::compareTo)
                        .forEach (cash -> sb.append (System.lineSeparator ()).append (cash.toString ()));
            }
        }


        return sb.toString ().trim ();
    }


}
