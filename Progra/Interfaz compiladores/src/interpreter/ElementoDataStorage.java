package interpreter;

import java.util.LinkedList;

public class ElementoDataStorage {
        String name;
        Object value;
        int index;
        int tipo;
        int nivel;

    public ElementoDataStorage(String name, Object value, int index, int tipo, int nivel) {
        this.name = name;
        this.value = value;
        this.index = index;
        this.tipo = tipo;
        this.nivel = nivel;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
