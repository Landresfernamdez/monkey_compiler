package checker;
import generated.MonkeyParser;
import generated.MonkeyParserBaseVisitor;
import interfaz.Interfaz;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.EOFException;

public class checker extends MonkeyParserBaseVisitor{
    SymbolTable table=null;
    public  static SymbolTableFn tableFn=null;
    int tipo_Boolean=1;
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
    boolean acepta=false;
    int contadorG=0;
    boolean statementIf=false;
    boolean banderaifoneexpression=false;
    boolean banderaReturn=false;
    boolean banderaIfActivate=false;
    public checker(){
        this.tableFn=new SymbolTableFn();
        this.table=new SymbolTable();
    }
    @Override
    public Object visitProgram_monkey(MonkeyParser.Program_monkeyContext ctx){
        this.tableFn.insertar(1,tipo_Entero,"len",tipoNeutro,ctx);
        this.tableFn.insertar(1,tipo_Entero,"first",tipoNeutro,ctx);
        this.tableFn.insertar(2,tipo_Entero,"rest",tipoNeutro,ctx);
        this.tableFn.insertar(1,tipo_Entero,"last",tipoNeutro,ctx);
        this.tableFn.insertar(2,tipo_Entero,"push",tipoNeutro,ctx);
        for(MonkeyParser.StatementContext ele:ctx.statement())
            visit(ele);
        return null;
    }
    @Override
    public Object visitStatement_let_monkey(MonkeyParser.Statement_let_monkeyContext ctx) {
        statementIf=false;
        return (Integer)visit(ctx.letStatement());
    }
    @Override
    public Object visitStatement_return_monkey(MonkeyParser.Statement_return_monkeyContext ctx) {
        if(ctx.returnStatement()==null){
            return tipo_NULL;
        }
        statementIf=false;
        int retorno=(Integer)visit(ctx.returnStatement());
        return  retorno;
    }
    @Override
    public Object visitStatement_expressionStatement_monkey(MonkeyParser.Statement_expressionStatement_monkeyContext ctx) {
        if(ctx.expressionStatement()==null){
            return tipo_NULL;
        }
        statementIf=true;
        int retorno=(Integer)visit(ctx.expressionStatement());
        return retorno;
    }
    int temporaldentifiertype =0;

