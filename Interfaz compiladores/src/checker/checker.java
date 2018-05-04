package checker;
import generated.MonkeyParser;
import generated.MonkeyParserBaseVisitor;

public class checker extends MonkeyParserBaseVisitor{
    SymbolTable table=null;
    public checker(){
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
        return (Integer)visit(ctx.letStatement());

    }
    @Override
    public Object visitStatement_return_monkey(MonkeyParser.Statement_return_monkeyContext ctx) {
        return  (Integer)visit(ctx.returnStatement());
    }
    @Override
    public Object visitStatement_expressionStatement_monkey(MonkeyParser.Statement_expressionStatement_monkeyContext ctx) {
        this.table.imprimir();
        return (Integer)visit(ctx.expressionStatement());
    }
    int temporaldentifiertype =0;
    @Override
    public Object visitLetStatement_monkey(MonkeyParser.LetStatement_monkeyContext ctx) {
        temporaldentifiertype =0;
        int retorna=-1;
        SymbolTable.Ident ta=this.table.buscar(ctx.ID().getText());
        if(ta!=null){
            int te=(Integer)visit(ctx.expression());
            System.out.println("La variable"+ctx.ID().getText()+" ya fue declarada una vez");
            if(ta.type!=te){
                System.out.println("Tipos incompatibles en la asignacion");
            }
        }
        if(ta==null){
            int retorno=(Integer)visit(ctx.expression());
            if(retorno!=-1){
                int tipo=retorno;
                this.table.insertar(ctx.ID().getText(),tipo,ctx);
                this.table.imprimir();
                retorna=retorno;
            }
        }
        return retorna;
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
        int temporal=(Integer) visit(ctx.additionExpression());
        int retorno=-1;
        if(temporal!=-1){
            comparisonExpresion=temporal;
            int retorno2=(Integer)visit(ctx.comparison());
            if(retorno2!=-1){
                retorno=temporal;
            }
            else{
                retorno=temporal;
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
        int retorno=(Integer)visit(ctx.multiplicationExpression());
        visit(ctx.additionFactor());
        return retorno;
    }

    @Override
    public Object visitAdittionFactorSUMARESTA_monkey(MonkeyParser.AdittionFactorSUMARESTA_monkeyContext ctx) {
        for(MonkeyParser.MultiplicationExpressionContext ele:ctx.multiplicationExpression())
            visit(ele);
        return null;
    }
    @Override
    public Object visitMultiplicationExpression_monkey(MonkeyParser.MultiplicationExpression_monkeyContext ctx) {
        int retorno=(Integer)visit(ctx.elementExpression());
        visit(ctx.multiplicationFactor());
        return retorno;
    }
    @Override
    public Object visitMultiplicationFactorMULDIV_monkey(MonkeyParser.MultiplicationFactorMULDIV_monkeyContext ctx) {
        for(MonkeyParser.ElementExpressionContext ele:ctx.elementExpression())
            visit(ele);
        return null;
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
    @Override
    public Object visitElementExprssionPECallExpression_monkey(MonkeyParser.ElementExprssionPECallExpression_monkeyContext ctx) {
        visit(ctx.primitiveExpression());
        visit(ctx.callExpression());
        return null;
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
        int retorno=(Integer)visit(ctx.expression());
        if(retorno!=-1){

        }
        else{
            retorno=-1;
        }
        return retorno;
    }

    @Override
    public Object visitCallExpression_monkey(MonkeyParser.CallExpression_monkeyContext ctx) {
        visit(ctx.expressionList());
        return null;
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
        int retorno=-1;
        int temporal=(Integer)visit(ctx.arrayFunctions());
        if((Integer)visit(ctx.expressionList())==5){
            retorno=temporal;
            }
        return retorno;
    }
    @Override
    public Object visitPEFunctionsLiteral_monkey(MonkeyParser.PEFunctionsLiteral_monkeyContext ctx) {
        visit(ctx.functionLiteral());
        return null;
    }

    @Override
    public Object visitPEHashLiteral_monkey(MonkeyParser.PEHashLiteral_monkeyContext ctx) {
        int retorna=(Integer)visit(ctx.hashLiteral());
        if(retorna!=-1){
            retorna=12;
        }
        return retorna;
    }

    @Override
    public Object visitPEPrintExpression_monkey(MonkeyParser.PEPrintExpression_monkeyContext ctx) {
        visit(ctx.printExpression());
        return null;
    }

    @Override
    public Object visitPEIfExpression_monkey(MonkeyParser.PEIfExpression_monkeyContext ctx) {
        int retorno=(Integer)visit(ctx.ifExpression());
        int temporal=-1;
        if(retorno!=-1)
            temporal=retorno;
        return  temporal;
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
        //Ni puta idea de que poner aqui
        return null;
    }
    //Voy por aqui
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
    int temporalExpresion=0;
    @Override
    public Object visitExpressionListExpression_monkey(MonkeyParser.ExpressionListExpression_monkeyContext ctx) {
        temporalExpresion=(Integer)visit(ctx.expression());
        int validacionExpression=(Integer)visit(ctx.moreExpressions());
        int retorna=-1;
        if(ctx.expression()!=null && ctx.moreExpressions()!=null){
            if(temporalExpresion!=-1 && validacionExpression!=-1){
                retorna=5;
            }
        }
        else if(ctx.expression()!=null){
            if(temporalExpresion!=-1){
                retorna=5;
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
        int retorna=5;
        for(MonkeyParser.ExpressionContext ele:ctx.expression())
            visit(ele);
        return retorna;
    }
    @Override
    public Object visitPrintExpression_monkey(MonkeyParser.PrintExpression_monkeyContext ctx) {
        visit(ctx.expression());
        return null;
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
        for(MonkeyParser.StatementContext ele:ctx.statement())
            if((Integer)visit(ele)!=-1)
                retorna=(Integer)visit(ele);
            else{
                retorna=-1;
                break;
            }

        System.out.println("Entro a prueba retorna:"+retorna);
        return retorna;
    }
}
