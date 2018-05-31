package interpreter;

import generated.MonkeyParser;
import generated.MonkeyParserBaseVisitor;
import interfaz.Interfaz;
import checker.checker;
import java.util.LinkedList;

public class Interpreter extends MonkeyParserBaseVisitor {
    public static DataStorage almacen =new DataStorage();
    public static EvaluationStack pila=new EvaluationStack();
    public static String resultadoPush="";
    int indicePila=0;
    int indiceAlmacen=0;
    boolean arrayfunctions=false;
    int tipo_Boolean_true=1;
    int tipo_Boolean_false=111;
    int tipo_Entero=2;
    int tipo_String=3;
    int tipo_Identifier=4;
    int tipo_ArrayLiteral=5;
    int tipo_ArrayFunctions=6;
    int tipo_NULL=13;
    int tipoError=-1;
    int tipo_HashLiteral=12;
    int tipoFnLEN=7;
    int tipoFnFIRST=8;
    int tipoFnLAST=9;
    int tipoFnREST=10;
    int tipoFnPUSH=11;
    int tipoNeutro=0;
    String identifierParametro="";
    @Override
    public Object visitProgram_monkey(MonkeyParser.Program_monkeyContext ctx){
        for(MonkeyParser.StatementContext ele:ctx.statement())
            visit(ele);
        return null;
    }

    @Override
    public Object visitStatement_let_monkey(MonkeyParser.Statement_let_monkeyContext ctx) {
        visit(ctx.letStatement());
        return null;
    }

    @Override
    public Object visitStatement_return_monkey(MonkeyParser.Statement_return_monkeyContext ctx) {
        visit(ctx.returnStatement());
        return null;
    }

    @Override
    public Object visitStatement_expressionStatement_monkey(MonkeyParser.Statement_expressionStatement_monkeyContext ctx) {
        visit(ctx.expressionStatement());
        return null;

    }

    public boolean existe(String name){
        for(int x=0;x<this.almacen.getData().size();x++){
            if(this.almacen.getData().get(x).getName().equals(name)){
                return true;
            }
        }
        return false;
    }
    @Override
    public Object visitLetStatement_monkey(MonkeyParser.LetStatement_monkeyContext ctx) {
        visit(ctx.expression());
        //sacar de la pila
        if(this.pila.size()>0){
            ElementoStack el = this.pila.popValue();
            boolean existe=existe(((MonkeyParser.IdASTContext)ctx.identifier()).ID().getText());
            if(existe==true){
                this.almacen.modifyData(((MonkeyParser.IdASTContext)ctx.identifier()).ID().getText(),el.getValor(),el.getTipo());
                this.almacen.printDataStorage();
            }else{
                this.almacen.addData(((MonkeyParser.IdASTContext)ctx.identifier()).ID().getText(),el.getValor(),el.getTipo(),this.almacen.getActualStorageIndex());
                this.almacen.printDataStorage();
            }
        }
        return null;
    }
    @Override
    public Object visitReturnStatement_monkey(MonkeyParser.ReturnStatement_monkeyContext ctx) {
        visit(ctx.expression());
        return null;
    }

    @Override
    public Object visitExpressionStatement_monkey(MonkeyParser.ExpressionStatement_monkeyContext ctx) {
        visit(ctx.expression());
        return null;
    }

    @Override
    public Object visitExpression_monkey(MonkeyParser.Expression_monkeyContext ctx) {
        visit(ctx.additionExpression());
        visit(ctx.comparison());
        return null;
    }

    @Override
    public Object visitComparisonLess_monkey(MonkeyParser.ComparisonLess_monkeyContext ctx) {
        for(MonkeyParser.AdditionExpressionContext ele:ctx.additionExpression())
            visit(ele);
        return null;
    }

    @Override
    public Object visitComparisonPlus_monkey(MonkeyParser.ComparisonPlus_monkeyContext ctx) {
        for(MonkeyParser.AdditionExpressionContext ele:ctx.additionExpression())
            visit(ele);
        return null;
    }

    @Override
    public Object visitComparisonLessEqual_monkey(MonkeyParser.ComparisonLessEqual_monkeyContext ctx) {
        for(MonkeyParser.AdditionExpressionContext ele:ctx.additionExpression())
            visit(ele);
        return null;
    }

    @Override
    public Object visitComparisonPlusEqual_monkey(MonkeyParser.ComparisonPlusEqual_monkeyContext ctx) {
        for(MonkeyParser.AdditionExpressionContext ele:ctx.additionExpression())
            visit(ele);
        return null;
    }

