package ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

public
class Person {
    private String name;
    private double money;
    private List<Product> products;

    public
    Person (String name, double money) {
        setName (name);
        setMoney (money);
        this.products = new ArrayList<> ();
    }

    private
    void setName (String name) {
        if (name == null || name.trim ().isEmpty ()) {
            throw new IllegalArgumentException ("Name cannot be empty");
        }
        this.name = name;
    }

    public
    String getName () {
        return this.name;
    }

    private
    void setMoney (double money) {
        if (money < 0) {
            throw new IllegalArgumentException ("Money cannot be negative");
        }
        this.money = money;
    }

    @Override
    public
    String toString () {
        StringBuilder sb = new StringBuilder (this.name + " - ");
        if (this.products.isEmpty ()) {
            sb.append ("Nothing bought");
        } else {
            for (int i = 0; i < products.size (); i++) {
                if (i < products.size () - 1) {
                    sb.append (products.get (i).getName ()).append (", ");
                } else sb.append (products.get (i).getName ());
            }
        }
        return sb.toString ();
    }

    public
    void buyProduct (Product product) {
        {
            if (this.money >= product.getCost ()) {
                this.products.add (product);
                this.money -= product.getCost ();
                System.out.printf ("%s bought %s%n", this.name, product.getName ());
            } else {
                System.out.printf ("%s can't afford %s%n", this.name, product.getName ());
            }
        }

    }
}