    @Override
    public Object visitIdAST(MonkeyParser.IdASTContext ctx) {
        return ctx.ID();
    }
    @Override
    public Object visitLetStatement_monkey(MonkeyParser.LetStatement_monkeyContext ctx) {
        temporaldentifiertype =0;
        int retorna=tipoError;
        TerminalNode idToken=(TerminalNode)visit(ctx.identifier());
        SymbolTable.Ident ta=this.table.buscar(idToken.getText());
        if(ta!=null){
            //Se asigna el puntero a la declaracion
            ctx.identifier().decl=ta.decl;
            int te=(Integer)visit(ctx.expression());
            if(ta.type!=te){
                Interfaz.msjsError.add("Tipos incompatibles en la asignacion");
            }
        }
        else if(ta==null){
            if(ctx.expression()!=null){
                int retorno=(Integer)visit(ctx.expression());
                int tipo=retorno;
                if(ctx.expression().toStringTree().contains("fn(")||ctx.expression().toStringTree().contains("fn (")){
                    if(banderaReturn==true){
                        banderaReturn=false;
                        this.tableFn.insertar(retorno,0,idToken.getText(),0,ctx);
                        this.tableFn.imprimir();
                    }
                    else{
                        Interfaz.msjsError.add("Error,la funcion no tiene retorno");
                    }
                }
                else if(retorno==tipoError){
                    Interfaz.msjsError.add("Error en la asignacion");
                }
                else {
                    retorna=retorno;
                    this.table.insertar(idToken.getText(),tipo,ctx);
                    this.table.imprimir();
                }
            }
        }
        return retorna;
    }
    @Override
    public Object visitReturnStatement_monkey(MonkeyParser.ReturnStatement_monkeyContext ctx) {
        int retorno=(Integer) visit(ctx.expression());
        banderaReturn=true;
        return tipoNeutro;
    }
    @Override
    public Object visitExpressionStatement_monkey(MonkeyParser.ExpressionStatement_monkeyContext ctx) {
        int retorno=(Integer) visit(ctx.expression());
        return retorno;
    }
    int comparisonExpresion=0;
    int listaValidaComparisons[]={tipo_Entero,tipo_Identifier};
    int listaEqual[]={tipo_Entero,tipo_Identifier,tipo_String,tipo_Boolean};
    public  Boolean existe(int tipo,int lista[]){
        for(int x=0;x<lista.length;x++){
            if(lista[x]==tipo){
                return true;
            }
        }
        return false;
    }
    @Override
    public Object visitExpression_monkey(MonkeyParser.Expression_monkeyContext ctx) {
        int temporal=(Integer) visit(ctx.additionExpression());
        comparisonExpresion=temporal;
        int temporal1=(Integer)visit(ctx.comparison());
        int retorno=tipoError;
        if(acepta){
            contadorG=contadorG+1;
        }
        if(temporal!=tipo_NULL && temporal1==tipo_NULL){
            if(temporal!=tipoError){
                if(banderaIfActivate==true){
                    banderaifoneexpression=true;
                    banderaIfActivate=false;
                }
                retorno=temporal;
            }
        }
        else if(temporal!=tipo_NULL && temporal1!=tipo_NULL){
            if(temporal!=tipoError){
                temporal1=(Integer)visit(ctx.comparison());
                if(temporal1!=tipoError){
                    retorno=temporal;
                }
                else{
                    retorno=temporal;
                }
            }else{
                Interfaz.msjsError.add("Error en el primer elmento del if");
            }
        }else if(temporal==tipo_NULL && temporal1==tipo_NULL){
            return tipoError;
        }
        return retorno;
    }
    @Override
    public Object visitComparisonLess_monkey(MonkeyParser.ComparisonLess_monkeyContext ctx) {
        int retorno=tipo_Boolean;
        if(ctx.additionExpression().size()==0){
            return 13;
        }
        if(existe(comparisonExpresion,listaValidaComparisons)==false){
            retorno=tipoError;
            Interfaz.msjsError.add("Error en la declaracion del if, estos tipos no se comparar");
            return retorno;
        }
        int temporal=0;
        int ant=comparisonExpresion;
        for(MonkeyParser.AdditionExpressionContext ele:ctx.additionExpression()){
            //Aqui se cae debido a que no es un enteroa
            temporal=(Integer)visit(ele);
            System.out.println(ant);
            System.out.println(temporal);
            if(existe(temporal,listaValidaComparisons)==false){
                Interfaz.msjsError.add("Error en la declaracion del if, estos tipos no se pueden comparar");
                retorno=tipoError;
                break;
            }
            else{
                ant=temporal;
                retorno=temporal;
            }
        }
        return retorno;
    }

    @Override
    public Object visitComparisonPlus_monkey(MonkeyParser.ComparisonPlus_monkeyContext ctx) {
        int retorno=tipo_Boolean;
        if(ctx.additionExpression().size()==0){
            return 13;
        }
        if(existe(comparisonExpresion,listaValidaComparisons)==false){
            retorno=tipoError;
            Interfaz.msjsError.add("Error en la declaracion del if, estos tipos no se comparar");
            return retorno;
        }
        int temporal=0;
        int ant=comparisonExpresion;
        for(MonkeyParser.AdditionExpressionContext ele:ctx.additionExpression()){
            temporal=(Integer)visit(ele);
            if(existe(temporal, listaValidaComparisons)==false){
                Interfaz.msjsError.add("Error en la declaracion del if, estos tipos no se pueden comparar");
                retorno=tipoError;
                break;
            }
            else{
                ant=temporal;
                retorno=temporal;
            }
        }
        return retorno;
    }

