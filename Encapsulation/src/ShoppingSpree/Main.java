package ShoppingSpree;

import java.util.*;

public
class Main {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        Map<String, Person> people;
        Map<String,Product> products;
        try {
            people = setPeople (scanner);
            products = setProducts (scanner);
        }catch (IllegalArgumentException ex){
            System.out.println (ex.getMessage ());return;
        }

        String command = scanner.nextLine ();

        while (!"END".equals (command)){
            String[] tokens = command.split ("\\s+");

            people.get (tokens[0]).buyProduct (products.get (tokens[1]));

            command = scanner.nextLine ();
        }


        for (Map.Entry<String, Person> stringPersonEntry : people.entrySet ()) {
            System.out.println (stringPersonEntry.getValue ());
        }


    }

    private static
    Map<String, Product> setProducts (Scanner scanner) {
        Map<String,Product> products = new LinkedHashMap<> ();
        String[] productsInfo = scanner.nextLine ().split (";");
        for (int i = 0; i < productsInfo.length; i++) {
            String[] tokens = productsInfo[i].split ("=");
            Product product = new Product (tokens[0].trim (),Double.parseDouble (tokens[1].trim ()) );
            products.put (tokens[0].trim (),product);
        }
        return products;
    }

    private static
    Map<String, Person> setPeople (Scanner scanner) {
        Map<String,Person> people = new LinkedHashMap<> ();
        String[] peopleInfo = scanner.nextLine ().split (";");
        for (int i = 0; i < peopleInfo.length; i++) {
            String[] tokens = peopleInfo[i].split ("=");
            Person person = new Person (tokens[0].trim (),Double.parseDouble (tokens[1].trim ()) );
            people.put (tokens[0].trim (),person );
        }
        return people;
    }
}
