package PointPnRectangle;

import java.util.Arrays;
import java.util.Scanner;

public
class Main {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        int[] coordinates = Arrays.stream (scanner.nextLine ().split ("\\s+")).mapToInt (Integer::parseInt).toArray ();
        Rectangle rectangle = new Rectangle (new Point (coordinates[0],coordinates[1]),
                new Point (coordinates[2],coordinates[3]));

        int n = Integer.parseInt (scanner.nextLine ());

        for (int i = 0; i < n; i++) {
            coordinates = Arrays.stream (scanner.nextLine ().split ("\\s+")).mapToInt (Integer::parseInt).toArray ();

            Point pointToCheck = new Point (coordinates[0],coordinates[1]);

            System.out.println (rectangle.contains (pointToCheck));
        }

    }
}
