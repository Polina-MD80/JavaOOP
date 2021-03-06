package Vehicles;

public
class Truck extends Vehicle{
    private static final double SUMMER_CORRECTION = 1.6;
    private static final double TANK_CORRECTION = 0.95;
    protected
    Truck (double fuelQuantity, double fuelConsumption) {
        super (fuelQuantity , fuelConsumption + SUMMER_CORRECTION);
    }

    @Override
    protected
    void refuel (double litres) {
        setFuelQuantity (getFuelQuantity () + litres* TANK_CORRECTION);
    }
}
