package Animals;

public abstract
class Animal {
    private String name;
    private String favouriteFood;

    protected
    Animal (String name, String favouriteFood) {
        setName (name);
        setFavouriteFood (favouriteFood);
    }

    private
    void setName (String name) {
        this.name = name;
    }

    public
    String getName () {
        return name;
    }

    public
    String getFavouriteFood () {
        return favouriteFood;
    }

    private
    void setFavouriteFood (String favouriteFood) {
        this.favouriteFood = favouriteFood;
    }
    protected String explainSelf(){
        return String.format ("I am %s and my favourite food is %s", this.getName (),this.getFavouriteFood ());
    }
}
