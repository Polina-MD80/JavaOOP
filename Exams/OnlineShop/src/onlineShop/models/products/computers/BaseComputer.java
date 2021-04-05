package onlineShop.models.products.computers;

import onlineShop.models.products.BaseProduct;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;

import static onlineShop.common.constants.ExceptionMessages.NOT_EXISTING_COMPONENT;
import static onlineShop.common.constants.ExceptionMessages.NOT_EXISTING_PERIPHERAL;

public abstract
class BaseComputer extends BaseProduct implements Computer {

    private List<Component> components;
    private List<Peripheral> peripherals;

    protected
    BaseComputer (int id, String manufacturer, String model, double price, double overallPerformance) {
        super (id, manufacturer, model, price, overallPerformance);
        this.components = new ArrayList<> ();
        this.peripherals = new ArrayList<> ();
    }

    @Override
    public
    List<Component> getComponents () {
        return this.components;
    }

    @Override
    public
    List<Peripheral> getPeripherals () {
        return this.peripherals;
    }

    @Override
    public
    void addComponent (Component component) {
        components.add (component);
    }

    @Override
    public
    Component removeComponent (String componentType) throws IllegalAccessException {

        Component component = components.stream ()
                .filter (c -> c.getClass ().getSimpleName ().equals (componentType))
                .findFirst().orElse(null);
     if (component == null){
         throw new IllegalAccessException(String.format(NOT_EXISTING_COMPONENT, componentType,getClass().getSimpleName(),getId()));
     }
      components.remove (component);

        return component;
    }

    @Override
    public
    void addPeripheral (Peripheral peripheral) {
        peripherals.add (peripheral);

    }

    @Override
    public
    Peripheral removePeripheral (String peripheralType) throws IllegalAccessException {
        Peripheral peripheral = peripherals.stream ()
                .filter (c -> c.getClass ().getSimpleName ().equals (peripheralType))
                .findFirst().orElse(null);
        if (peripheral == null){
            throw new IllegalAccessException(String.format(NOT_EXISTING_PERIPHERAL, peripheralType,getClass().getSimpleName(),getId()));
            //Peripheral {peripheral type} does not exist in {computer type} with Id {id}."
        }
        peripherals.remove (peripheral);

        return peripheral;

    }

    @Override
    public
    double getOverallPerformance () {
        double componentsAverage = components.stream ()
                .mapToDouble (Component::getOverallPerformance)
                .average ().orElse (0);
        return super.getOverallPerformance ()+componentsAverage;
    }
    private double getAveragePeripheralOverallPerformance(){
      return   peripherals.stream().map(Peripheral::getOverallPerformance).mapToDouble(Double::doubleValue).average().orElse(0.00);
    }

    @Override
    public
    double getPrice () {
        return super.getPrice () +
               components.stream ().mapToDouble (Component::getPrice).sum ()+
               peripherals.stream ().mapToDouble (Peripheral::getPrice).sum ();
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(System.lineSeparator());
        sb.append(String.format(" Components (%d):", components.size()));
        sb.append(System.lineSeparator());
        components.forEach(c-> sb.append("  ").append(c.toString()).append(System.lineSeparator()));
        sb.append(String.format(" Peripherals (%d); Average Overall Performance (%.2f):", peripherals.size(), getAveragePeripheralOverallPerformance()));
        sb.append(System.lineSeparator());
        peripherals.forEach(p-> sb.append("  ").append(p.toString()).append(System.lineSeparator()));

       return sb.toString().trim();
    }
}
