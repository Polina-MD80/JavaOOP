public
class Person {
   private String firstName;
   private String lastName;
   private int age;

    public
    Person (String firstName, String lastName, int age) {
        setFirstName (firstName);
        setLastName (lastName);
        setAge (age);
    }

    public
    String getFirstName () {
        return firstName;
    }

    private
    void setFirstName (String firstName) {
        validateName (firstName, "first");
        this.firstName = firstName;
    }

    public
    String getLastName () {
        return lastName;
    }

    private
    void setLastName (String lastName) {
        validateName (lastName, "last");
        this.lastName = lastName;
    }

    public
    int getAge () {
        return age;
    }

    private
    void setAge (int age) {
        if (age<0 || age > 120){
            throw new IllegalArgumentException ("Age should be in range [0... 120]");
        }
        this.age = age;
    }
    private void validateName(String name, String type){
        if (name == null || name.trim ().isEmpty ()){
            throw new IllegalArgumentException ("The " + type + " name cannot be blank or empty");
        }
    }
}
