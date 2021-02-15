package CardSuit;

import java.util.Scanner;

public
class Main {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        String  input   = scanner.nextLine ();
        System.out.printf ("%s:%n", input);
        if (input.equals ("Card Suits")) {
            for (CardSuite value : CardSuite.values ()) {
                System.out.println (value);
            }
        }else if (input.equals ("Card Ranks")){
            for (CardRank value : CardRank.values ()) {
                System.out.println (value);
            }
        }
    }
}
