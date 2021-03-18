public
class PersonMain {
    public static
    void main (String[] args) {
        try {
            Person person = new Person ("", "Ivanov", 12);
        }catch (IllegalArgumentException ex){
            System.out.println (ex.getMessage ());
        }
    }
}
