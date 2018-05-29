package interpreter;

import java.util.Stack;

public class EvaluationStack {
    private Stack<ElementoStack> evalStack;

    public EvaluationStack(){
        this.evalStack= new Stack<ElementoStack>();
    }
    public void pushValue(ElementoStack elemento){
        this.evalStack.push(elemento);
    }
    public int size(){
        return this.evalStack.size();
    }
    public ElementoStack popValue(){
        return this.evalStack.pop();
    }
}
