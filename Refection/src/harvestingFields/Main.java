package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.stream.Collectors;

public
class Main {
    public static
    void main (String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName ("harvestingFields.RichSoilLand");

        Scanner scanner = new Scanner (System.in);

        String command = scanner.nextLine ();

        Field[]     declaredFields = aClass.getDeclaredFields ();
        List<Field> toPrint        = new LinkedList<> ();
        while (!"HARVEST".equals (command)) {
            for (Field field : declaredFields) {
                if (command.equals ("private") && Modifier.isPrivate (field.getModifiers ())) {
                    toPrint.add (field);
                } else if (command.equals ("protected") && Modifier.isProtected (field.getModifiers ())) {
                    toPrint.add (field);
                } else if (command.equals ("public") && Modifier.isPublic (field.getModifiers ())) {
                    toPrint.add (field);
                } else if (command.equals ("all")){
                	toPrint.add (field);
				}
            }


            command = scanner.nextLine ();
        }
        System.out.println (toPrint.stream ()
                .map (f -> String.format ("%s %s %s", Modifier.toString (f.getModifiers ()), f.getType ().getSimpleName (), f.getName ()))
                .collect (Collectors.joining (System.lineSeparator ())));
    }
}
