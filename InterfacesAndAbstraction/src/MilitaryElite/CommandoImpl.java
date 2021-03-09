package MilitaryElite;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public
class CommandoImpl extends SpecialisedSoldierImpl {
    protected Set<Mission> missionsSet;

    protected
    CommandoImpl (int id, String firstName, String lastName, double salary, Corps corps) {
        super (id, firstName, lastName, salary, corps);
        this.missionsSet = new LinkedHashSet<> ();
    }
    public void addMission(Mission mission){
        missionsSet.add (mission);
    }

    public
    Collection<Mission> getMissions(){
        return Collections.unmodifiableSet (this.missionsSet);
    }
    public void completeMission(){

    }

    @Override
    public
    String toString () {
        StringBuilder sb = new StringBuilder (super.toString () + System.lineSeparator ());
        sb.append ("Missions:").append (System.lineSeparator ());
        this.missionsSet.stream()
                .filter (mission -> mission.getMissionState ().toString ().equals ("inProgress"))
                .forEach (mission -> sb.append ("  ").append (mission).append (System.lineSeparator ()));
        return sb.toString ().trim ();
    }
}
