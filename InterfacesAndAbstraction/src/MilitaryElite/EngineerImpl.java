package MilitaryElite;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

public
class EngineerImpl extends SpecialisedSoldierImpl{
    private
    Set<Repair> repairSet;

    protected
    EngineerImpl (int id, String firstName, String lastName, double salary, Corps corps) {
        super (id, firstName, lastName, salary, corps);
        this.repairSet = new LinkedHashSet<> ();
    }
    public  void addRepair(Repair repair){
        this.repairSet.add (repair);
    }

    public Collection<Repair> getRepairSet (){
        return this.repairSet;
    }

    @Override
    public
    String toString () {
        StringBuilder sb = new StringBuilder (super.toString ());
        sb.append (System.lineSeparator ());
        sb.append ("Repairs:").append (System.lineSeparator ());
        this.repairSet.forEach (repair -> sb.append ("  ").append (repair.toString ()).append (System.lineSeparator ()));
        return sb.toString ().trim ();
    }
}
