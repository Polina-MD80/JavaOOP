package StackOfStrings;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public
class StackOfStrings {
    private List<String> data;
    public StackOfStrings(){
        this.data = new ArrayList<String> ();
    }

    public void push(String string){
        this.data.add (string);
    }
    public String pop(){
        return this.data.remove (data.size ()-1);
    }
    public String peek(){
        return this.data.get (data.size ()-1);
    }
    public boolean isEmpty(){
        return this.data.isEmpty ();
    }
}
