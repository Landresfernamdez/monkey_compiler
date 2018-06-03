package interpreter;

public class FrameElement {
    DataStorage almacen;
    EvaluationStack pila;
    public FrameElement(DataStorage almacen, EvaluationStack pila) {
        this.almacen = almacen;
        this.pila = pila;
    }
    public DataStorage getAlmacen() {
        return almacen;
    }

    public void setAlmacen(DataStorage almacen) {
        this.almacen = almacen;
    }

    public EvaluationStack getPila() {
        return pila;
    }

    public void setPila(EvaluationStack pila) {
        this.pila = pila;
    }
}
