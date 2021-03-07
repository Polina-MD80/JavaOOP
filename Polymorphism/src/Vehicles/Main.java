package Vehicles;


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
            String vehicle = tokens[1];
            double amount = Double.parseDouble (tokens[2]);


            switch (tokens[0]){
                case "Drive":
                 if (vehicle.equals ("Car")){
                     car.drive (amount);
                 }else {
                     truck.drive (amount);
                 };break;
                case "Refuel":
                    if (vehicle.equals ("Car")){
                        car.refuel (amount);
                    }else {
                        truck.refuel (amount);
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
