package StudentSystem;

import java.util.InputMismatchException;
import java.util.Scanner;

public
class Main {
    public static
    void main (String[] args) {
        ConsoleReader myReader = new ConsoleReader ();
        StudentSystem studentSystem = new StudentSystem ();
        InputParser inputParser = new InputParser ();
        String        input;
        while (!"Exit".equals (input = myReader.readLine ())) {
            try {
                studentSystem.ParseCommand (inputParser.parsData (input));
            }catch (InputMismatchException ex){
                System.out.println (ex.getMessage ());
            }
        }
    }
}
