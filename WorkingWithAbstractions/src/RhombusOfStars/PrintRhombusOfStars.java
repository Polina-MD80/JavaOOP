package RhombusOfStars;

public
class PrintRhombusOfStars {
    private int n;

    public
    PrintRhombusOfStars (int n) {
        this.n = n;
    }

    public void printTop(){
        for (int i = 1; i <= this.n; i++) {
            printLine (i," ","* ");
        }

    }

    private
    void printLine (int i,String first, String second) {
        for (int j = 1; j <= n - i; j++) {
            System.out.print (first);
        }
        for (int j = 1; j <= i; j++) {
            System.out.print (second);
        }
        System.out.println ();
    }

    public void printBottom(){
        for (int i = 1; i <=n-1; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print (" ");
            }
            for (int j = n-i -1 ; j >= 0 ; j--) {
                System.out.print ("* ");
            }
            System.out.println ();
        }
    }
    public void printRhombus(){
        printTop ();
        printBottom ();
    }
}