    @Override
    public Object visitComparisonLessEqual_monkey(MonkeyParser.ComparisonLessEqual_monkeyContext ctx) {
        int retorno=tipo_Boolean;
        if(ctx.additionExpression().size()==0){
            return 13;
        }
        if(existe(comparisonExpresion,listaValidaComparisons)==false){
            retorno=tipoError;
            Interfaz.msjsError.add("Error en la declaracion del if, estos tipos no se comparar");
            return retorno;
        }
        int temporal=0;
        int ant=comparisonExpresion;
        for(MonkeyParser.AdditionExpressionContext ele:ctx.additionExpression()){
            temporal=(Integer)visit(ele);
            if(existe(temporal, listaValidaComparisons)==false){
                Interfaz.msjsError.add("Error en la declaracion del if, estos tipos no se pueden comparar");
                retorno=tipoError;
                break;
            }
            else{
                ant=temporal;
                retorno=temporal;
            }
        }
        return retorno;
    }

    @Override
    public Object visitComparisonPlusEqual_monkey(MonkeyParser.ComparisonPlusEqual_monkeyContext ctx) {
        int retorno=tipo_Boolean;
        if(ctx.additionExpression().size()==0){
            return 13;
        }
        if(existe(comparisonExpresion,listaValidaComparisons)==false){
            retorno=tipoError;
            Interfaz.msjsError.add("Error en la declaracion del if, estos tipos no se comparar");
            return retorno;
        }
        int temporal=0;
        int ant=comparisonExpresion;
        for(MonkeyParser.AdditionExpressionContext ele:ctx.additionExpression()){
            temporal=(Integer)visit(ele);
            if(existe(temporal,listaValidaComparisons)==false){
                Interfaz.msjsError.add("Error en la declaracion del if, estos tipos no se pueden comparar");
                retorno=tipoError;
                break;
            }
            else{
                ant=temporal;
                retorno=temporal;
            }
        }
        return retorno;
    }

