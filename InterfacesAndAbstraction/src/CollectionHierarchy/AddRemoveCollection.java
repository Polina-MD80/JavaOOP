package CollectionHierarchy;

public
class AddRemoveCollection extends Collection implements AddRemovable{
    @Override
    public
    String remove () {
        return getItems ().remove (getItems ().size ()-1);
    }

    @Override
    public
    int add (String s) {
        getItems ().add (0, s);
        return 0;
    }
}
