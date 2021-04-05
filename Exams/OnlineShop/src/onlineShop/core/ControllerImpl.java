package onlineShop.core;

import onlineShop.core.interfaces.Controller;
import onlineShop.models.products.components.*;
import onlineShop.models.products.computers.Computer;
import onlineShop.models.products.computers.DesktopComputer;
import onlineShop.models.products.computers.Laptop;
import onlineShop.models.products.peripherals.*;

import java.util.Comparator;
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
    private Map<Integer, Peripheral> peripherals;

    public ControllerImpl() {
        this.computers = new LinkedHashMap<>();
        components = new LinkedHashMap<>();
        peripherals = new LinkedHashMap<>();
    }

    @Override
    public String addComputer(String computerType, int id, String manufacturer, String model, double price) {
        if (computers.containsKey(id)) {
            throw new IllegalArgumentException(EXISTING_COMPUTER_ID);
        }
        Computer computer;
        if (!(computerType.equals("DesktopComputer") || computerType.equals("Laptop"))) {
            throw new IllegalArgumentException(INVALID_COMPUTER_TYPE);
        }
        if (computerType.equals("DesktopComputer")) {
            computer = new DesktopComputer(id, manufacturer, model, price);
        } else {
            computer = new Laptop(id, manufacturer, model, price);
        }
        computers.put(id, computer);
        return String.format(ADDED_COMPUTER, computer.getId());
    }

    @Override
    public String addComponent(int computerId, int id, String componentType, String manufacturer, String model, double price, double overallPerformance, int generation) {

        checkComputerIdExists(computerId);

        if (components.containsKey(id)) {
            throw new IllegalArgumentException(EXISTING_COMPONENT_ID);
        }

        Component component;
        switch (componentType) {
            case "CentralProcessingUnit":
                component = new CentralProcessingUnit(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "Motherboard":
                component = new Motherboard(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "PowerSupply":
                component = new PowerSupply(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "RandomAccessMemory":
                component = new RandomAccessMemory(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "SolidStateDrive":
                component = new SolidStateDrive(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "VideoCard":
                component = new VideoCard(id, manufacturer, model, price, overallPerformance, generation);
                break;
            default:
                throw new IllegalArgumentException(INVALID_COMPONENT_TYPE);
        }
        components.put(id, component);
        computers.get(computerId).addComponent(component);


        return String.format(ADDED_COMPONENT, componentType, id, computerId);
    }

    @Override
    public String removeComponent(String componentType, int computerId) throws IllegalAccessException {
        checkComputerIdExists(computerId);
        Computer computer = computers.get(computerId);
        Component component = computer.removeComponent(componentType);
        components.remove(component.getId());
        return String.format(REMOVED_COMPONENT, componentType, component.getId());

    }

    @Override
    public String removePeripheral(String peripheralType, int computerId) throws IllegalAccessException {
        checkComputerIdExists(computerId);
        Computer computer = computers.get(computerId);
        Peripheral peripheral = computer.removePeripheral(peripheralType);
        peripherals.remove(peripheral.getId());
        return String.format(REMOVED_PERIPHERAL, peripheralType, peripheral.getId());

    }

    @Override
    public String addPeripheral(int computerId, int id, String peripheralType,
                                String manufacturer, String model, double price,
                                double overallPerformance, String connectionType) {
        checkComputerIdExists(computerId);
        if (peripherals.containsKey(id)) {
            throw new IllegalArgumentException(EXISTING_PERIPHERAL_ID);
        }
        Peripheral peripheral;
        switch (peripheralType) {
            case "Headset":
                peripheral = new Headset(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Keyboard":
                peripheral = new Keyboard(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Monitor":
                peripheral = new Monitor(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Mouse":
                peripheral = new Mouse(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            default:
                throw new IllegalArgumentException(INVALID_PERIPHERAL_TYPE);
        }
        computers.get(computerId).addPeripheral(peripheral);
        peripherals.put(id, peripheral);

        return String.format(ADDED_PERIPHERAL, peripheralType, id, computerId);
    }

    @Override
    public String buyComputer(int id) {
        checkComputerIdExists(id);
        Computer computer = computers.get(id);
        computers.remove(id);
        return computer.toString();
    }

    @Override
    public String BuyBestComputer(double budget) {
        //Removes the computer with the highest overall performance and with a price, less or equal to the budget, from the collection of computers.
        //If there are not any computers in the collection or the budget is insufficient for any computer, throws an IllegalArgumentException with the message "Can't buy a computer with a budget of ${budget}."
        //If it's successful, it returns toString method on the removed computer.
        Computer computer;
        computer = computers.values().stream().filter(c -> c.getPrice() <= budget)
                .max(Comparator.comparingDouble(Computer::getPrice)).orElse(null);
        if (computer==null){
            throw new IllegalArgumentException(String.format(CAN_NOT_BUY_COMPUTER,budget));
        }
        return buyComputer(computer.getId());
    }

    @Override
    public String getComputerData(int id) {
        //GetComputerData Command
        //Parameters
        //•	id – int
        //Functionality
        //If it's successful, it returns toString method on the computer with the given id.
        checkComputerIdExists(id);
        Computer computer = computers.get(id);
        return computer.toString();
    }

    private void checkComputerIdExists(int id) {
        if (!this.computers.containsKey(id)) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }
    }
}
