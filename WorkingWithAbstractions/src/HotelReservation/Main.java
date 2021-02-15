package HotelReservation;

import java.util.Arrays;
import java.util.Scanner;

public
class Main {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        String[] input = scanner.nextLine ().split ("\\s+");

        double pricePerDay = Double.parseDouble (input[0]);
        int days = Integer.parseInt (input[1]);
        String seasonName = input[2].toUpperCase ();
        Season season = Season.valueOf (seasonName);
        String discountName = input[3].toUpperCase ();
        DiscountType discountType = DiscountType.valueOf (discountName);


        PriceCalculator priceCalculator = new PriceCalculator (pricePerDay,days,season,discountType);
        priceCalculator.getPrice ();

    }
}
