package TrafficLights;

import java.util.Arrays;
import java.util.Scanner;

public
class Main {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        String[] lights = scanner.nextLine ().split ("\\s+");
        int n = Integer.parseInt (scanner.nextLine ());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < lights.length; j++) {
                TrafficLights trafficLights = TrafficLights.valueOf (lights[j]);
                System.out.print (trafficLights + " ");
                lights[j] = trafficLights.toString ();
            }
            System.out.println ();
        }
    }
}
