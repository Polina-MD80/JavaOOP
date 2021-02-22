package jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;


public
class Main {
    static int[][] galaxy;
    static int[] player;
    static int[] evil;
    static long points;

    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        createNewGalaxy (scanner);

        String command = scanner.nextLine ();

        while (!command.equals ("Let the Force be with you")) {
            newPlayer (command);
            newEvil (scanner);
            moveTheEvil ();
            moveThePlayer ();

            command = scanner.nextLine ();
        }

        System.out.println (points);


    }

    private static
    void moveThePlayer () {
        while (player[0] >= 0 && player[1] < galaxy[0].length) {
            if (isInboundGalaxy (player[0],player[1])){
                points += galaxy[player[0]][player[1]];
            }
            player[0]--;
            player[1]++;

        }
    }

    private static
    void moveTheEvil () {
        while (evil[0] >= 0 && evil[1] >= 0) {
            if (isInboundGalaxy (evil[0], evil[1])) {
                galaxy[evil[0]][evil[1]] = 0;
            }
            evil[0]--;
            evil[1]--;
        }
    }

    private static
    boolean isInboundGalaxy (int row, int col) {
        return row >= 0 && row < galaxy.length && col >= 0 && col < galaxy[row].length;
    }

    private static
    void newEvil (Scanner scanner) {
        String command = scanner.nextLine ();
        evil = readCoordinates (command);
    }

    private static
    void newPlayer (String command) {
        player = readCoordinates (command);
    }

    private static
    int[] readCoordinates (String command) {
        return Arrays.stream (command.split (" "))
                .mapToInt (Integer::parseInt).toArray ();
    }

    private static
    void createNewGalaxy (Scanner scanner) {
        String command = scanner.nextLine ();
        int[] dimensions = readCoordinates (command);
        galaxy = new int[dimensions[0]][dimensions[1]];
        fillTheGalaxy ();
    }

    private static
    void fillTheGalaxy () {
        int value = 0;
        for (int i = 0; i < galaxy.length; i++) {
            for (int j = 0; j < galaxy[i].length; j++) {
                galaxy[i][j] = value;
                value++;
            }
        }
    }
}
