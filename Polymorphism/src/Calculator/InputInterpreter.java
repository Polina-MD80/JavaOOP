package Calculator;

import java.util.Stack;

public
class InputInterpreter {
    private CalculationEngine engine;
    private Stack<Integer> memory;

    public
    InputInterpreter (CalculationEngine engine) {
        this.engine = engine;
        this.memory = new Stack<> ();
    }

    public
    boolean interpret (String input) {
        try {
            engine.pushNumber (Integer.parseInt (input));
        } catch (Exception ex) {
            engine.pushOperation (this.getOperation (input));
        }
        return true;
    }

    public
    Operation getOperation (String operation) {
        if (operation.equals ("*")) {
            return new MultiplicationOperation ();
        }
        if (operation.equals ("/")) {
            return new DivisionOperation ();
        }if (operation.equals ("ms")){
            return new SafeMemoryOperation (memory);
        }if (operation.equals ("mr")){
            return new RecallMemoryOperation (memory);
        }

        return null;
    }
}