    @Override
    public Object visitComparisonEqualEqual_monkey(MonkeyParser.ComparisonEqualEqual_monkeyContext ctx) {
        int retorno=tipo_Boolean;
        if(ctx.additionExpression().size()==0){
            return 13;
        }
        if(existe(comparisonExpresion,listaEqual)==false){
            retorno=tipoError;
            Interfaz.msjsError.add("Error en la declaracion del if, estos tipos no se pueden igualar");
            return retorno;
        }
        int temporal=0;
        int ant=comparisonExpresion;
        for(MonkeyParser.AdditionExpressionContext ele:ctx.additionExpression()){
            temporal=(Integer)visit(ele);
            if(existe(temporal, listaEqual)==false){
                Interfaz.msjsError.add("Error en la declaracion del if, estos tipos no se pueden igualar");
                retorno=tipoError;
                break;
            }
            else{
                if(ant!=temporal){
                    if((ant!=tipo_Identifier)|(temporal!=tipo_Identifier)){
                        retorno=tipoError;
                        Interfaz.msjsError.add("Error en la declaracion del if, estos tipos no se pueden igualar");
                        break;
                    }
                    else{
                        ant=temporal;
                        retorno=temporal;
                    }
                }
                else{
                    ant=temporal;
                    retorno=temporal;
                }
            }
        }
        return retorno;
    }
    @Override
    public Object visitAdittionExpression_monkey(MonkeyParser.AdittionExpression_monkeyContext ctx) {
        int retorno=(Integer)visit(ctx.multiplicationExpression());
        int retorno1=(Integer)visit(ctx.additionFactor());
        if(retorno!=tipoError && retorno1==tipo_NULL){
                if(retorno==tipoError){
                    retorno=tipoError;
                }
        }
        else if(retorno1!=tipo_NULL && retorno!=tipo_NULL){
            int retornoAF=(Integer)visit(ctx.additionFactor());
            if(retorno==tipoError){
                Interfaz.msjsError.add("A ocurrido un error");
                retorno=tipoError;
            }
            else if(retorno!=retornoAF){
                Interfaz.msjsError.add("Error de tipos");
                retorno=tipoError;
            }
            else if(retorno!=tipo_Entero){
                if((ctx.additionFactor().toStringTree().contains("-")) ||
                        (ctx.additionFactor().toStringTree().contains("*"))
                        || (ctx.additionFactor().toStringTree().contains("/")))
                {
                    Interfaz.msjsError.add("Error, no se puede restar, dividir o multiplicar valores diferentes a enteros");
                    retorno=tipoError;
                }
            }
            else{
            }
        }else{
            return tipoError;
        }
        return retorno;
    }
    @Override
    public Object visitAdittionFactorSUMA_monkey(MonkeyParser.AdittionFactorSUMA_monkeyContext ctx) {
        if(ctx.multiplicationExpression().size()==0){
            return tipo_NULL;
        }
        int retorno = (Integer)visit(ctx.multiplicationExpression(0));
        int comprueba=0;
        for(int i=1; i<ctx.multiplicationExpression().size();i++) {
            comprueba = (Integer) visit(ctx.multiplicationExpression(i));
            if (comprueba!=retorno){
                Interfaz.msjsError.add("Ocurrio un error de tipos");
                return tipoError;
            }
        }
        return retorno;
    }@Override
    public Object visitAdittionFactorRESTA_monkey(MonkeyParser.AdittionFactorRESTA_monkeyContext ctx) {
        if(ctx.multiplicationExpression().size()==0){
            return tipo_NULL;
        }
        int retorno = (Integer)visit(ctx.multiplicationExpression(0));
        int comprueba=0;
        for(int i=1; i<ctx.multiplicationExpression().size();i++) {
            comprueba = (Integer) visit(ctx.multiplicationExpression(i));
            if (comprueba!=retorno){
                Interfaz.msjsError.add("Ocurrio un error de tipos");
                return tipoError;
            }
        }
        return retorno;
    }
    @Override
    public Object visitMultiplicationExpression_monkey(MonkeyParser.MultiplicationExpression_monkeyContext ctx) {
        int retorno=(Integer)visit(ctx.elementExpression());
        if(ctx.elementExpression()!=null){
            if(retorno==tipoError){
                retorno=tipoError;
                Interfaz.msjsError.add("A ocurrido un error");
            }
            else{
                int retornoMf=(Integer)visit(ctx.multiplicationFactor());
                if(retornoMf!=tipo_NULL){
                    int retornoAF=(Integer)visit(ctx.multiplicationFactor());
                    if(retornoAF==tipoError){
                        Interfaz.msjsError.add("A ocurrido un error");
                        retorno=tipoError;
                    }
                    else if(retorno!=retornoAF){
                        Interfaz.msjsError.add("Error de tipos");
                        retorno=tipoError;
                    }
                    else if(retorno!=tipo_Entero){
                        if((ctx.multiplicationFactor().toStringTree().contains("-")) ||
                                (ctx.multiplicationFactor().toStringTree().contains("*"))
                                || (ctx.multiplicationFactor().toStringTree().contains("/")))
                        {
                            Interfaz.msjsError.add("Error, no se puede restar, dividir o multiplicar valores diferentes a enteros");
                            retorno=tipoError;
                        }
                    }
                    else{
                    }
                }
                else{

                }
            }
        }
        return retorno;
    }
    @Override
    public Object visitMultiplicationFactorMUL_monkey(MonkeyParser.MultiplicationFactorMUL_monkeyContext ctx) {
        if(ctx.elementExpression().size()==0){
            return tipo_NULL;
        }
        int retorno=(Integer) visit(ctx.elementExpression(0));
        int comprueba=tipoError;
        for(int i=1; i<ctx.elementExpression().size();i++) {
            comprueba=(Integer)visit(ctx.elementExpression(i));
            if(comprueba!=retorno) {
                Interfaz.msjsError.add("Ocurrio un error de tipos en multiplicacion o division");
                return tipoError;
            }
        }
        return retorno;
    }@Override
    public Object visitMultiplicationFactorDIV_monkey(MonkeyParser.MultiplicationFactorDIV_monkeyContext ctx) {
        if(ctx.elementExpression().size()==0){
            return tipo_NULL;
        }
        int retorno=(Integer) visit(ctx.elementExpression(0));
        int comprueba=tipoError;
        for(int i=1; i<ctx.elementExpression().size();i++) {
            comprueba=(Integer)visit(ctx.elementExpression(i));
            if(comprueba!=retorno) {
                Interfaz.msjsError.add("Ocurrio un error de tipos en multiplicacion o division");
                return tipoError;
            }
        }
        return retorno;
    }
    @Override
    public Object visitElementExprssionPEElementAccess_monkey(MonkeyParser.ElementExprssionPEElementAccess_monkeyContext ctx) {
        int retorno=(Integer)visit(ctx.primitiveExpression());
        int retorno1=(Integer) visit(ctx.elementAccess());
        int temporal=tipoError;
        if(ctx.elementAccess()!=null && ctx.primitiveExpression()!=null){
            System.out.println("Entro a la prueba 1");
            if(this.table.buscar(ctx.primitiveExpression().getText())!=null){
                int tipoExpresion=this.table.buscar(ctx.primitiveExpression().getText()).type;
                retorno=tipoExpresion;
                if(retorno!=tipoError && retorno1==tipoError){
                    temporal=tipoError;
                }
                else if(retorno!=tipoError && retorno1!=tipoError){
                    if((retorno==tipo_ArrayLiteral|retorno==12) && (retorno1==tipo_Entero|retorno1==tipo_Identifier)){
                        temporal=retorno1;
                    }
                    else{
                        Interfaz.msjsError.add("Error en la declaracion del acceso al Array o el hashLiteral");
                        temporal=tipoError;
                    }
                }
            }
        }
        else{
            System.out.println("Entro a la prueba");
            return tipoError;
        }
        return  temporal;
    }
    @Override
    public Object visitElementExprssionPECallExpression_monkey(MonkeyParser.ElementExprssionPECallExpression_monkeyContext ctx) {
        int retorno=(Integer)visit(ctx.primitiveExpression());
        this.tableFn.imprimir();
        SymbolTableFn.Ident valor=null;
        if (ctx.primitiveExpression()!=null && ctx.callExpression()!=null){
            valor = this.tableFn.buscar(ctx.primitiveExpression().getText());
            if (valor==null){
                Interfaz.msjsError.add("Error, el nombre de la funcion "+ ctx.primitiveExpression().getText()
                        +"no ha sido declarado");
                return -1;
            }
            else{
                acepta=true;
                contadorG=0;
                if((Integer)visit(ctx.callExpression())==tipoError){
                    acepta=false;
                    return tipoError;
                }
                acepta=false;
                if(valor.parametros!=contadorG){
                    Interfaz.msjsError.add("Error la cantidad de parametros de " +
                            ctx.primitiveExpression().getText()+
                            "No coinciden");
                    return tipoError;
                }
                contadorG=0;
            }
        }
        return retorno;
    }
    @Override
    public Object visitElementExpressionPE_monkey(MonkeyParser.ElementExpressionPE_monkeyContext ctx) {
        int temporal=(Integer)visit(ctx.primitiveExpression());
        int retorno=tipoError;
        if(ctx.primitiveExpression()!=null){
            if(temporal!=tipoError){
                retorno=temporal;
            }
        }
        return retorno;
    }
    @Override
    public Object visitElementAcces_monkey(MonkeyParser.ElementAcces_monkeyContext ctx) {
        int retorno=(Integer)visit(ctx.expression());
        if(retorno!=tipoError){

        }
        else{
            retorno=tipoError;
        }
        return retorno;
    }

