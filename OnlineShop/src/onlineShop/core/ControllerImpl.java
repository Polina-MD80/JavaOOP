package onlineShop.core;

import onlineShop.core.interfaces.Controller;
import onlineShop.models.products.components.*;
import onlineShop.models.products.computers.Computer;
import onlineShop.models.products.computers.DesktopComputer;
import onlineShop.models.products.computers.Laptop;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

import static onlineShop.common.constants.ExceptionMessages.*;
import static onlineShop.common.constants.OutputMessages.*;

public
class ControllerImpl implements Controller {
    private Map<Integer, Computer> computers;
    private Map<Integer, Component> components;

    public
    ControllerImpl () {
        this.computers = new LinkedHashMap<> ();
        components = new LinkedHashMap<> ();
    }

    @Override
    public
    String addComputer (String computerType, int id, String manufacturer, String model, double price) {
        if (computers.containsKey (id)){
            throw new IllegalArgumentException(EXISTING_COMPUTER_ID);
        }
        Computer computer;
        if (!(computerType.equals ("DesktopComputer")||computerType.equals ("Laptop"))){
            throw new IllegalArgumentException (INVALID_COMPUTER_TYPE);
        }
        if (computerType.equals ("DesktopComputer")){
            computer = new DesktopComputer (id,manufacturer,model,price);
        }else {
            computer = new Laptop (id,manufacturer,model,price);
        }
       computers.put (id,computer);
        return String.format (ADDED_COMPUTER,computer.getId ());
    }

    @Override
    public
    String addComponent (int computerId, int id, String componentType, String manufacturer, String model, double price, double overallPerformance, int generation) {

        checkComputerIdExists (computerId);

        if (components.containsKey (id)){
            throw new IllegalArgumentException(EXISTING_COMPONENT_ID);
        }

        Component component;
        switch (componentType){
            case "CentralProcessingUnit":
                component = new CentralProcessingUnit (id,manufacturer,model,price,overallPerformance,generation);
                break;
            case "Motherboard":
                component = new Motherboard (id,manufacturer,model,price,overallPerformance,generation);
                break;
            case "PowerSupply":
                component = new PowerSupply (id,manufacturer,model,price,overallPerformance,generation);
                break;
            case "RandomAccessMemory":
                component = new RandomAccessMemory (id,manufacturer,model,price,overallPerformance,generation);
                break;
            case "SolidStateDrive":
                component = new SolidStateDrive (id,manufacturer,model,price,overallPerformance,generation);
                break;
            case "VideoCard":
                component = new VideoCard (id,manufacturer,model,price,overallPerformance,generation);
                break;
            default:throw new IllegalArgumentException (INVALID_COMPONENT_TYPE);
        }
        components.put (id,component);
        computers.get (computerId).addComponent (component);


        return String.format (ADDED_COMPONENT, componentType,id,computerId);
    }

    @Override
    public
    String removeComponent (String componentType, int computerId) {
        Computer computer = computers.get (computerId);
        Component component;
        component  = computers.get (computerId).getComponents ().stream ().findFirst ()
                .filter (c -> c.getClass ().getSimpleName ().equals (componentType)).orElseThrow ();
        int componentId = component.getId ();

        computer.removeComponent (componentType);

        components.remove (componentId);

        return String.format (REMOVED_COMPONENT,componentType,componentId);

    }

    @Override
    public
    String removePeripheral (String peripheralType, int computerId) {
        return null;
    }

    @Override
    public
    String addPeripheral (int computerId, int id, String peripheralType, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
        return null;
    }

    @Override
    public
    String buyComputer (int id) {
        return null;
    }

    @Override
    public
    String BuyBestComputer (double budget) {
        return null;
    }

    @Override
    public
    String getComputerData (int id) {
        return null;
    }

    private void checkComputerIdExists(int id){
        if (!this.computers.containsKey (id)){
            throw new IllegalArgumentException (NOT_EXISTING_COMPUTER_ID);
        }
    }
}
