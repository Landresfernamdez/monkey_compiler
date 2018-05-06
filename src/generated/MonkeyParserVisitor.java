// Generated from C:/Users/Jurguen/Desktop/Proyectos 2018/Segundo proyecto lenguaje/Primerproyecto programado Jurguen Romero Andres Fernandez/monkey_compiler-master/monkey_compiler-master/Interfaz compiladores\MonkeyParser.g4 by ANTLR 4.7
package generated;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MonkeyParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MonkeyParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code Program_monkey}
	 * labeled alternative in {@link MonkeyParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram_monkey(MonkeyParser.Program_monkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Statement_let_monkey}
	 * labeled alternative in {@link MonkeyParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement_let_monkey(MonkeyParser.Statement_let_monkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Statement_return_monkey}
	 * labeled alternative in {@link MonkeyParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement_return_monkey(MonkeyParser.Statement_return_monkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Statement_expressionStatement_monkey}
	 * labeled alternative in {@link MonkeyParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement_expressionStatement_monkey(MonkeyParser.Statement_expressionStatement_monkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LetStatement_monkey}
	 * labeled alternative in {@link MonkeyParser#letStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetStatement_monkey(MonkeyParser.LetStatement_monkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReturnStatement_monkey}
	 * labeled alternative in {@link MonkeyParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement_monkey(MonkeyParser.ReturnStatement_monkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionStatement_monkey}
	 * labeled alternative in {@link MonkeyParser#expressionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement_monkey(MonkeyParser.ExpressionStatement_monkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Expression_monkey}
	 * labeled alternative in {@link MonkeyParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_monkey(MonkeyParser.Expression_monkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComparisonLess_monkey}
	 * labeled alternative in {@link MonkeyParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonLess_monkey(MonkeyParser.ComparisonLess_monkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComparisonPlus_monkey}
	 * labeled alternative in {@link MonkeyParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonPlus_monkey(MonkeyParser.ComparisonPlus_monkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComparisonLessEqual_monkey}
	 * labeled alternative in {@link MonkeyParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonLessEqual_monkey(MonkeyParser.ComparisonLessEqual_monkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComparisonPlusEqual_monkey}
	 * labeled alternative in {@link MonkeyParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonPlusEqual_monkey(MonkeyParser.ComparisonPlusEqual_monkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComparisonEqualEqual_monkey}
	 * labeled alternative in {@link MonkeyParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonEqualEqual_monkey(MonkeyParser.ComparisonEqualEqual_monkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AdittionExpression_monkey}
	 * labeled alternative in {@link MonkeyParser#additionExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdittionExpression_monkey(MonkeyParser.AdittionExpression_monkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AdittionFactorSUMARESTA_monkey}
	 * labeled alternative in {@link MonkeyParser#additionFactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdittionFactorSUMARESTA_monkey(MonkeyParser.AdittionFactorSUMARESTA_monkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MultiplicationExpression_monkey}
	 * labeled alternative in {@link MonkeyParser#multiplicationExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicationExpression_monkey(MonkeyParser.MultiplicationExpression_monkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MultiplicationFactorMULDIV_monkey}
	 * labeled alternative in {@link MonkeyParser#multiplicationFactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicationFactorMULDIV_monkey(MonkeyParser.MultiplicationFactorMULDIV_monkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ElementExprssionPEElementAccess_monkey}
	 * labeled alternative in {@link MonkeyParser#elementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementExprssionPEElementAccess_monkey(MonkeyParser.ElementExprssionPEElementAccess_monkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ElementExprssionPECallExpression_monkey}
	 * labeled alternative in {@link MonkeyParser#elementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementExprssionPECallExpression_monkey(MonkeyParser.ElementExprssionPECallExpression_monkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ElementExpressionPE_monkey}
	 * labeled alternative in {@link MonkeyParser#elementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementExpressionPE_monkey(MonkeyParser.ElementExpressionPE_monkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ElementAcces_monkey}
	 * labeled alternative in {@link MonkeyParser#elementAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementAcces_monkey(MonkeyParser.ElementAcces_monkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CallExpression_monkey}
	 * labeled alternative in {@link MonkeyParser#callExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallExpression_monkey(MonkeyParser.CallExpression_monkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PEInteger_monkey}
	 * labeled alternative in {@link MonkeyParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPEInteger_monkey(MonkeyParser.PEInteger_monkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PEString_monkey}
	 * labeled alternative in {@link MonkeyParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPEString_monkey(MonkeyParser.PEString_monkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PEIdentifier_monkey}
	 * labeled alternative in {@link MonkeyParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPEIdentifier_monkey(MonkeyParser.PEIdentifier_monkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PETrue_monkey}
	 * labeled alternative in {@link MonkeyParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPETrue_monkey(MonkeyParser.PETrue_monkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PEFalse_monkey}
	 * labeled alternative in {@link MonkeyParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPEFalse_monkey(MonkeyParser.PEFalse_monkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PEExpression_monkey}
	 * labeled alternative in {@link MonkeyParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPEExpression_monkey(MonkeyParser.PEExpression_monkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PEArrayLiteral_monkey}
	 * labeled alternative in {@link MonkeyParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPEArrayLiteral_monkey(MonkeyParser.PEArrayLiteral_monkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PEArrayFunctions_monkey}
	 * labeled alternative in {@link MonkeyParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPEArrayFunctions_monkey(MonkeyParser.PEArrayFunctions_monkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PEFunctionsLiteral_monkey}
	 * labeled alternative in {@link MonkeyParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPEFunctionsLiteral_monkey(MonkeyParser.PEFunctionsLiteral_monkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PEHashLiteral_monkey}
	 * labeled alternative in {@link MonkeyParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPEHashLiteral_monkey(MonkeyParser.PEHashLiteral_monkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PEPrintExpression_monkey}
	 * labeled alternative in {@link MonkeyParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPEPrintExpression_monkey(MonkeyParser.PEPrintExpression_monkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PEIfExpression_monkey}
	 * labeled alternative in {@link MonkeyParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPEIfExpression_monkey(MonkeyParser.PEIfExpression_monkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayFunctionsLEN_monkey}
	 * labeled alternative in {@link MonkeyParser#arrayFunctions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayFunctionsLEN_monkey(MonkeyParser.ArrayFunctionsLEN_monkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayFunctionsFIRST_monkey}
	 * labeled alternative in {@link MonkeyParser#arrayFunctions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayFunctionsFIRST_monkey(MonkeyParser.ArrayFunctionsFIRST_monkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayFunctionsLAST_monkey}
	 * labeled alternative in {@link MonkeyParser#arrayFunctions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayFunctionsLAST_monkey(MonkeyParser.ArrayFunctionsLAST_monkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayFunctionsREST_monkey}
	 * labeled alternative in {@link MonkeyParser#arrayFunctions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayFunctionsREST_monkey(MonkeyParser.ArrayFunctionsREST_monkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayFunctionsPUSH_monkey}
	 * labeled alternative in {@link MonkeyParser#arrayFunctions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayFunctionsPUSH_monkey(MonkeyParser.ArrayFunctionsPUSH_monkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayLiteral_monkey}
	 * labeled alternative in {@link MonkeyParser#arrayLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLiteral_monkey(MonkeyParser.ArrayLiteral_monkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionLiteral_monkey}
	 * labeled alternative in {@link MonkeyParser#functionLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionLiteral_monkey(MonkeyParser.FunctionLiteral_monkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionParameters_monkey}
	 * labeled alternative in {@link MonkeyParser#functionParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionParameters_monkey(MonkeyParser.FunctionParameters_monkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MoreIdentifiers_monkey}
	 * labeled alternative in {@link MonkeyParser#moreIdentifiers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoreIdentifiers_monkey(MonkeyParser.MoreIdentifiers_monkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code HashLiteral_monkey}
	 * labeled alternative in {@link MonkeyParser#hashLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHashLiteral_monkey(MonkeyParser.HashLiteral_monkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code HashContet_monkey}
	 * labeled alternative in {@link MonkeyParser#hashContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHashContet_monkey(MonkeyParser.HashContet_monkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MoreHashContet_monkey}
	 * labeled alternative in {@link MonkeyParser#moreHashContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoreHashContet_monkey(MonkeyParser.MoreHashContet_monkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionListExpression_monkey}
	 * labeled alternative in {@link MonkeyParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionListExpression_monkey(MonkeyParser.ExpressionListExpression_monkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionListVacio_monkey}
	 * labeled alternative in {@link MonkeyParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionListVacio_monkey(MonkeyParser.ExpressionListVacio_monkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MoreExpression_monkey}
	 * labeled alternative in {@link MonkeyParser#moreExpressions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoreExpression_monkey(MonkeyParser.MoreExpression_monkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrintExpression_monkey}
	 * labeled alternative in {@link MonkeyParser#printExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintExpression_monkey(MonkeyParser.PrintExpression_monkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfExpression_monkey}
	 * labeled alternative in {@link MonkeyParser#ifExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfExpression_monkey(MonkeyParser.IfExpression_monkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockStatement_monkey}
	 * labeled alternative in {@link MonkeyParser#blockStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatement_monkey(MonkeyParser.BlockStatement_monkeyContext ctx);
}