package FirstAndReserveTeam;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public
class Main {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int     n       = Integer.parseInt (scanner.nextLine ());
        Team    team    = new Team ("Black Eagle");
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine ().split ("\\s+");
            Person   person = new Person (tokens[0], tokens[1], Integer.parseInt (tokens[2]), Double.parseDouble (tokens[3]));
            team.addPlayer (person);
        }
        System.out.printf ("First team have %d players%n", team.getFirstTeam ().size ());
        System.out.printf ("Reserve team have %d players", team.getReserveTeam ().size ());

    }

}
