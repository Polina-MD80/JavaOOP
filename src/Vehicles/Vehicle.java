package Vehicles;

import java.text.DecimalFormat;

public
class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;

    protected
    Vehicle (double fuelQuantity, double fuelConsumption) {
        setFuelQuantity (fuelQuantity);
        setFuelConsumption (fuelConsumption);
    }

    public
    void setFuelQuantity (double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public
    void setFuelConsumption (double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public
    double getFuelQuantity () {
        return fuelQuantity;
    }

    public
    double getFuelConsumption () {
        return fuelConsumption;
    }

    protected
    void drive (double kilometers) {
        DecimalFormat decimalFormat = new DecimalFormat ("#.##");
        if (this.getFuelQuantity () < this.fuelConsumption * kilometers) {
            System.out.printf ("%s needs refueling%n", getClass ().getSimpleName ());
        } else {
            this.fuelQuantity -= this.fuelConsumption * kilometers;
            System.out.printf ("%s travelled %s km%n", getClass ().getSimpleName (), decimalFormat.format (kilometers));
        }
    }
    protected void refuel(double litres){
       this.fuelQuantity += litres;
    }

    @Override
    public
    String toString () {
        return  String.format ("%s: %.2f",getClass ().getSimpleName (), getFuelQuantity ());
    }
}
