package WildFarm;

import java.text.DecimalFormat;

public abstract
class Animal {
    private String animalType;
    private String animalName;
    private Double animalWeight;
    private Integer foodEaten;

    protected
    Animal (String animalType, String animalName, Double animalWeight) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        foodEaten = 0;

    }

    protected
    void setFoodEaten (Integer foodEaten) {
        this.foodEaten += foodEaten;
    }

    public
    Integer getFoodEaten () {
        return foodEaten;
    }

    public
    String getAnimalType () {
        return animalType;
    }

    public
    String getAnimalName () {
        return animalName;
    }

    public
    Double getAnimalWeight () {
        return animalWeight;
    }

    protected abstract
    void makeSound ();

    protected abstract
    void eat (Food food);

    protected
    DecimalFormat format () {
        return new DecimalFormat ("#.#");
    }

    @Override
    public
    String toString () {
        return String.format ("%s[%s, %s, ",getClass ().getSimpleName (),
                getAnimalName (), format ().format (getAnimalWeight ()));
    }
}
