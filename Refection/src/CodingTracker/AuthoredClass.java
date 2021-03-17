package CodingTracker;

public
class AuthoredClass {
    public static
    void main (String[] args) {
        Class<AuthoredClass> clazz = AuthoredClass.class;

       Tracker.printMethodsByAuthor (clazz);
    }
    @Author(name = "Gosho")
    public static void printMethodsByAuthor(Class<?> clazz){

    }
    @Author(name= "Gosho")
    public static void doNothing(){

    }
}
