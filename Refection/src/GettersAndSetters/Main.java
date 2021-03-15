package GettersAndSetters;

import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public
class Main {
    private static class MethodComparator implements Comparator<Method>{

        @Override
        public
        int compare (Method f, Method s) {
            return f.getName ().compareTo (s.getName ());
        }
    }
    public static
    void main (String[] args) throws ClassNotFoundException {
        Scanner scanner = new Scanner (System.in);

        Class<?> reflection = Class.forName ("GettersAndSetters.Reflection");


        Method[] declaredMethods = reflection.getDeclaredMethods ();


        Set<Method> getters = new TreeSet<> (new MethodComparator ());
        Set<Method> setters = new TreeSet<> (new MethodComparator ());

        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.getName ().startsWith ("get")
            && declaredMethod.getParameterCount ()==0
            && declaredMethod.getReturnType () != void.class){
                getters.add (declaredMethod);
            }else if (declaredMethod.getName ().startsWith ("set")){
                setters.add (declaredMethod);
            }
        }
        System.out.println (getters.stream ().map (g -> String.format ("%s will return class %s",
                g.getName (), g.getReturnType ().toString ().replace ("class ","")))
                .collect (Collectors.joining (System.lineSeparator ())));
        System.out.println (setters.stream ().map (s -> String.format ("%s and will set field of class %s",
                s.getName (), s.getParameterTypes ()[0].toString ().replace ("class ","")))
                .collect (Collectors.joining (System.lineSeparator ())));
    }
}
