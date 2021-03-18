import java.util.Scanner;

public
class Fixing {
    public static
    void main (String[] args) {
        Scanner  scanner  = new Scanner (System.in);
        String[] weekDays = new String[]{"Mon", "Tue", "Wed", "Thur", "Fri"};
        try {
            for (int i = 0; i <= weekDays.length; i++) {
                System.out.println (weekDays[i]);
            }
        }catch (IndexOutOfBoundsException ex){
            System.out.println (ex.getMessage ());
        }
        scanner.nextLine ();
    }
}
