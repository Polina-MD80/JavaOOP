package StackOfStrings;

import java.util.ArrayDeque;
import java.util.Deque;

public
class StackOfStrings {
    private  Deque<String> data;
    public StackOfStrings(){
        this.data = new ArrayDeque<> ();
    }

    public void push(String string){
        this.data.push (string);
    }
    public String pop(){
        return this.data.pop ();
    }
    public String peek(){
        return this.data.peek ();
    }
    public boolean isEmpty(){
        return this.data.isEmpty ();
    }
}