package interpreter;

public class ElementoStack {
    Object valor;
    int tipo;

    public ElementoStack(Object valor, int tipo) {
        this.valor = valor;
        this.tipo = tipo;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
