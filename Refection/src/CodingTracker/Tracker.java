package CodingTracker;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public
class Tracker {
    public static
    void printMethodsByAuthor (Class<?> cl) {
        Map<String, List<String>> methodsByAuthor = new HashMap<> ();
        Method[]                  methods         = cl.getDeclaredMethods ();

        for (Method method : methods) {
            Author annotation = method.getAnnotation (Author.class);
            if (annotation != null) {
                methodsByAuthor
                        .putIfAbsent(annotation.name(), new ArrayList<> ());
                methodsByAuthor
                        .get(annotation.name()).add(method.getName() + "()");
            }

        }

        for (Map.Entry<String, List<String>> entry : methodsByAuthor.entrySet ()) {
            System.out.print (entry.getKey () + ": ");
            System.out.println (entry.getValue ().stream ().map (m -> m).collect (Collectors.joining (", ")));
        }


    }
}