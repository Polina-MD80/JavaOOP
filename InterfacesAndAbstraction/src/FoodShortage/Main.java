package FoodShortage;

import java.util.*;

public
class Main {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        Map<String, Buyer> buyers = new HashMap<> ();

        int n = Integer.parseInt (scanner.nextLine ());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine ().split ("\\s+");

            if (tokens.length == 3) {
                Buyer rebel = new Rebel (tokens[0], Integer.parseInt (tokens[1]), tokens[2]);
                rebel.buyFood ();
                buyers.put (tokens[0], rebel);

            } else {
                Buyer citizen = new Citizen (tokens[0], Integer.parseInt (tokens[1]), tokens[2], tokens[3]);
                citizen.buyFood ();
                buyers.put (tokens[0], citizen);
            }
        }


        String buyerName = scanner.nextLine ();

        int totalFood = 0;

        while (!"End".equals (buyerName)) {

            if (buyers.containsKey (buyerName)) {
                totalFood += buyers.get (buyerName).getFood ();
            }

            buyerName = scanner.nextLine ();
        }

        System.out.println (totalFood);

    }
}
