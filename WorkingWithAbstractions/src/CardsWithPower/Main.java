package CardsWithPower;

import java.util.Scanner;

public
class Main {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        String rank = scanner.nextLine ();
        String suite = scanner.nextLine ();

        Card card = new Card (Rank.valueOf (rank),Suit.valueOf (suite));
        System.out.println (card);
    }
}
