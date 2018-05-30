package interpreter;

public class Parametros {
        int tipo;
        Object valor;
        String nombre;

    public Parametros(int tipo, Object valor, String nombre) {
        this.tipo = tipo;
        this.valor = valor;
        this.nombre = nombre;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
