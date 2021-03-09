package CollectionHierarchy;

public
class AddCollection extends Collection implements Addable{

    @Override
    public
    int add (String s) {
        getItems ().add (s);
        return getItems ().indexOf (s);
    }
}
