package interpreter;

import java.util.LinkedList;

public class JSON {
    public LinkedList<Data> valores;
    public JSON(LinkedList<Data> valores){
        this.valores = valores;
    }
    public LinkedList<Data> getValores(){
        return valores;
    }
    public void setValores(LinkedList<Data> valores){
        this.valores = valores;
    }
}
