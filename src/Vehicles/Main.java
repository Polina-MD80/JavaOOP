package Vehicles;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public
class Main {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        double[] carInput = getInput (scanner);
        Vehicle car = new Car (carInput[0],carInput[1] );

        double[] truckInput = getInput (scanner);
        Vehicle truck = new Truck (truckInput[0],truckInput[1]);

        int n = Integer.parseInt (scanner.nextLine ());

        for (int i = 0; i < n; i++) {
            String command = scanner.nextLine ();
            String[] tokens = command.split ("\\s+");
            String vehicle = tokens[1].toLowerCase ();


            switch (tokens[0]){
                case "Drive":
                 if (vehicle.equals ("car")){
                     car.drive (Double.parseDouble (tokens[2]));
                 }else {
                     truck.drive (Double.parseDouble (tokens[2]));
                 };break;
                case "Refuel":
                    if (vehicle.equals ("car")){
                        car.refuel (Double.parseDouble (tokens[2]));
                    }else {
                        truck.refuel (Double.parseDouble (tokens[2]));
                    }

            }
        }
        System.out.println (car);
        System.out.println (truck);



    }

    private static
    double[] getInput (Scanner scanner) {
        return Arrays.stream (scanner.nextLine ().split ("\\s+"))
                .skip (1).mapToDouble (Double::parseDouble).toArray ();
    }
}
