import java.util.Scanner;

public
class EnterNumbers {
    static boolean isValid = false;
    public static
    void main (String[] args) {

        Scanner scanner = new Scanner (System.in);

        while (!isValid){
            try {
                startTheTask(scanner);
            }catch (NumberFormatException | NumberNotInRangeException ex){
                System.out.println (ex.getMessage ());
            }
        }

    }

    private static
    void startTheTask (Scanner scanner) {
        int n; int m;
        try {
            n = Integer.parseInt (scanner.nextLine ());
            m = Integer.parseInt (scanner.nextLine ());
        }catch (NumberFormatException e){
            throw new NumberFormatException ("Enter valid number format ");
        }
        printNumbersBetweenTheInput(n,m);
    }

    private static
    void printNumbersBetweenTheInput (int n, int m) {
        if (!(n>=0 && n < m && m<=100)){
            throw new NumberNotInRangeException
                    ("Number is not in given range [1..100] or First number is bigger than second one");
        }
        for (int i = n; i <= m; i++) {
            System.out.print (i + " ");
        }
        isValid = true;

    }
}