    @Override
    public Object visitCallExpression_monkey(MonkeyParser.CallExpression_monkeyContext ctx) {
        int retorno=(Integer)visit(ctx.expressionList());
        return retorno;
    }

    @Override
    public Object visitPEInteger_monkey(MonkeyParser.PEInteger_monkeyContext ctx) {
        return tipo_Entero;
    }

    @Override
    public Object visitPEString_monkey(MonkeyParser.PEString_monkeyContext ctx) {
        return tipo_String;
    }

    @Override
    public Object visitPEIdentifier_monkey(MonkeyParser.PEIdentifier_monkeyContext ctx) {
        return tipo_Identifier;
    }

    @Override
    public Object visitPETrue_monkey(MonkeyParser.PETrue_monkeyContext ctx)
    {
        return tipo_Boolean;
    }

    @Override
    public Object visitPEFalse_monkey(MonkeyParser.PEFalse_monkeyContext ctx) {
        return tipo_Boolean;
    }
    @Override
    public Object visitPEExpression_monkey(MonkeyParser.PEExpression_monkeyContext ctx) {
        int retorna=(Integer)visit(ctx.expression());
        return retorna;
    }
    @Override
    public Object visitPEArrayLiteral_monkey(MonkeyParser.PEArrayLiteral_monkeyContext ctx) {
        int retorna=(Integer)visit(ctx.arrayLiteral());
        return retorna;
    }
    @Override
    public Object visitPEArrayFunctions_monkey(MonkeyParser.PEArrayFunctions_monkeyContext ctx) {
        int retorno=tipoError;
        if(ctx.arrayFunctions()!=null){
            int temporal=(Integer)visit(ctx.arrayFunctions());
            visit(ctx.expressionList());
            retorno=temporal;
        }
        return retorno;
    }
    @Override
    public Object visitPEFunctionsLiteral_monkey(MonkeyParser.PEFunctionsLiteral_monkeyContext ctx) {
        int retorna=(Integer) visit(ctx.functionLiteral());
        return retorna;
    }

