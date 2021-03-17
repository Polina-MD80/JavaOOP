package MyAnnotationDemo;

public
class MyMethods {

    @SuppressWarnings(value = "unchecked")
    public <
            T> void warning(int size) {
        T[] unchecked = (T[]) new Object[size];
    }
    @Subject(categories = "to be removed")
    @Deprecated
    public void deprecatedMethod() {
        System.out.println("Deprecated!");
    }

}

