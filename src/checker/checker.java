package checker;
import generated.MonkeyParser;
import generated.MonkeyParserBaseVisitor;

import java.util.concurrent.ExecutionException;


public class checker extends MonkeyParserBaseVisitor{
    SymbolTable table=null;
    SymbolTableFn tableFn=null;
    public checker(){
        this.tableFn=new SymbolTableFn();
        this.table=new SymbolTable();
    }

    @Override
    public Object visitProgram_monkey(MonkeyParser.Program_monkeyContext ctx) {
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
    int temporaldentifiertype =0;
    @Override
    public Object visitLetStatement_monkey(MonkeyParser.LetStatement_monkeyContext ctx) {

        temporaldentifiertype =0;
        SymbolTable.Ident ta=this.table.buscar(ctx.ID().getText());
        if(ta!=null){
            int te=(Integer)visit(ctx.expression());
            if(ta.type!=te){
                System.out.println("Tipos incompatibles en la asignacion");
            }
        }
        if(ta==null){

            int retorno=(Integer)visit(ctx.expression());
            int tipo=retorno;

            if(ctx.expression().toStringTree().contains("fn(")||ctx.expression().toStringTree().contains("fn (")){
                this.tableFn.insertar(retorno,0,ctx.ID().getText(),0,ctx);

                this.tableFn.imprimir();
            }
            else if(retorno>0 && retorno<6){
                this.table.insertar(ctx.ID().getText(),tipo,ctx);
                this.table.imprimir();
            }
            else if(retorno==-1){
                System.out.println("ERROR PERRITO TENGA CUIDADO O VERA COMO DESPICHA TODO HUEVON!!");
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
    int comparisonExpresion=0;
    int listaValidaComparisons[]={2,4};
    int listaEqual[]={2,4,3,1};
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
        if(acepta){
            System.out.println("contador");
            contadorG=contadorG+1;
            System.out.println(contadorG);
        }
        int retornoComparision=-1;
        int retorno=(Integer) visit(ctx.additionExpression());

        if(ctx.comparison()!=null) {
            retornoComparision = (Integer) visit(ctx.comparison());
            if (retornoComparision==-1){
                retorno=-1;
            }
        }

        return retorno;

    }

    @Override
    public Object visitComparisonLess_monkey(MonkeyParser.ComparisonLess_monkeyContext ctx) {
        int retorno=1;
        if(ctx.additionExpression().size()==0){
            return 13;
        }
        if(existe(comparisonExpresion, listaValidaComparisons)==false){
            retorno=-1;
            return retorno;
        }
        int temporal=0;
        for(MonkeyParser.AdditionExpressionContext ele:ctx.additionExpression()){
            temporal=(Integer)visit(ele);
            if(existe(temporal, listaValidaComparisons)==false){
                System.out.println(temporal);
                System.out.println("Error en la declaracion del if");
                retorno=-1;
                break;
            }
        }
        System.out.println("retorno:"+retorno);
        return retorno;
    }

    @Override
    public Object visitComparisonPlus_monkey(MonkeyParser.ComparisonPlus_monkeyContext ctx) {
        int retorno=1;
        if(ctx.additionExpression().size()==0){
            return 13;
        }
        if(existe(comparisonExpresion, listaValidaComparisons)==false){
            retorno=-1;
            return retorno;
        }
        int temporal=0;
        for(MonkeyParser.AdditionExpressionContext ele:ctx.additionExpression()){
            temporal=(Integer)visit(ele);
            if(existe(temporal, listaValidaComparisons)==false){
                System.out.println(temporal);
                System.out.println("Error en la declaracion del if");
                retorno=-1;
                break;
            }
        }
        System.out.println("retorno:"+retorno);
        return retorno;

    }

    @Override
    public Object visitComparisonLessEqual_monkey(MonkeyParser.ComparisonLessEqual_monkeyContext ctx) {
        int retorno=1;
        if(ctx.additionExpression().size()==0){
            return 13;
        }
        if(existe(comparisonExpresion, listaValidaComparisons)==false){
            retorno=-1;
            return retorno;
        }
        int temporal=0;
        for(MonkeyParser.AdditionExpressionContext ele:ctx.additionExpression()){
            temporal=(Integer)visit(ele);
            if(existe(temporal, listaValidaComparisons)==false){
                System.out.println(temporal);
                System.out.println("Error en la declaracion del if");
                retorno=-1;
                break;
            }
        }
        System.out.println("retorno:"+retorno);
        return retorno;
    }

    @Override
    public Object visitComparisonPlusEqual_monkey(MonkeyParser.ComparisonPlusEqual_monkeyContext ctx) {
        int retorno=1;
        if(ctx.additionExpression().size()==0){
            return 13;
        }
        if(existe(comparisonExpresion, listaValidaComparisons)==false){
            retorno=-1;
            return retorno;
        }
        int temporal=0;
        for(MonkeyParser.AdditionExpressionContext ele:ctx.additionExpression()){
            temporal=(Integer)visit(ele);
            if(existe(temporal, listaValidaComparisons)==false){
                System.out.println(temporal);
                System.out.println("Error en la declaracion del if");
                retorno=-1;
                break;
            }
        }
        System.out.println("retorno:"+retorno);
        return retorno;
    }

    @Override
    public Object visitComparisonEqualEqual_monkey(MonkeyParser.ComparisonEqualEqual_monkeyContext ctx) {
        int retorno=1;
        if(ctx.additionExpression().size()==0){
            return 13;
        }
        if(existe(comparisonExpresion,listaEqual)==false){
            retorno=-1;
            return retorno;
        }
        int temporal=0;
        for(MonkeyParser.AdditionExpressionContext ele:ctx.additionExpression()){
            temporal=(Integer)visit(ele);
            if(existe(temporal, listaEqual)==false){
                System.out.println(temporal);
                System.out.println("Error en la declaracion del if");
                retorno=-1;
                break;
            }
            else{
                if(comparisonExpresion==3){
                    if(temporal==3){

                    }
                    else{
                        retorno=-1;
                        break;
                    }
                }
                else if(comparisonExpresion==1){
                    if(temporal==1){

                    }
                    else{
                        retorno=-1;
                        break;
                    }
                }
                else{
                    if(existe(temporal,listaValidaComparisons)==false){
                        retorno=-1;
                        break;
                    }
                }
            }
        }
        System.out.println("retorno:"+retorno);
        return retorno;
    }

    @Override
    public Object visitAdittionExpression_monkey(MonkeyParser.AdittionExpression_monkeyContext ctx) {
        int retorno = (Integer)visit(ctx.multiplicationExpression());

        try {

            int retornoAF=(Integer)visit(ctx.additionFactor());
                if(retorno==-1 || retornoAF==-1){
                    System.out.println("A ocurrido un error");
                    retorno=-1;
                }
                else if(retorno!=retornoAF) {
                    System.out.println("Error de tipos");
                    retorno=-1;
                }
                else if(retorno==3){
                    if((ctx.additionFactor().toStringTree().contains("-")) ||
                        (ctx.additionFactor().toStringTree().contains("*"))
                         || (ctx.additionFactor().toStringTree().contains("/")))
                    {
                        System.out.println("Error, no se puede restar, dividir o multiplicar valores diferentes a enteros");
                        retorno=-1;
                    }
                }
                else{
                    System.out.println("Este dato no puede realizar esta operación");
                }
        }catch (Exception e){ }

        return retorno;
    }

    @Override
    public Object visitAdittionFactorSUMARESTA_monkey(MonkeyParser.AdittionFactorSUMARESTA_monkeyContext ctx) {

        int retorno = (Integer)visit(ctx.multiplicationExpression(0));
        int comprueba=0;
        for(int i=1; i<ctx.multiplicationExpression().size();i++) {
            comprueba = (Integer) visit(ctx.multiplicationExpression(i));
            if (comprueba!=retorno){
                System.out.println("Ocurrio un error de tipos");
                return -1;
            }
        }
        return retorno;
    }

    @Override
    public Object visitMultiplicationExpression_monkey(MonkeyParser.MultiplicationExpression_monkeyContext ctx) {

        int retorno=(Integer)visit(ctx.elementExpression());
        try {
            int retornoAF=(Integer)visit(ctx.multiplicationFactor());


            if(retorno==-1 || retornoAF==-1){
                System.out.println("A ocurrido un error");
                retorno=-1;
            }
            else if(retorno!=retornoAF) {
                System.out.println("Error de tipos");
                retorno=-1;
            }
            else if(retorno==3){
                if((ctx.multiplicationFactor().toStringTree().contains("-")) ||
                        (ctx.multiplicationFactor().toStringTree().contains("*"))
                        || (ctx.multiplicationFactor().toStringTree().contains("/")))
                {
                    System.out.println("Error, no se puede restar, dividir o multiplicar valores diferentes a enteros");
                    retorno=-1;
                }
            }
            else{
                System.out.println("Este dato no puede realizar esta operación");
            }


        }catch (Exception e){

        }

        return retorno;

    }

    @Override
    public Object visitMultiplicationFactorMULDIV_monkey(MonkeyParser.MultiplicationFactorMULDIV_monkeyContext ctx) {
        int retorno=(Integer) visit(ctx.elementExpression(0));
        int comprueba=-1;
        for(int i=1; i<ctx.elementExpression().size();i++) {
            comprueba=(Integer)visit(ctx.elementExpression(i));
            if(comprueba!=retorno) {
                System.out.println("Ocurrio un error de tipos");
                return -1;
            }
        }
        return retorno;
    }
    @Override
    public Object visitElementExprssionPEElementAccess_monkey(MonkeyParser.ElementExprssionPEElementAccess_monkeyContext ctx) {
        int retorno=(Integer)visit(ctx.primitiveExpression());
        int retorno1=(Integer) visit(ctx.elementAccess());
        int temporal=-1;
        if(ctx.elementAccess()!=null && ctx.primitiveExpression()!=null){
            int tipoExpresion=this.table.buscar(ctx.primitiveExpression().getText()).type;
            retorno=tipoExpresion;
            if(retorno!=-1 && retorno1==-1){
                temporal=-1;
            }
            else if(retorno!=-1 && retorno1!=-1){
                if((retorno==5|retorno==12) && (retorno1==2|retorno1==4)){
                    temporal=retorno1;
                }
                else{
                    System.out.println("retorno:"+retorno);
                    System.out.println("Error en la declaracion del acceso al Array o el hashLiteral");
                    temporal=-1;
                }
            }
        }
        else{
            return -1;
        }
        return  temporal;
    }
    boolean acepta=false;
    int contadorG=0;
    @Override
    public Object visitElementExprssionPECallExpression_monkey(MonkeyParser.ElementExprssionPECallExpression_monkeyContext ctx) {

        int retorno=(Integer)visit(ctx.primitiveExpression());
        System.out.println("Que pedo haste tanque"+ctx.primitiveExpression().getText());
        this.tableFn.imprimir();
        SymbolTableFn.Ident valor=null;
        if (ctx.primitiveExpression()!=null){
            valor = this.tableFn.buscar(ctx.primitiveExpression().getText());
            if (valor==null){
                System.out.println("el nombre de la funcion "+ ctx.primitiveExpression().getText()
                        +"no ha sido declarado");
                return -1;
            }
        }

        if (ctx.callExpression()!=null) {
            acepta=true;
            contadorG=0;
            System.out.println(visit(ctx.callExpression())+"Hola");
            acepta=false;

            if(valor.parametros!=contadorG){
                System.out.println("Error la cantidad de parametros de " +
                        ctx.primitiveExpression().getText()+
                        "No coinciden"
                );
                return -1;
            }
            System.out.println(contadorG);
            contadorG=0;
        }
        return retorno;
    }

    @Override
    public Object visitElementExpressionPE_monkey(MonkeyParser.ElementExpressionPE_monkeyContext ctx) {
        int temporal=(Integer)visit(ctx.primitiveExpression());
        int retorno=-1;
        //Si el primitive expression es un entero o string 0 boolean o ID , entonces se retorna exito  con 0 de lo contrario retona error con -1
        if(temporal!=-1){
            retorno=temporal;
        }
        return retorno;
    }
    @Override
    public Object visitElementAcces_monkey(MonkeyParser.ElementAcces_monkeyContext ctx) {
        visit(ctx.expression());
        return null;
    }

    @Override
    public Object visitCallExpression_monkey(MonkeyParser.CallExpression_monkeyContext ctx) {
        int retorno=(Integer)visit(ctx.expressionList());
        return retorno;
    }

    @Override
    public Object visitPEInteger_monkey(MonkeyParser.PEInteger_monkeyContext ctx) {
        return 2;
    }

    @Override
    public Object visitPEString_monkey(MonkeyParser.PEString_monkeyContext ctx) {
        return 3;
    }

    @Override
    public Object visitPEIdentifier_monkey(MonkeyParser.PEIdentifier_monkeyContext ctx) {
        return 4;
    }

    @Override
    public Object visitPETrue_monkey(MonkeyParser.PETrue_monkeyContext ctx)
    {
        return 1;
    }

    @Override
    public Object visitPEFalse_monkey(MonkeyParser.PEFalse_monkeyContext ctx) {

        return 1;
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
        visit(ctx.arrayFunctions());
        visit(ctx.expressionList());
        return null;
    }

    @Override
    public Object visitPEFunctionsLiteral_monkey(MonkeyParser.PEFunctionsLiteral_monkeyContext ctx) {
        int retorna=(Integer) visit(ctx.functionLiteral());
        return retorna;
    }

    @Override
    public Object visitPEHashLiteral_monkey(MonkeyParser.PEHashLiteral_monkeyContext ctx) {
        visit(ctx.hashLiteral());
        return null;
    }

    @Override
    public Object visitPEPrintExpression_monkey(MonkeyParser.PEPrintExpression_monkeyContext ctx) {
        int retorno=(Integer)visit(ctx.printExpression());
        return retorno;
    }

    @Override
    public Object visitPEIfExpression_monkey(MonkeyParser.PEIfExpression_monkeyContext ctx) {
        visit(ctx.ifExpression());
        return null;
    }

    @Override
    public Object visitArrayFunctionsLEN_monkey(MonkeyParser.ArrayFunctionsLEN_monkeyContext ctx) {
        return 7;
    }

    @Override
    public Object visitArrayFunctionsFIRST_monkey(MonkeyParser.ArrayFunctionsFIRST_monkeyContext ctx) {
        return 8;
    }

    @Override
    public Object visitArrayFunctionsLAST_monkey(MonkeyParser.ArrayFunctionsLAST_monkeyContext ctx) {
        return 9;
    }

    @Override
    public Object visitArrayFunctionsREST_monkey(MonkeyParser.ArrayFunctionsREST_monkeyContext ctx) {
        return 10;
    }

    @Override
    public Object visitArrayFunctionsPUSH_monkey(MonkeyParser.ArrayFunctionsPUSH_monkeyContext ctx) {
        return 11;
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

    @Override
    public Object visitHashLiteral_monkey(MonkeyParser.HashLiteral_monkeyContext ctx) {
        int data=-1;
        int retorno=(Integer)visit(ctx.hashContent());
        int retorno1=(Integer)visit(ctx.moreHashContent());
        if(retorno!=-1 && retorno1!=-1){
            data=retorno;
        }
        if(retorno!=-1 && retorno1==-1){
            data=retorno;
        }
        return data;
    }

    @Override
    public Object visitHashContet_monkey(MonkeyParser.HashContet_monkeyContext ctx) {
        int data=-1;
        int retorno=(Integer)visit(ctx.expression(0));
        int retorno1=(Integer)visit(ctx.expression(1));
        if(retorno!=-1 && retorno1!=-1){
            if(retorno==2 | retorno==4){
                data=12;
            }
            else{
                System.out.println("Error de tipos en el hash, solo pueden ser enteros o identificadores");
            }
        }
        else{
            System.out.println("Error de tipos en el hash, solo pueden ser enteros o identificadores");
        }
        return data;
    }

    @Override
    public Object visitMoreHashContet_monkey(MonkeyParser.MoreHashContet_monkeyContext ctx) {
        int data=-1;
        for(MonkeyParser.HashContentContext ele:ctx.hashContent())
            if((Integer)visit(ele)==-1){
                return data;
            }
        data=12;
        return data;
    }

    @Override
    public Object visitExpressionListExpression_monkey(MonkeyParser.ExpressionListExpression_monkeyContext ctx) {
        int retorna=(Integer)visit(ctx.expression());
        try {
            int validacionExpression = (Integer) visit(ctx.moreExpressions());
            if (validacionExpression != -1 && retorna==validacionExpression) {
                retorna = 5;
            }
        }catch (Exception e){}
        return retorna;
    }

    @Override
    public Object visitExpressionListVacio_monkey(MonkeyParser.ExpressionListVacio_monkeyContext ctx) {
        return null;
    }

    @Override
    public Object visitMoreExpression_monkey(MonkeyParser.MoreExpression_monkeyContext ctx) {
        int retorna=(Integer)visit(ctx.expression(0));
        int comprueba=0;
        for(int i=1; i<ctx.expression().size();i++) {
            comprueba = (Integer) visit(ctx.expression(i));
            if (comprueba!=retorna){
                System.out.println("Ocurrio un error de tipos");
                return -1;
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
        int retorna=-1;
        int temporal=(Integer)visit(ctx.expression());
        System.out.println(temporal);
        if(temporal!=-1){
            if(temporal!=-1){
                if(temporal==1 | temporal==4){
                    if((Integer)visit(ctx.blockStatement(0))!=-1)
                        System.out.println("Entro a la prueba");
                    if((Integer)visit(ctx.blockStatement(1))!=-1){
                        System.out.println("Entro a la prueba");
                        retorna=temporal;
                    }
                    else{

                    }
                }
                else{
                    System.out.println("Error en la sentencia if solo se permiten boolean o identifiers");
                }
            }
            else{
                if(ctx.blockStatement(0)!=null && ctx.blockStatement(1)!=null){
                    if((Integer)visit(ctx.blockStatement(0))!=-1)
                        System.out.println("entro a prueba");
                    if((Integer)visit(ctx.blockStatement(1))!=-1){
                        retorna=temporal;
                    }
                    else{

                    }
                }
            }

        }
        return retorna;
    }

    @Override
    public Object visitBlockStatement_monkey(MonkeyParser.BlockStatement_monkeyContext ctx) {
        int retorna=-1;
        this.table.openScope();
        for(MonkeyParser.StatementContext ele:ctx.statement())
            if((Integer)visit(ele)!=-1)
                retorna=(Integer)visit(ele);
            else{
                retorna=-1;
                break;
            }
        this.table.closeScope();
        return retorna;
    }
}
