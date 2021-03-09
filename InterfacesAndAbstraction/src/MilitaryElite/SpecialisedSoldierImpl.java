package MilitaryElite;

public
class SpecialisedSoldierImpl extends PrivateImpl {
    private Enum<Corps> corps;

    protected
    SpecialisedSoldierImpl (int id, String firstName, String lastName, double salary, Corps corps) {
        super (id, firstName, lastName, salary);
        this.corps = corps;
    }

    @Override
    public
    String toString () {
        return super.toString () + System.lineSeparator () + "Corps: "  + corps.toString ();
    }
}
