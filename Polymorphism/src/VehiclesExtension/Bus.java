package VehiclesExtension;

public
class Bus extends Vehicle {
    private static final double SUMMER_CORRECTION = 1.4;
    public boolean isEmpty = false;

    protected
    Bus (double fuelQuantity, double fuelConsumption , double fuelCapacity) {
        super (fuelQuantity, fuelConsumption , fuelCapacity);
    }


    public
    boolean isEmpty () {
        return isEmpty;
    }

    public
    void setEmpty (boolean empty) {
        isEmpty = empty;
    }

    @Override
    public
    void setFuelConsumption (double fuelConsumption) {
        if (isEmpty) {
            super.setFuelConsumption (fuelConsumption );
        }else {
            super.setFuelConsumption (fuelConsumption + SUMMER_CORRECTION);
        }
    }
}
