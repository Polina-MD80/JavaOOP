package FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public
class Main {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        String     input;
        List<Team> teams = new ArrayList<> ();

        while (!"END".equals (input = scanner.nextLine ())) {
            String[] command      = input.split (";");

            switch (command[0]) {
                case "Team":
                    createTeam (teams, command[1]);
                    break;
                case "Add":
                    addPlayer (teams, command,false);
                    break;
                case "Remove":
                    removePlayer (teams, command);
                    break;
                case "Rating":
                    printTheRating (teams, command);
                    break;
            }
        }

    }

    private static
    void printTheRating (List<Team> teams, String[] command) {
        boolean teamIsInList = false;
        for (Team t : teams) {
            if (t.getName ().equals (command[1])) {
                System.out.printf ("%s - %d",t.getName (), t.getRating ());
                teamIsInList = true;
                break;
            }
        }
        if (!teamIsInList) {
            System.out.printf ("Team %s does not exist.", command[1]);
        }
    }

    private static
    void removePlayer (List<Team> teams, String[] command) {
        for (Team t : teams) {
            if (t.getName ().equals (command[1])) {
                try {
                    t.removePlayer (command[2]);
                } catch (IllegalArgumentException ex) {
                    System.out.println (ex.getMessage ());
                }
            }
        }
    }

    private static
    void addPlayer (List<Team> teams, String[] command, boolean teamIsInList) {
        try {
            Player player = new Player (command[2], Integer.parseInt (command[3]), Integer.parseInt (command[4]),
                    Integer.parseInt (command[5]), Integer.parseInt (command[6]), Integer.parseInt (command[7]));

            for (Team t : teams) {
                if (t.getName ().equals (command[1])) {
                    t.addPlayer (player);
                    teamIsInList = true;
                    break;
                }
            }
            if (!teamIsInList) {
                System.out.printf ("Team %s does not exist.", command[1]);
            }
        }catch (IllegalArgumentException ex){
            System.out.println (ex.getMessage ());
        }
    }

    private static
    void createTeam (List<Team> teams, String name) {
        Team team = new Team (name);
        teams.add (team);
    }
}
