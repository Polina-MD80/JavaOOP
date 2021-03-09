package MilitaryElite;

public
enum Corps {

    AIRFORCES("Airforces"),
    MARINES("Marines");

     String caseSensitive;

    Corps (String caseSensitive) {
        this.caseSensitive = caseSensitive;
    }

    @Override
    public
    String toString () {
        return this.caseSensitive;
    }
}
