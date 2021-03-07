package VehiclesExtension;

import java.text.DecimalFormat;

public abstract
class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;
    private double fuelCapacity;

    protected
    Vehicle (double fuelQuantity, double fuelConsumption, double fuelCapacity) {
        setFuelQuantity (fuelQuantity);
        setFuelConsumption (fuelConsumption);
        setFuelCapacity (fuelCapacity);
    }


    public
    void setFuelCapacity (double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public
    double getFuelCapacity () {
        return fuelCapacity;
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
       if (litres<= 0){
           throw new IllegalArgumentException ("Fuel must be a positive number");
       }
       if (this.fuelQuantity + litres > this.fuelCapacity){
           throw new IllegalArgumentException ("Cannot fit fuel in tank");
       }
        this.fuelQuantity += litres;
    }

    @Override
    public
    String toString () {
        return  String.format ("%s: %.2f",getClass ().getSimpleName (), getFuelQuantity ());
    }
}
