public
class PersonMain {
    public static
    void main (String[] args) {
        try {
            Person person = new Person ("Ivan", "Ivanov", 150);
        }catch (IllegalArgumentException ex){
            System.out.println (ex.getMessage ());
        }
    }
}