    @Override
    public Object visitPEHashLiteral_monkey(MonkeyParser.PEHashLiteral_monkeyContext ctx) {
        int retorna=(Integer)visit(ctx.hashLiteral());
        if(retorna!=tipoError){
            retorna=12;
        }
        return retorna;
    }

    @Override
    public Object visitPEPrintExpression_monkey(MonkeyParser.PEPrintExpression_monkeyContext ctx) {
        int retorno=(Integer)visit(ctx.printExpression());
        return retorno;
    }

    @Override
    public Object visitPEIfExpression_monkey(MonkeyParser.PEIfExpression_monkeyContext ctx) {
        int retorno=(Integer)visit(ctx.ifExpression());
        int temporal=tipoError;
        if(retorno!=tipoError)
            temporal=retorno;
        return  temporal;
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
        int retorna=(Integer)visit(ctx.expressionList());
        return retorna;
    }
    @Override
    public Object visitFunctionLiteral_monkey(MonkeyParser.FunctionLiteral_monkeyContext ctx) {
        int retorno=0;
        retorno=(Integer)visit(ctx.functionParameters());
        visit(ctx.blockStatement());
        return retorno;
    }

    @Override
    public Object visitFunctionParameters_monkey(MonkeyParser.FunctionParameters_monkeyContext ctx) {
        int parametros=0;
        parametros = (Integer)visit(ctx.moreIdentifiers())+1;
        return parametros;
    }

    @Override
    public Object visitMoreIdentifiers_monkey(MonkeyParser.MoreIdentifiers_monkeyContext ctx) {
        int retorno=0;
        retorno=ctx.ID().size();
        return retorno;
    }
    //Voy por aqui
    @Override
    public Object visitHashLiteral_monkey(MonkeyParser.HashLiteral_monkeyContext ctx) {
        int data=tipoError;
        int retorno=(Integer)visit(ctx.hashContent());
        int retorno1=(Integer)visit(ctx.moreHashContent());
        if(retorno!=tipoError && (retorno1!=tipoError && retorno1!=tipo_NULL)){
            data=retorno;
        }
        if(retorno!=tipoError && (retorno1==tipoError | retorno1==tipo_NULL) ){
            data=retorno;
        }
        return data;
    }

    @Override
    public Object visitHashContet_monkey(MonkeyParser.HashContet_monkeyContext ctx) {
        int data=tipoError;
        int retorno=(Integer)visit(ctx.expression(0));
        int retorno1=(Integer)visit(ctx.expression(1));
        if(retorno!=tipoError && retorno1!=tipoError){
            if(retorno==tipo_Entero | retorno==tipo_Identifier){
                data=12;
            }
            else{
                Interfaz.msjsError.add("Error de tipos en el hash, solo pueden ser enteros o identificadores");
            }
        }
        else{
            Interfaz.msjsError.add("Error de tipos en el hash, solo pueden ser enteros o identificadores");
        }
        return data;
    }