    @Override
    public Object visitComparisonEqualEqual_monkey(MonkeyParser.ComparisonEqualEqual_monkeyContext ctx) {
        for(MonkeyParser.AdditionExpressionContext ele:ctx.additionExpression())
            visit(ele);
        return null;
    }

    @Override
    public Object visitAdittionExpression_monkey(MonkeyParser.AdittionExpression_monkeyContext ctx) {
        visit(ctx.multiplicationExpression());
        visit(ctx.additionFactor());
        return null;
    }
    private Integer OperarNumeros(Integer v1, Integer v2,String operacion){
        Integer res=new Integer(0);
        if (operacion=="+"){
            res = v1 + v2;
        }
        else if (operacion=="-"){
            res = v2 - v1;
        }
        else if(operacion=="*"){
            res=v1*v2;
        }
        else if(operacion=="/"){
            res=v2/v1;
        }
        return res;
    }
    private boolean existanComillas(String cadena){
        for(int x=0;x<cadena.length();x++){
            if(cadena.charAt(x)=='"'){
                return true;
            }

        }
        return false;
    }
    private String Concatenar(String v1, String v2){
        String res=new String();
        res=v2+v1;
        while (existanComillas(res)){
            for(int x=0;x<res.length();x++){
                if(res.charAt(x)=='"'){
                    res=res.substring(0,x)+res.substring(x+1,res.length());
                }
            }
        }
        return res;
    }
    @Override
    public Object visitAdittionFactorSUMA_monkey(MonkeyParser.AdittionFactorSUMA_monkeyContext ctx) {
        int largo=ctx.multiplicationExpression().size();
        for(int i=0; i<largo;i++){
            //validar si es suma o resta dependiendo del size de la lista de token suma o resta
                visit(ctx.multiplicationExpression(i));
                ElementoStack elemento1=this.pila.popValue();
                ElementoStack elemento2=this.pila.popValue();
                if(elemento1.getTipo()==tipo_String && elemento2.getTipo()==tipo_String){
                        String resultado=Concatenar((String) elemento1.getValor(),(String)elemento2.getValor());
                        Object resulto=(Object)resultado;
                        System.out.println("Resultado="+resultado);
                        this.pila.pushValue(new ElementoStack(resulto,tipo_String));
                }
                else if((elemento1.getTipo()!=tipo_String && elemento2.getTipo()==tipo_String)|(elemento1.getTipo()==tipo_String && elemento2.getTipo()!=tipo_String)){
                        Interfaz.msjsError.add("Error de tipos en la operacion, no se pueden sumar enteros con strings");
                }
                else{
                        int resultado=OperarNumeros((Integer)elemento1.getValor(),(Integer)elemento2.getValor(),"+");
                        Object resulto=(Object)resultado;
                        System.out.println("Resultado="+resultado);
                        this.pila.pushValue(new ElementoStack(resulto,tipo_Entero));
                    }
        }
        return null;
    }
    @Override
    public Object visitAdittionFactorRESTA_monkey(MonkeyParser.AdittionFactorRESTA_monkeyContext ctx) {
        int largo=ctx.multiplicationExpression().size();
        for(int i=0; i<largo;i++){
            //validar si es suma o resta dependiendo del size de la lista de token suma o resta
            visit(ctx.multiplicationExpression(i));
            ElementoStack elemento1=this.pila.popValue();
            ElementoStack elemento2=this.pila.popValue();
            if((elemento1.getTipo()!=tipo_String && elemento2.getTipo()==tipo_String)|(elemento1.getTipo()==tipo_String && elemento2.getTipo()!=tipo_String)){
                    Interfaz.msjsError.add("Error de tipos en la operacion, no se pueden sumar enteros con strings");
                }
            else{
                    int resultado=OperarNumeros((Integer)elemento1.getValor(),(Integer)elemento2.getValor(),"-");
                    Object resulto=(Object)resultado;
                    System.out.println("Resultado="+resultado);
                    this.pila.pushValue(new ElementoStack(resulto,tipo_Entero));
                }

        }
        return null;
    }
    @Override
    public Object visitMultiplicationExpression_monkey(MonkeyParser.MultiplicationExpression_monkeyContext ctx) {
        visit(ctx.elementExpression());
        visit(ctx.multiplicationFactor());
        return null;
    }
    @Override
    public Object visitMultiplicationFactorMUL_monkey(MonkeyParser.MultiplicationFactorMUL_monkeyContext ctx) {
        int largo=ctx.elementExpression().size();
        for(int i=0; i<largo;i++){
            //validar si es suma o resta dependiendo del size de la lista de token suma o resta
            visit(ctx.elementExpression(i));
            ElementoStack elemento1=this.pila.popValue();
            ElementoStack elemento2=this.pila.popValue();
                if((elemento1.getTipo()!=tipo_String && elemento2.getTipo()==tipo_String)|(elemento1.getTipo()==tipo_String && elemento2.getTipo()!=tipo_String)){
                    Interfaz.msjsError.add("Error de tipos en la operacion, no se pueden sumar enteros con strings");
                }
                else{
                    int resultado=OperarNumeros((Integer)elemento1.getValor(),(Integer)elemento2.getValor(),"*");
                    Object resulto=(Object)resultado;
                    System.out.println("Resultado="+resultado);
                    this.pila.pushValue(new ElementoStack(resulto,tipo_Entero));
                }
        }
        return null;
    }
    @Override
    public Object visitMultiplicationFactorDIV_monkey(MonkeyParser.MultiplicationFactorDIV_monkeyContext ctx) {
        int largo=ctx.elementExpression().size();
        for(int i=0; i<largo;i++){
            //validar si es suma o resta dependiendo del size de la lista de token suma o resta
            visit(ctx.elementExpression(i));
            ElementoStack elemento1=this.pila.popValue();
            ElementoStack elemento2=this.pila.popValue();
            if((elemento1.getTipo()!=tipo_String && elemento2.getTipo()==tipo_String)|(elemento1.getTipo()==tipo_String && elemento2.getTipo()!=tipo_String)){
                    Interfaz.msjsError.add("Error de tipos en la operacion, no se pueden sumar enteros con strings");
                }
            else{
                    int resultado=OperarNumeros((Integer)elemento1.getValor(),(Integer)elemento2.getValor(),"/");
                    Object resulto=(Object)resultado;
                    this.pila.pushValue(new ElementoStack(resulto,tipo_Entero));
                }
        }
        return null;
    }
    public ElementoStack devuelveElementoLista(String variable,int position){
        ElementoDataStorage elemento=this.almacen.devuelve(variable);
        LinkedList<ElementoStack> lista= (LinkedList<ElementoStack>) elemento.getValue();
        for(int x=0;x<lista.size();x++){
            if(x==position){
                return lista.get(x);
            }
        }
        return null;
    }
    public ElementoStack devuelveElementoJSON(String variable,ElementoStack clave){
        ElementoDataStorage elemento=this.almacen.devuelve(variable);
        JSON json= (JSON) elemento.getValue();
        LinkedList<Data> lista= json.getValores();
        for(int x=0;x<lista.size();x++){
            ElementoStack elemento1= (ElementoStack) lista.get(x).getClave();
            ElementoStack elemento2= (ElementoStack) lista.get(x).getValor();
            System.out.println(elemento1.getValor()+","+clave.getValor());
            if(elemento1.getValor().equals(clave.getValor())){
                return elemento2;
            }
        }
        return null;
    }
    @Override
    public Object visitElementExprssionPEElementAccess_monkey(MonkeyParser.ElementExprssionPEElementAccess_monkeyContext ctx) {
        if(existe(ctx.primitiveExpression().getText())){
            visit(ctx.primitiveExpression());
            String elemento= (String) visit(ctx.elementAccess());
            if(this.almacen.devuelve(ctx.primitiveExpression().getText()).getTipo()==tipo_ArrayLiteral){
                String variable=ctx.primitiveExpression().getText();
                ElementoStack elementoPila=this.pila.popValue();
                Integer indiceLista= (Integer) elementoPila.getValor();
                this.pila.popValue();
                ElementoStack element=devuelveElementoLista(variable,indiceLista);
                if(element==null){
                    Interfaz.msjsError.add("EL indice accesado se sale de los limites de la lista ->"+variable+"[]");
                }
                else{
                    this.pila.pushValue(new ElementoStack(element,elementoPila.getTipo()));
                }
            }
            else if(this.almacen.devuelve(ctx.primitiveExpression().getText()).getTipo()==tipo_HashLiteral){
                String variable=ctx.primitiveExpression().getText();
                ElementoStack elementoPila=this.pila.popValue();
                ElementoStack clave=elementoPila;
                this.pila.popValue();
                ElementoStack element=devuelveElementoJSON(variable,clave);
                if(element==null){
                    Interfaz.msjsError.add("La clave accesada no existe en el JSON ->"+variable+"{}");
                }
                else{
                    this.pila.pushValue(new ElementoStack(element.getValor(),elementoPila.getTipo()));
                }
            }
        }
        else{
            Interfaz.msjsError.add("No existe la variable "+ctx.primitiveExpression().getText());
        }
        return null;
    }

