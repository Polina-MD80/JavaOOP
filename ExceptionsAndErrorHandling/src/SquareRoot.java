import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Supplier;

public
class SquareRoot {
    public static
    void main (String[] args) {

        Scanner scanner = new Scanner (System.in);

        testSQLException();


        try {
            int n = Integer.parseInt (scanner.nextLine ());
            System.out.println (Math.pow (n, 2.0));
            return;// Finally ще се изпълни при всяко положение, но не и "hohoho"!!!

        } catch (NumberFormatException ex) {
            System.out.println ("Invalid input " + ex.getMessage ());
        } catch (Exception ex) {
           ex.printStackTrace ();
        } finally {
            System.out.println ("Good bye");
        }
        System.out.println ("hohoho");

    }

    private static
    void testSQLException () {
        try {
            throw new SQLException();
        } catch (SQLException sqlEx) {
            throw new IllegalStateException("Cannot save invoice.", sqlEx);
        }

    }
}
