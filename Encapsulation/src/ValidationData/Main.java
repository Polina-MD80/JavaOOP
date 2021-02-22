package ValidationData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public
class Main {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int n = Integer.parseInt (scanner.nextLine ());

        List<Person> people = new ArrayList<> ();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine ().split ("\\s+");
            try {
                Person person = new Person (tokens[0],tokens[1],
                        Integer.parseInt (tokens[2]),Double.parseDouble (tokens[3]));
                people.add (person);

            }catch (IllegalArgumentException e){
                System.out.println (e.getMessage ());
            }

        }
        int bonus = Integer.parseInt (scanner.nextLine ());

        for (Person person : people) {
            person.increaseSalary (bonus);
            System.out.println (person);
        }
    }
}
