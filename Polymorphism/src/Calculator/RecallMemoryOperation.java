package Calculator;

import java.util.Stack;

public
class RecallMemoryOperation implements Operation {
    private
    Stack<Integer> memory;

    public
    RecallMemoryOperation (Stack<Integer> memory) {
        this.memory = memory;
    }

    @Override
    public
    void addOperand (int operand) {

    }

    @Override
    public
    int getResult () {
        return this.memory.pop ();
    }

    @Override
    public
    boolean isCompleted () {

        return this.memory.size () > 0;
    }
}