    @Override
    public Object visitElementExprssionPECallExpression_monkey(MonkeyParser.ElementExprssionPECallExpression_monkeyContext ctx) {
        visit(ctx.primitiveExpression());
        visit(ctx.callExpression());
        return null;
    }

    @Override
    public Object visitElementExpressionPE_monkey(MonkeyParser.ElementExpressionPE_monkeyContext ctx) {
        visit(ctx.primitiveExpression());
        return null;
    }

    @Override
    public Object visitElementAcces_monkey(MonkeyParser.ElementAcces_monkeyContext ctx) {
        visit(ctx.expression());
        return ctx.expression().getText();
    }

    @Override
    public Object visitCallExpression_monkey(MonkeyParser.CallExpression_monkeyContext ctx) {
        visit(ctx.expressionList());
        return null;
    }

    @Override
    public Object visitPEInteger_monkey(MonkeyParser.PEInteger_monkeyContext ctx) {
        this.pila.pushValue(new ElementoStack(Integer.parseInt(ctx.getText()),tipo_Entero));
        return null;
    }
    @Override
    public Object visitPEString_monkey(MonkeyParser.PEString_monkeyContext ctx){
        this.pila.pushValue(new ElementoStack(ctx.getText(),tipo_String));
        return null;
    }
    @Override
    public Object visitPEIdentifier_monkey(MonkeyParser.PEIdentifier_monkeyContext ctx) {
        visit(ctx.identifier());
        return null;
    }

