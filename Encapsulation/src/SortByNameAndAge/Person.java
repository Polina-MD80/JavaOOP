package SortByNameAndAge;

public
class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public
    Person (String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.setSalary (salary);
    }

    public
    String getFirstName () {
        return this.firstName;
    }

    public
    double getSalary () {
        return this.salary;
    }

    public
    String getLastName () {
        return this.lastName;
    }

    public
    void setSalary (double salary) {
        this.salary = salary;
    }

    public
    int getAge () {
        return this.age;
    }

    @Override
    public
    String toString () {
        return String.format ("%s %s gets %s leva", this.getFirstName (), this.getLastName (), this.getSalary ());
    }

    public
    void increaseSalary (double bonus) {
        if (this.getAge () < 30) {
            this.setSalary (this.getSalary () * (1 + bonus / 200));
        }
        this.setSalary (this.getSalary () * (1 + bonus / 100));
    }
}
