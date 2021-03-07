package VehiclesExtension;


import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public
class Main {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        double[] carInput = getInput (scanner);
        Vehicle  car      = new Car (carInput[0], carInput[1], carInput[2]);

        double[] truckInput = getInput (scanner);
        Vehicle  truck      = new Truck (truckInput[0], truckInput[1], truckInput[2]);

        double[] busInput = getInput (scanner);
        Bus      bus      = new Bus (busInput[0], busInput[1], busInput[2]);

        Map<String, Vehicle> vehicles = new LinkedHashMap<> ();
        vehicles.put ("Car", car);
        vehicles.put ("Truck", truck);
        vehicles.put ("Bus", bus);

        int n = Integer.parseInt (scanner.nextLine ());

        for (int i = 0; i < n; i++) {
            String   command = scanner.nextLine ();
            String[] tokens  = command.split ("\\s+");
            String   vehicle = tokens[1];
            double   amount  = Double.parseDouble (tokens[2]);


            switch (tokens[0]) {
                case "Drive":
                    vehicles.get (vehicle).drive (amount);
                    break;

                case "Refuel":
                    try {
                        vehicles.get (vehicle).refuel (amount);
                    }catch (IllegalArgumentException ex){
                        System.out.println (ex.getMessage ());
                    }

                    break;
                case "DriveEmpty":
                    bus.setEmpty (false);
                    bus.drive (amount);
                    break;

            }
        }
        System.out.println (car);
        System.out.println (truck);
        System.out.println (bus);


    }

    private static
    double[] getInput (Scanner scanner) {
        return Arrays.stream (scanner.nextLine ().split ("\\s+"))
                .skip (1).mapToDouble (Double::parseDouble).toArray ();
    }
}
