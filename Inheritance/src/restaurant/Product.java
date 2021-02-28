package restaurant;

import java.math.BigDecimal;

public
class Product {
    //String name, BigDecimal price
    private String name;
    private BigDecimal price;

    public
    Product (String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public
    String getName () {
        return this.name;
    }

    public
    BigDecimal getPrice () {
        return this.price;
    }
}
