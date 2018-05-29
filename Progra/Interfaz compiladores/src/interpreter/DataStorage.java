package interpreter;

import java.util.LinkedList;

public class DataStorage {
        int ContadorDataStorage=0;
        int nivel=-1;
        private LinkedList<ElementoDataStorage> data;
    public DataStorage()
    {
        this.ContadorDataStorage = 0;
        this.data = new LinkedList<ElementoDataStorage>();
    }
    public void addData(String nombre, Object value,int tipo,int index)
    {
        ElementoDataStorage v = new ElementoDataStorage(nombre,value,index,tipo,this.nivel);
        this.data.add(v);
        this.ContadorDataStorage++;
    }
    public void modifyData(String nombre, Object value,int tipo)
    {
        for(int x=0;x<this.data.size();x++){
            if(this.data.get(x).getName().equals(nombre)){
                this.data.get(x).setTipo(tipo);
                this.data.get(x).setValue(value);
            }
        }
    }
    public ElementoDataStorage getData(int index) {
        return this.data.get(index);
    }
    public ElementoDataStorage getData(String name) {
        for(int x=0;x<this.data.size();x++){
            if(this.data.get(x).getName().equals(name)){
                return this.data.get(x);
            }
        }
        ElementoDataStorage e=new ElementoDataStorage("null",-1,-1,-1,-1);
        return e;
    }
    public ElementoDataStorage devuelve(String name){
        for(int x=0;x<this.data.size();x++){
            if(this.data.get(x)!=null){
                if(this.data.get(x).getName().equals(name)){
                    return this.data.get(x);
                }
            }
        }
        return null;
    }
    public void cleanData(){
        while (this.data.size()!=0)
            this.data.pop();
        this.ContadorDataStorage=0;
    }

    public String toString(){
        String message = new String("");
        message += "****** ESTADO DE DATA STORAGE ******\n";
        if (!this.data.isEmpty()) {
            for (ElementoDataStorage i : this.data) {
                message += i.name + " --> " + i.value.toString() + "\n";
            }
            message += "------------------------------------------";
        } else
            message += "Data Storage is Empty!!";
        return message;
    }

    public void printDataStorage(){
        System.out.println("****** ESTADO DE DATA STORAGE ******\n");
        for (int i = 0; i < this.data.size(); i++) {
            ElementoDataStorage item = this.data.get(i);
            System.out.println(
                    "Name: " + item.getName()+" - "+
                            "Value: " + item.getValue()+" - "+
                            "Type: " + item.getTipo()+" - "+
                            "Index: " + item.getIndex()+" - "+
                            "Level: " + item.getNivel()
            );
        }
    }
    public int getActualStorageIndex(){
        return this.ContadorDataStorage;
    }
    public LinkedList<ElementoDataStorage> getData() {
        return this.data;
    }
}
