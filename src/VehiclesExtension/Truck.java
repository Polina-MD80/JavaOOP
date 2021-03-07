package VehiclesExtension;



public
class Truck extends Vehicle {
    private static final double SUMMER_CORRECTION = 1.6;
    private static final double TANK_CORRECTION = 0.95;
    public
    Truck (double fuelQuantity, double fuelConsumption, double fuelCapacity) {
        super (fuelQuantity , fuelConsumption + SUMMER_CORRECTION, fuelCapacity);
    }

    @Override
    protected
    void refuel (double litres) {
       // setFuelQuantity (getFuelQuantity () + litres* TANK_CORRECTION);
        super.refuel (litres*0.95);
    }
}
