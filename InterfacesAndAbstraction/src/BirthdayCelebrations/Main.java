package BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public
class Main {
    public static
    void main (String[] args) {

        Scanner scanner = new Scanner (System.in);

        String input = scanner.nextLine ();

        List<Birthable> liveObjects = new ArrayList<> ();

        while (!"End".endsWith (input)) {
            String[] tokens = input.split ("\\s+");

            switch (tokens[0]) {
                case "Citizen":
                    liveObjects.add (new Citizen (tokens[1], Integer.parseInt (tokens[2]), tokens[3], tokens[4]));
                    break;
                case "Pet":
                    liveObjects.add (new Pet ((tokens[1]), tokens[2]));
                    break;
                case "Robot":
                    Robot robot = new Robot (tokens[1], tokens[2]);
                    break;

            }

            input = scanner.nextLine ();
        }
        String postFix = scanner.nextLine ();
        for (Birthable liveObject : liveObjects) {
            if (liveObject.getBirthDate ().endsWith (postFix)){
                System.out.println (liveObject.getBirthDate ());
            }
        }
    }
}
