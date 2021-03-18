public
class Square {
    public static double sqrt(double value) {
        if (value < 0)
            throw new IllegalArgumentException(
                    "Sqrt for negative numbers is undefined!");
        return Math.sqrt(value);
    }
    public static void main(String[] args) {
        try {
            System.out.println (sqrt (-1));
        } catch (IllegalArgumentException ex) {
            System.err.println("Error: " + ex.getMessage());
           // ex.printStackTrace();
        }
    }
}
