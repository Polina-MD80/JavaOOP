package Calculator;

import java.util.ArrayDeque;
import java.util.Stack;

public
class SafeMemoryOperation implements Operation {
    private Stack<Integer> memory;


    public
    SafeMemoryOperation (Stack<Integer> memory) {
        this.memory = memory;
    }

    @Override
    public
    void addOperand (int operand) {
        this.memory.push (operand);
    }

    @Override
    public
    int getResult () {
        return this.memory.peek ();
    }

    @Override
    public
    boolean isCompleted () {
        return false;
    }
}
