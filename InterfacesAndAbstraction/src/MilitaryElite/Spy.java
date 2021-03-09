package MilitaryElite;

public
class Spy extends SoldierImpl{
    private String codeNumber;
    protected
    Spy (int id, String firstName, String lastName,String codeNumber) {
        super (id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    public
    String getCodeNumber () {
        return codeNumber;
    }

    @Override
    public
    String toString () {
        return String.format ("%s%nCode Number: %s",super.toString (),getCodeNumber ()).trim ();
    }
}
