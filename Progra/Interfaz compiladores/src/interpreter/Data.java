package interpreter;

public class Data {
    public Object clave;
    public Object valor;

    public Data(Object clave, Object valor) {
        this.clave = clave;
        this.valor = valor;
    }

    public Object getClave() {
        return clave;
    }

    public void setClave(Object clave) {
        this.clave = clave;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }
}