    @Override
    public Object visitPETrue_monkey(MonkeyParser.PETrue_monkeyContext ctx) {
        this.pila.pushValue(new ElementoStack(true,tipo_Boolean_true));
        return null;
    }

    @Override
    public Object visitPEFalse_monkey(MonkeyParser.PEFalse_monkeyContext ctx) {
        this.pila.pushValue(new ElementoStack(false,tipo_Boolean_false));
        return null;
    }
    @Override
    public Object visitPEExpression_monkey(MonkeyParser.PEExpression_monkeyContext ctx) {
        visit(ctx.expression());
        return null;
    }

    @Override
    public Object visitPEArrayLiteral_monkey(MonkeyParser.PEArrayLiteral_monkeyContext ctx) {
       // this.pila.pushValue(new ElementoStack(ctx.getText(),tipo_ArrayLiteral));
        visit(ctx.arrayLiteral());
        return null;
    }
    String idLista="";
    @Override
    public Object visitPEArrayFunctions_monkey(MonkeyParser.PEArrayFunctions_monkeyContext ctx) {
        arrayfunctions=true;
        int tipo=(Integer)visit(ctx.arrayFunctions());
        visit(ctx.expressionList());
        ///Imprimir lista de parametros
        LinkedList<Object> parametros= (LinkedList<Object>) this.pila.popValue().getValor();
        if(tipo==tipoFnPUSH){
            if(2==parametros.size()){
                ElementoStack elemento1= (ElementoStack) parametros.get(0);
                ElementoStack elemento2= (ElementoStack) parametros.get(1);
                if(elemento1.getTipo()==tipo_ArrayLiteral){
                    LinkedList<ElementoStack> lista= (LinkedList<ElementoStack>) elemento1.getValor();
                    lista.add(elemento2);
                    this.almacen.modifyData(identifierParametro,lista,tipo_ArrayLiteral);
                    String listaConcatena="[";
                    Object temporal="";
                    for(int j=0;j<lista.size();j++){
                        temporal= lista.get(j).valor;
                        if(lista.get(j).getTipo()==tipo_HashLiteral){
                            JSON json= (JSON) lista.get(j).getValor();
                            System.out.println(json.getClass().getName().toString());
                            LinkedList<Data> lista1= json.getValores();
                            String listaConcatenar="{";
                            for(int i=0;i<lista1.size();i++){
                                if(i!=lista1.size()-1){
                                    ElementoStack clave= (ElementoStack) lista1.get(i).getClave();
                                    ElementoStack valor=(ElementoStack) lista1.get(i).getValor();
                                    listaConcatenar=listaConcatenar+clave.getValor()+":"+valor.getValor()+",";
                                }
                                else{
                                    ElementoStack clave= (ElementoStack) lista1.get(i).getClave();
                                    ElementoStack valor=(ElementoStack) lista1.get(i).getValor();
                                    listaConcatenar=listaConcatenar+clave.getValor()+":"+valor.getValor()+"}";
                                }
                            }
                            System.out.println("Prueba entro"+listaConcatenar);
                            temporal=listaConcatenar;
                        }
                        if(j!=lista.size()-1){
                            listaConcatena=listaConcatena+temporal+",";
                        }
                        else{
                            listaConcatena=listaConcatena+temporal+"]";
                        }
                    }
                    resultadoPush=listaConcatena;
                    this.almacen.printDataStorage();
                }
                else{
                    Interfaz.msjsError.add("El primer elmento de el push debe ser una lista");
                }
            }
            else{
                Interfaz.msjsError.add("Error, la funcion push debe tener "+2+ " parametros");
            }
        }
        System.out.println("Cantidad de parametros:"+parametros.size());
        return null;
    }
    @Override
    public Object visitPEFunctionsLiteral_monkey(MonkeyParser.PEFunctionsLiteral_monkeyContext ctx) {
        visit(ctx.functionLiteral());
        //this.pila.pushValue(new ElementoStack(ctx.getText(),0));
        return null;
    }
    @Override
    public Object visitPEHashLiteral_monkey(MonkeyParser.PEHashLiteral_monkeyContext ctx) {
        visit(ctx.hashLiteral());
        //this.pila.pushValue(new ElementoStack(ctx.getText(),tipo_HashLiteral));
        return null;
    }

