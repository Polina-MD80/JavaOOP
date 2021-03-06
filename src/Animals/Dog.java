package Animals;

public
class Dog extends Animal{
    protected
    Dog (String name, String favouriteFood) {
        super (name, favouriteFood);
    }

    @Override
    protected
    String explainSelf () {
        return String.format ("%s%nDJAAF",super.explainSelf ());
    }
}
