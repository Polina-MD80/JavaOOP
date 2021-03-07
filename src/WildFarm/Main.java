package WildFarm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public
class Main {
    public static
    void main (String[] args) {

        Scanner scanner = new Scanner (System.in);


        String input = scanner.nextLine ();
        while (!"End".equals (input)) {
            String[] tokens       = input.split ("\\s+");
            String   animalType   = tokens[0];
            String   animalName   = tokens[1];
            Double   animalWeight = Double.parseDouble (tokens[2]);
            String   livingRegion = tokens[3];
            Animal   animal;

            switch (animalType) {
                case "Cat":
                   animal = new Cat (animalType, animalName, animalWeight, livingRegion, tokens[4]);
                    break;
                case "Tiger":
                    animal = new Tiger (animalType, animalName, animalWeight, livingRegion);
                    break;
                case "Zebra":
                    animal = new Zebra (animalType, animalName, animalWeight, livingRegion);
                    break;
                case "Mouse":
                    animal = new Mouse (animalType, animalName, animalWeight, livingRegion);
                    break;
                default:
                    throw new IllegalStateException ("Unexpected value: " + animalType);
            }

            String[] provideFood = scanner.nextLine ().split ("\\s+");
            String   foodName    = provideFood[0];
            Integer  foodWeight  = Integer.parseInt (provideFood[1]);

            Food food;

            if (foodName.equals ("Vegetable")) {
                food = new Vegetable (foodWeight);
            } else {
                food = new Meat (foodWeight);
            }

            animal.makeSound ();
            animal.eat (food);
            System.out.println (animal.toString ());

            input = scanner.nextLine ();
        }
    }

}