    @Override
    public Object visitMoreHashContet_monkey(MonkeyParser.MoreHashContet_monkeyContext ctx) {
        if(ctx.hashContent().size()==0){
            return tipo_NULL;
        }
        int data=tipoError;
        for(MonkeyParser.HashContentContext ele:ctx.hashContent())
            if((Integer)visit(ele)==tipoError){
                return data;
            }
        data=12;
        return data;
    }
    int temporalExpresion=0;
    @Override
    public Object visitExpressionListExpression_monkey(MonkeyParser.ExpressionListExpression_monkeyContext ctx){
        temporalExpresion=(Integer)visit(ctx.expression());
        int validacionExpression=(Integer)visit(ctx.moreExpressions());
        int retorna=tipoError;
        if(ctx.expression()!=null && validacionExpression==tipo_NULL){
            if(temporalExpresion!=tipoError){
                retorna=tipo_ArrayLiteral;
            }
        }
        else if(ctx.expression()!=null && validacionExpression!=tipo_NULL){
            if(temporalExpresion!=tipoError && validacionExpression!=tipoError){
                retorna=tipo_ArrayLiteral;
            }
        }
        return retorna;
    }
    @Override
    public Object visitExpressionListVacio_monkey(MonkeyParser.ExpressionListVacio_monkeyContext ctx) {
        //Ni idea de que poner
        return null;
    }
    @Override
    public Object visitMoreExpression_monkey(MonkeyParser.MoreExpression_monkeyContext ctx){
        if(ctx.expression().size()==0){
            return tipo_NULL;
        }
        int retorna=(Integer)visit(ctx.expression(0));
        int comprueba=0;
        for(int i=1; i<ctx.expression().size();i++) {
            comprueba = (Integer) visit(ctx.expression(i));
            if(comprueba==-1){
                retorna=-1;
                break;
            }
        }
        return retorna;
    }
    @Override
    public Object visitPrintExpression_monkey(MonkeyParser.PrintExpression_monkeyContext ctx) {
        int retorno=(Integer)visit(ctx.expression());
        return retorno;
    }
    @Override
    public Object visitIfExpression_monkey(MonkeyParser.IfExpression_monkeyContext ctx) {
        int retorna=tipoError;
        banderaIfActivate=true;
        int temporal=(Integer)visit(ctx.expression());
        int block1=(Integer)visit(ctx.blockStatement(0));
        int block2=(Integer)visit(ctx.blockStatement(1));
        if(banderaifoneexpression==true && banderaIfActivate==false && statementIf==true){
            banderaifoneexpression=false;
            statementIf=false;
            if(temporal!=tipo_Identifier && temporal!=tipo_Boolean){
                Interfaz.msjsError.add("Error en la sentencia if de una sola expresion solo permite booleans y identifiers");
            }
        }
        if(temporal!=tipoError && temporal!=tipo_NULL){
                    if(block1!=tipoError && block1!=tipo_NULL){
                        if(block2!=tipoError && block2!=tipo_NULL){
                            retorna=temporal;
                        }
                        else{
                            retorna=temporal;
                        }
                    }
                    else{
                        retorna=tipoError;
                        Interfaz.msjsError.add("Error en el contenido del bloque de codigo del if");
                    }
            }
            else{
                retorna=temporal;
            }
        return retorna;
    }
    @Override
    public Object visitBlockStatement_monkey(MonkeyParser.BlockStatement_monkeyContext ctx) {
        int retorna=tipoError;
        this.table.openScope();
        int temporal=-1;
        for(MonkeyParser.StatementContext ele:ctx.statement()){
            temporal=(Integer)visit(ele);
            if(temporal!=tipo_NULL){
                if(temporal!=tipoError){
                    retorna=temporal;
                }
                else{
                    retorna=tipoError;
                    break;
                }
            }
            else{

            }
        }
        this.table.closeScope();
        return retorna;
    }
}
