package interpreter;

import generated.MonkeyParser;
import generated.MonkeyParserBaseVisitor;
import interfaz.Interfaz;

public class Interpreter extends MonkeyParserBaseVisitor {
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
    @Override
    public Object visitLetStatement_monkey(MonkeyParser.LetStatement_monkeyContext ctx) {
        visit(ctx.expression());
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

    @Override
    public Object visitAdittionFactorSUMARESTA_monkey(MonkeyParser.AdittionFactorSUMARESTA_monkeyContext ctx) {
        visit(ctx.multiplicationExpression(0));
        for(int i=1; i<ctx.multiplicationExpression().size();i++) {
            visit(ctx.multiplicationExpression(i));
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
    public Object visitMultiplicationFactorMULDIV_monkey(MonkeyParser.MultiplicationFactorMULDIV_monkeyContext ctx) {
        visit(ctx.elementExpression(0));
        for(int i=1; i<ctx.elementExpression().size();i++) {
            visit(ctx.elementExpression(i));
        }
        return null;
    }

    @Override
    public Object visitElementExprssionPEElementAccess_monkey(MonkeyParser.ElementExprssionPEElementAccess_monkeyContext ctx) {
        visit(ctx.primitiveExpression());
        visit(ctx.elementAccess());
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
        return null;
    }

    @Override
    public Object visitCallExpression_monkey(MonkeyParser.CallExpression_monkeyContext ctx) {
        visit(ctx.expressionList());
        return null;
    }

    @Override
    public Object visitPEInteger_monkey(MonkeyParser.PEInteger_monkeyContext ctx) {
        return null;
    }

    @Override
    public Object visitPEString_monkey(MonkeyParser.PEString_monkeyContext ctx) {
        return null;
    }

    @Override
    public Object visitPEIdentifier_monkey(MonkeyParser.PEIdentifier_monkeyContext ctx) {
        return null;
    }

    @Override
    public Object visitPETrue_monkey(MonkeyParser.PETrue_monkeyContext ctx) {
        return null;
    }

    @Override
    public Object visitPEFalse_monkey(MonkeyParser.PEFalse_monkeyContext ctx) {
        return null;
    }

    @Override
    public Object visitPEExpression_monkey(MonkeyParser.PEExpression_monkeyContext ctx) {
        visit(ctx.expression());
        return null;
    }

    @Override
    public Object visitPEArrayLiteral_monkey(MonkeyParser.PEArrayLiteral_monkeyContext ctx) {
        visit(ctx.arrayLiteral());
        return null;
    }

    @Override
    public Object visitPEArrayFunctions_monkey(MonkeyParser.PEArrayFunctions_monkeyContext ctx) {
        visit(ctx.arrayFunctions());
        visit(ctx.expressionList());
        return null;
    }

    @Override
    public Object visitPEFunctionsLiteral_monkey(MonkeyParser.PEFunctionsLiteral_monkeyContext ctx) {
        visit(ctx.functionLiteral());
        return null;
    }
    @Override
    public Object visitPEHashLiteral_monkey(MonkeyParser.PEHashLiteral_monkeyContext ctx) {
        visit(ctx.hashLiteral());
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
        return null;
    }

    @Override
    public Object visitArrayFunctionsFIRST_monkey(MonkeyParser.ArrayFunctionsFIRST_monkeyContext ctx) {
        return null;
    }

    @Override
    public Object visitArrayFunctionsLAST_monkey(MonkeyParser.ArrayFunctionsLAST_monkeyContext ctx) {
        return null;
    }

    @Override
    public Object visitArrayFunctionsREST_monkey(MonkeyParser.ArrayFunctionsREST_monkeyContext ctx) {
        return null;
    }

    @Override
    public Object visitArrayFunctionsPUSH_monkey(MonkeyParser.ArrayFunctionsPUSH_monkeyContext ctx) {
        return null;
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
        for(MonkeyParser.HashContentContext ele:ctx.hashContent())
            visit(ele);
        return null;
    }

    @Override
    public Object visitExpressionListExpression_monkey(MonkeyParser.ExpressionListExpression_monkeyContext ctx) {
        visit(ctx.expression());
        visit(ctx.moreExpressions());
        return null;
    }

    @Override
    public Object visitExpressionListVacio_monkey(MonkeyParser.ExpressionListVacio_monkeyContext ctx) {
        return null;
    }

    @Override
    public Object visitMoreExpression_monkey(MonkeyParser.MoreExpression_monkeyContext ctx) {
        visit(ctx.expression(0));
        for(int i=1; i<ctx.expression().size();i++) {
            visit(ctx.expression(i));
        }
        return null;
    }

    @Override
    public Object visitPrintExpression_monkey(MonkeyParser.PrintExpression_monkeyContext ctx) {
        visit(ctx.expression());
        return null;
    }

    @Override
    public Object visitIfExpression_monkey(MonkeyParser.IfExpression_monkeyContext ctx) {
        visit(ctx.expression());
        visit(ctx.blockStatement(0));
        visit(ctx.blockStatement(1));
        return null;
    }

    @Override
    public Object visitBlockStatement_monkey(MonkeyParser.BlockStatement_monkeyContext ctx) {
        for(MonkeyParser.StatementContext ele:ctx.statement()){
            visit(ele);

        }
        return null;
    }

    @Override
    public Object visitIdAST(MonkeyParser.IdASTContext ctx) {
        return null;
    }
}
