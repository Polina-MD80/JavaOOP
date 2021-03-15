package HighQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public
class Main {
    public static
    void main (String[] args) throws ClassNotFoundException {
        Class<?> reflection      = Class.forName ("GettersAndSetters.Reflection");
        Method[] declaredMethods = reflection.getDeclaredMethods ();

        Set<Field>  fields  = new TreeSet<> (Comparator.comparing (Field::getName));
        Set<Method> getters = new TreeSet<> (Comparator.comparing (Method::getName));
        Set<Method> setters = new TreeSet<> (Comparator.comparing (Method::getName));

        fields.addAll (Arrays.stream (reflection.getDeclaredFields ())
                .filter (f -> !Modifier.isPrivate (f.getModifiers ()))
                .collect (Collectors.toList ()));

        System.out.println (fields.stream ().map (f -> String.format ("%s must be private!", f.getName ()))
                .collect (Collectors.joining (System.lineSeparator ())));

        for (Method method : declaredMethods) {
            if (method.getName ().startsWith ("get") && !Modifier.isPublic (method.getModifiers ())) {
                getters.add (method);
            } else if (method.getName ().startsWith ("set") && !Modifier.isPrivate (method.getModifiers ())) {
                setters.add (method);
            }
        }

        System.out.println (getters.stream ().map (g -> String.format ("%s have to be public!", g.getName ()))
                .collect (Collectors.joining (System.lineSeparator ())));
        System.out.println (setters.stream ().map (s -> String.format ("%s have to be private!", s.getName ()))
                .collect (Collectors.joining (System.lineSeparator ())));


    }
}
