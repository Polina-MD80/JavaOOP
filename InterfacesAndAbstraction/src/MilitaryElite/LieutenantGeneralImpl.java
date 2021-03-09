package MilitaryElite;

import java.util.HashSet;
import java.util.Set;

public
class LieutenantGeneralImpl extends PrivateImpl {
    private Set<PrivateImpl> privateSet;

    protected
    LieutenantGeneralImpl (int id, String firstName, String lastName, double salary) {
        super (id, firstName, lastName, salary);
        this.privateSet = new HashSet<PrivateImpl> ();
    }

    public
    void addPrivate (PrivateImpl privateSoldier) {
        privateSet.add (privateSoldier);
    }

    @Override
    public
    String toString () {
        StringBuilder sb = new StringBuilder (super.toString ());

            sb.append (System.lineSeparator ()).append ("Privates:").append (System.lineSeparator ());
            privateSet.stream ().sorted ((p1, p2) -> Integer.compare (p2.getId (), p1.getId ()))
                    .forEach (p -> sb.append ("  ").append (p).append (System.lineSeparator ()));


        return sb.toString ().trim ();
    }
}

