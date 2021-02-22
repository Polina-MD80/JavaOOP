package ClassBoxDataValidation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public
class Main {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        List<Double> data = new ArrayList<> ();
        for (int i = 0; i < 3; i++) {
            data.add (Double.parseDouble(scanner.nextLine ()));
        }
        try {

            Box box = new Box (data.get (0),data.get (1),data.get (2));
            System.out.println (box);
        }catch (IllegalArgumentException ex){
            System.out.println (ex.getMessage ());
        }

    }
}
