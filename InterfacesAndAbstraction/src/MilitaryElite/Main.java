package MilitaryElite;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public
class Main {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        List<Soldier> soldierList = new LinkedList<> ();

        String line = scanner.nextLine ();
        while (!"End".equals (line)) {
            String[] tokens = line.split ("\\s+");

            try {
                switch (tokens[0]) {
                    case "Private":
                        PrivateImpl privateSoldier = createPrivate (tokens);
                        soldierList.add (privateSoldier);
                        break;
                    case "Spy":
                        Spy spy = createSpy (tokens);
                        soldierList.add (spy);
                        break;
                    case "LeutenantGeneral":
                        LieutenantGeneralImpl lieutenantGeneral = createLieutenant (tokens, soldierList);
                        soldierList.add (lieutenantGeneral);
                        break;
                    case "Commando":
                        CommandoImpl commando = createCommando (tokens);
                        soldierList.add (commando);
                        break;
                    case "Engineer":
                        EngineerImpl engineer = createEngineer (tokens);
                        soldierList.add (engineer);
                        break;
                }
            }catch (IllegalArgumentException ignored){

            }
            line = scanner.nextLine ();
        }
        for (Soldier soldier : soldierList) {
            System.out.println (soldier);
        }

    }


    private static
    CommandoImpl createCommando (String[] tokens) {
        CommandoImpl commando = new CommandoImpl (Integer.parseInt (tokens[1]), tokens[2], tokens[3],
                Double.parseDouble (tokens[4]), Corps.valueOf (tokens[5].toUpperCase ()));
        if (tokens.length > 6) {
            for (int i = 6; i < tokens.length - 1; i += 2) {
                String       missionName  = tokens[i];
                MissionState missionState = MissionState.valueOf (tokens[i + 1].toUpperCase ());
                Mission      mission      = new Mission (missionName, missionState);
                commando.addMission (mission);
            }
        }
        return commando;
    }

    private static
    LieutenantGeneralImpl createLieutenant (String[] tokens, List<Soldier> soldierList) {
        LieutenantGeneralImpl lieutenantGeneral = new LieutenantGeneralImpl (Integer.parseInt (tokens[1]), tokens[2], tokens[3],
                Double.parseDouble (tokens[4]));
        if (tokens.length > 5) {
            for (int i = 5; i < tokens.length; i++) {
                int id = Integer.parseInt (tokens[i]);

                soldierList.forEach (soldier -> {
                    if (soldier instanceof PrivateImpl) {
                        if (soldier.getId () == id) {
                            lieutenantGeneral.addPrivate ((PrivateImpl) soldier);
                        }
                    }
                });

            }
        }
        return lieutenantGeneral;
    }

    private static
    Spy createSpy (String[] tokens) {
        return new Spy (Integer.parseInt (tokens[1]), tokens[2], tokens[3], tokens[4]);
    }

    private static
    PrivateImpl createPrivate (String[] tokens) {
        return new PrivateImpl (Integer.parseInt (tokens[1]), tokens[2], tokens[3],
                Double.parseDouble (tokens[4]));
    }

    private static
    EngineerImpl createEngineer (String[] tokens) {
        EngineerImpl engineer = new EngineerImpl (Integer.parseInt (tokens[1]), tokens[2], tokens[3],
                Double.parseDouble (tokens[4]), Corps.valueOf (tokens[5].toUpperCase ()));
        if (tokens.length > 6) {
            for (int i = 6; i < tokens.length - 1; i += 2) {
                String repairName  = tokens[i];
                int    repairHours = Integer.parseInt (tokens[i + 1]);

                engineer.addRepair (new Repair (repairName, repairHours));
            }
        }
        return engineer;
    }
}
