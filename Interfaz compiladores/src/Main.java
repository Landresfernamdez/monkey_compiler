import generated.*;
import interfaz.Interfaz;
import listeners.ThrowingErrorListener;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileReader;
import java.util.List;

/**
 * Created by oviquez on 28/2/2018.
 */

public class Main {
    public static void main(String[] args){

        Interfaz i=new Interfaz();
        i.setVisible(true);
        /*Scanner inst = null;
        generated.MonkeyParser parser=null;
        ANTLRInputStream input=null;
        CommonTokenStream tokens = null;
        try {
            input = new ANTLRInputStream(new FileReader("test.txt"));
            inst = new Scanner(input);
            tokens=new CommonTokenStream(inst);
            parser=new generated.MonkeyParser(tokens);
            parser.removeErrorListeners();
            parser.addErrorListener(ThrowingErrorListener.INSTANCE);
        }
        catch(Exception e){System.out.println("No hay archivo");}
        try{
            ParseTree tree =parser.program();
            System.out.println("Compilacion exitosa!!\n");
        }
        catch (RecognitionException e){
            System.out.println("Compilacion fallida!!\n");
        }



        /*List<Token> lista = (List<Token>) inst.getAllTokens();

        for (Token t : lista)

            System.out.println(t.getType() + ":" + t.getText() + "\n");*/


    }
}