    @Override
    public Object visitPEPrintExpression_monkey(MonkeyParser.PEPrintExpression_monkeyContext ctx) {
        visit(ctx.printExpression());
        return null;
    }
    @Override
    public Object visitPEIfExpression_monkey(MonkeyParser.PEIfExpression_monkeyContext ctx) {
        visit(ctx.ifExpression());
        return null;
    }
    @Override
    public Object visitArrayFunctionsLEN_monkey(MonkeyParser.ArrayFunctionsLEN_monkeyContext ctx) {
        return tipoFnLEN;
    }

    @Override
    public Object visitArrayFunctionsFIRST_monkey(MonkeyParser.ArrayFunctionsFIRST_monkeyContext ctx) {
        return tipoFnFIRST;
    }

    @Override
    public Object visitArrayFunctionsLAST_monkey(MonkeyParser.ArrayFunctionsLAST_monkeyContext ctx) {
        return tipoFnLAST;
    }

    @Override
    public Object visitArrayFunctionsREST_monkey(MonkeyParser.ArrayFunctionsREST_monkeyContext ctx) {
        return tipoFnREST;
    }

    @Override
    public Object visitArrayFunctionsPUSH_monkey(MonkeyParser.ArrayFunctionsPUSH_monkeyContext ctx) {
        return tipoFnPUSH;
    }

    @Override
    public Object visitArrayLiteral_monkey(MonkeyParser.ArrayLiteral_monkeyContext ctx) {
        visit(ctx.expressionList());
        return null;
    }
    @Override
    public Object visitFunctionLiteral_monkey(MonkeyParser.FunctionLiteral_monkeyContext ctx) {
        visit(ctx.functionParameters());
        visit(ctx.blockStatement());
        return null;
    }

    @Override
    public Object visitFunctionParameters_monkey(MonkeyParser.FunctionParameters_monkeyContext ctx) {
        visit(ctx.moreIdentifiers());
        return null;
    }
    @Override
    public Object visitMoreIdentifiers_monkey(MonkeyParser.MoreIdentifiers_monkeyContext ctx) {
        return null;
    }

    @Override
    public Object visitHashLiteral_monkey(MonkeyParser.HashLiteral_monkeyContext ctx) {
        visit(ctx.hashContent());
        visit(ctx.moreHashContent());
        return null;
    }

    @Override
    public Object visitHashContet_monkey(MonkeyParser.HashContet_monkeyContext ctx) {
        visit(ctx.expression(0));
        visit(ctx.expression(1));
        return null;
    }

