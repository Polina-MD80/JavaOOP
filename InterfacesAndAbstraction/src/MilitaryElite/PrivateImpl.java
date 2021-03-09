package MilitaryElite;

public
class PrivateImpl extends SoldierImpl{
    private double salary;
    protected
    PrivateImpl (int id, String firstName, String lastName, double salary) {
        super (id, firstName, lastName);
        this.salary = salary;
    }

    public
    double getSalary () {
        return salary;
    }

    @Override
    public
    String toString () {
        return String.format ("%sSalary: %.2f", super.toString (), getSalary ());
    }
}
