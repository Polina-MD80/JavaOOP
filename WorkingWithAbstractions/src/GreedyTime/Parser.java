package GreedyTime;

public
class Parser {
    private ConsoleReader myReader;

    public
    Parser (ConsoleReader myReader) {
        this.myReader = myReader;
    }

    public String[] split(ConsoleReader reader){
        return reader.readLine ().split ("\\s+");
    }
    public long parsToLong(ConsoleReader reader){
        return Long.parseLong (reader.readLine ());
    }
}