    @Override
    public Object visitMoreHashContet_monkey(MonkeyParser.MoreHashContet_monkeyContext ctx) {
            LinkedList<Data> lista=new LinkedList<Data>();
            if(this.pila.size()>0){
                ElementoStack valor=this.pila.popValue();
                ElementoStack clave=this.pila.popValue();
                if(clave.getTipo()==tipo_String || clave.getTipo()==tipo_Entero){
                    Data data=new Data(clave,valor);
                    lista.add(data);
                }
                else{
                    Interfaz.msjsError.add("La clave del hashLiteral solo puede ser entero o string");
                }
                if(ctx.hashContent().size()==0){
                    JSON json=new JSON(lista);
                    ElementoStack elemento=new ElementoStack(json,tipo_HashLiteral);
                    this.pila.pushValue(elemento);
                }
            }
            if(ctx.hashContent().size()>0){
                for(int x=0;x<ctx.hashContent().size();x++){
                    visit(ctx.hashContent(x));
                    ElementoStack valor=this.pila.popValue();
                    ElementoStack clave=this.pila.popValue();
                    if(clave.getTipo()==tipo_String || clave.getTipo()==tipo_Entero){
                        Data data=new Data(clave,valor);
                        lista.add(data);
                    }
                    else{
                        Interfaz.msjsError.add("La clave del hashLiteral solo puede ser entero o string");
                    }
                }
                JSON json=new JSON(lista);
                ElementoStack elemento=new ElementoStack(json,tipo_HashLiteral);
                this.pila.pushValue(elemento);
            }

        return null;
    }

    @Override
    public Object visitExpressionListExpression_monkey(MonkeyParser.ExpressionListExpression_monkeyContext ctx) {
        visit(ctx.expression());
        int resultado=(Integer)visit(ctx.moreExpressions());
        if(resultado!=tipo_NULL){
        }
        else{
            LinkedList<Object> listaElementos=new LinkedList<>();
            if(this.pila.size()>0){
                listaElementos.add(this.pila.popValue());
                this.pila.pushValue(new ElementoStack(listaElementos,tipo_ArrayLiteral));
            }
        }
        return null;
    }

    @Override
    public Object visitExpressionListVacio_monkey(MonkeyParser.ExpressionListVacio_monkeyContext ctx) {
        return null;
    }

    @Override
    public Object visitMoreExpression_monkey(MonkeyParser.MoreExpression_monkeyContext ctx) {
        LinkedList<Object> listaElementos=new LinkedList<>();
        if(ctx.expression().size()==0){
            return tipo_NULL;
        }
        if(this.pila.size()>0){
            listaElementos.add(this.pila.popValue());
        }
        if(ctx.expression().size()>0){
            visit(ctx.expression(0));
            listaElementos.add(this.pila.popValue());
            for(int i=1; i<ctx.expression().size();i++){
                visit(ctx.expression(i));
                listaElementos.add(this.pila.popValue());
            }
            this.pila.pushValue(new ElementoStack(listaElementos,tipo_ArrayLiteral));
        }
        return 0;
    }

    @Override
    public Object visitPrintExpression_monkey(MonkeyParser.PrintExpression_monkeyContext ctx) {
        visit(ctx.expression());
        return ctx.expression();
    }

    @Override
    public Object visitIfExpression_monkey(MonkeyParser.IfExpression_monkeyContext ctx) {
        visit(ctx.expression());
        visit(ctx.blockStatement(0));
        visit(ctx.blockStatement(1));
        return ctx.expression();
    }

    @Override
    public Object visitBlockStatement_monkey(MonkeyParser.BlockStatement_monkeyContext ctx) {
        for(MonkeyParser.StatementContext ele:ctx.statement()){
            visit(ele);
        }
        return null;
    }

    @Override
    public Object visitIdAST(MonkeyParser.IdASTContext ctx){
        String identifierIndex= ctx.ID().getText();
        ElementoDataStorage elemento=this.almacen.getData(identifierIndex);
        System.out.println("Prueba:"+identifierIndex);
        if(elemento.getName().equals("null") && elemento.getValue().equals(-1)){
            Interfaz.msjsError.add("Error, la variable "+identifierIndex+ " no existe");
        }
        else{
            ElementoDataStorage element = this.almacen.getData(identifierIndex);
            if(arrayfunctions){
                arrayfunctions=false;
                identifierParametro=identifierIndex;
                this.pila.pushValue(new ElementoStack(element.getValue(),element.getTipo()));
            }
            else{
                this.pila.pushValue(new ElementoStack(element.getValue(),element.getTipo()));
            }
        }
        return null;
    }
}
