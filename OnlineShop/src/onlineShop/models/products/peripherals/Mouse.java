package onlineShop.models.products.peripherals;

public
class Mouse extends BasePeripheral{
    private
    Mouse (int id, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
        super (id, manufacturer, model, price, overallPerformance, connectionType);
    }
}
