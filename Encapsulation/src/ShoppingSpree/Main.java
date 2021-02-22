package ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public
class Main {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        String[] peopleInfo = scanner.nextLine ().split (";");

        List<Person> people = new ArrayList<> ();

        for (int i = 0; i < peopleInfo.length; i++) {
            String[] personInfo = peopleInfo[i].split ("=");
            String name = personInfo[0];
            double money = Double.parseDouble (personInfo[1].trim ());

            try {
                Person person = new Person (name,money);
                people.add (person);
            }catch (IllegalArgumentException ex){
                System.out.println (ex.getMessage ());
            }
        }

        List<Product> products = new ArrayList<> ();

        String[] productsInfo = scanner.nextLine ().split (";");

        for (int i = 0; i < productsInfo.length; i++) {
            String[] currantProductInfo = productsInfo[i].split ("=");
            String name = currantProductInfo[0];
            double cost = Double.parseDouble (currantProductInfo[1].trim ());

            try {
                Product product = new Product (name,cost);
                products.add (product);
            }catch (IllegalArgumentException ex){
                System.out.println (ex.getMessage ());
            }
        }

        String command = scanner.nextLine ();

        while (!"END".equals (command)){
            String[] tokens = command.split ("\\s+");

            String personName = tokens[0];
            String productName = tokens[1];



            Product productToBy = null;
            for (Product product : products) {
                if (product.getName ().equals (productName)){
                    productToBy = product;
                }
            }


            for (Person person : people) {
                if (person.getName ().equals (personName)){
                    person.byProduct (productToBy);
                }
            }



            command = scanner.nextLine ();
        }

        people.forEach (System.out::println);


    }
}
