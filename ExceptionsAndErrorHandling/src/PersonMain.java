import java.util.Scanner;

public
class PersonMain {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        while (true) {
            try {
                createPerson (scanner);
                return;
            } catch (IllegalArgumentException ex) {
                System.out.println (ex.getMessage ());
            }

        }
    }

    private static
    void createPerson (Scanner scanner) {
        String firstName = scanner.nextLine ();
        String lastName = scanner.nextLine ();
        int age = Integer.parseInt (scanner.nextLine ());
        Person person = new Person (firstName, lastName, age);
    }
}
