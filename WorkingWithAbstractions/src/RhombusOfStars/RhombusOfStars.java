package RhombusOfStars;

import java.util.Scanner;

public
class RhombusOfStars {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int n = Integer.parseInt (scanner.nextLine ());
        PrintRhombusOfStars rhombus = new PrintRhombusOfStars (n);
        rhombus.printRhombus ();
    }
}
