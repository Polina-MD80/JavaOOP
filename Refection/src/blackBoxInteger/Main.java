package blackBoxInteger;

import com.sun.jdi.Value;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public
class Main {
    public static
    void main (String[] args) throws ClassNotFoundException, NoSuchMethodException {
        try {
            Class<?>       aClass         = Class.forName ("blackBoxInteger.BlackBoxInt");
            Constructor<?> intConstructor = aClass.getDeclaredConstructor (int.class);
            intConstructor.setAccessible (true);
            Constructor<?> defaultConstructor = aClass.getDeclaredConstructor ();
            defaultConstructor.setAccessible (true);

            BlackBoxInt theTestObject = (BlackBoxInt) defaultConstructor.newInstance ();
            //Method[]    declaredMethods = aClass.getDeclaredMethods ();

            Scanner scanner = new Scanner (System.in);

            String command = scanner.nextLine ();

            while (!"END".equals (command)) {
                String[] tokens     = command.split ("_");
                String   methodName = tokens[0];
                int      parameter  = Integer.parseInt (tokens[1]);
                /*for (Method method : declaredMethods) {
                    method.setAccessible (true);
                    if (method.getName ().equals (methodName)) {
                        method.invoke (theTestObject, parameter);*/
                Method method = aClass.getDeclaredMethod (methodName, int.class);
                method.setAccessible (true);
                method.invoke (theTestObject, parameter);
                Field field = aClass.getDeclaredField ("innerValue");
                field.setAccessible (true);
                System.out.println ((int) field.get (theTestObject));
                command = scanner.nextLine ();
            }
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchFieldException e) {
            e.printStackTrace ();
        }
    }

}



