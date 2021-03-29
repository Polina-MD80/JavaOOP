package onlineShop.models.products.computers;

import onlineShop.models.products.BaseProduct;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;

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
    Component removeComponent (String componentType) {

        Component component = components.stream ().findFirst ().filter (c -> c.getClass ().getSimpleName ().equals (componentType)).orElseThrow ();
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
    Peripheral removePeripheral (String peripheralType) {
        return null;
    }

    @Override
    public
    String toString () {
        return "BaseComputer{}";
    }

    //•	DesktopComputer – overall performance is 15
    //•	Laptop – overall performance is 10
    @Override
    public
    double getOverallPerformance () {
        double componentsAverage = components.stream ()
                .mapToDouble (Component::getOverallPerformance)
                .average ().orElse (0);
        return super.getOverallPerformance ()+componentsAverage;
    }

    @Override
    public
    double getPrice () {
        return super.getPrice () +
               components.stream ().mapToDouble (Component::getPrice).sum ()+
               peripherals.stream ().mapToDouble (Peripheral::getPrice).sum ();
    }
}
