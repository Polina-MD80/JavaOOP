package WildFarm;

import java.util.*;

public
class Main {
    public static
    void main (String[] args) {

        Scanner scanner = new Scanner (System.in);

        List<Animal> animals = new ArrayList<> ();


        String input = scanner.nextLine ();
        while (!"End".equals (input)) {
            String[] tokens = input.split ("\\s+");
            Animal   animal = createAnimal (tokens);

            String[] provideFood = scanner.nextLine ().split ("\\s+");
            Food     food        = createFood (provideFood);

            animal.makeSound ();
            try {
                animal.eat (food);
            }catch (IllegalArgumentException ex){
                System.out.println (ex.getMessage ());
            }
            animals.add (animal);

            input = scanner.nextLine ();
        }
        for (Animal animal : animals) {
            System.out.println (animal);
        }
    }


    private static
    Animal createAnimal (String[] tokens) {
        String animalType   = tokens[0];
        String animalName   = tokens[1];
        Double animalWeight = Double.parseDouble (tokens[2]);
        String livingRegion = tokens[3];
        Animal animal;

        switch (animalType) {
            case "Cat":
                animal = new Cat (animalName, animalType, animalWeight, livingRegion, tokens[4]);
                break;
            case "Tiger":
                animal = new Tiger (animalName, animalType, animalWeight, livingRegion);
                break;
            case "Zebra":
                animal = new Zebra (animalName, animalType, animalWeight, livingRegion);
                break;
            case "Mouse":
                animal = new Mouse (animalName, animalType, animalWeight, livingRegion);
                break;
            default:
                throw new IllegalStateException ("Unexpected value: " + animalType);
        }
        return animal;
    }


    private static
    Food createFood (String[] provideFood) {
        String  foodName   = provideFood[0];
        Integer foodWeight = Integer.parseInt (provideFood[1]);

        return foodName.equals ("Meat") ? new Meat (foodWeight) : new Vegetable (foodWeight);
    }

}
