parser grammar MonkeyParser;
options{
    tokenVocab=Scanner;
}
program: statement*#Program_monkey;
statement  : LET letStatement#Statement_let_monkey
            | RETURN returnStatement#Statement_return_monkey
            | expressionStatement#Statement_expressionStatement_monkey;
letStatement: ID EQUAL expression  (PCOMA| )#LetStatement_monkey;
returnStatement	: expression  (PCOMA| )#ReturnStatement_monkey;
expressionStatement: expression  (PCOMA| )#ExpressionStatement_monkey;
expression: additionExpression comparison#Expression_monkey;
comparison:  (L additionExpression)*#ComparisonLess_monkey
            |(P additionExpression)*#ComparisonPlus_monkey
            |(LE additionExpression)*#ComparisonLessEqual_monkey
            |(PE additionExpression)*#ComparisonPlusEqual_monkey
            |(EE additionExpression)*#ComparisonEqualEqual_monkey ;
additionExpression: multiplicationExpression additionFactor#AdittionExpression_monkey;
additionFactor: ((SUM|SUB) multiplicationExpression)*#AdittionFactorSUMARESTA_monkey;
multiplicationExpression: elementExpression multiplicationFactor #MultiplicationExpression_monkey;
multiplicationFactor: ((MUL|DIV) elementExpression)*#MultiplicationFactorMULDIV_monkey;
elementExpression: primitiveExpression elementAccess#ElementExprssionPEElementAccess_monkey
                 | primitiveExpression callExpression#ElementExprssionPECallExpression_monkey
                 | primitiveExpression      #ElementExpressionPE_monkey;
elementAccess: PCI expression PCD #ElementAcces_monkey;
callExpression: PRI expressionList PRD#CallExpression_monkey;
primitiveExpression: INTEGER#PEInteger_monkey
                    |STRING#PEString_monkey
                    |ID#PEIdentifier_monkey
                    |TRUE#PETrue_monkey
                    |FALSE#PEFalse_monkey
                    |PRI expression PRD#PEExpression_monkey
                    | arrayLiteral#PEArrayLiteral_monkey
                    | arrayFunctions PRI expressionList PRD#PEArrayFunctions_monkey
                    | functionLiteral#PEFunctionsLiteral_monkey
                    | hashLiteral#PEHashLiteral_monkey
                    | printExpression#PEPrintExpression_monkey
                    | ifExpression#PEIfExpression_monkey;
arrayFunctions: LEN#ArrayFunctionsLEN_monkey
                | FIRST#ArrayFunctionsFIRST_monkey
                | LAST#ArrayFunctionsLAST_monkey
                | REST#ArrayFunctionsREST_monkey
                | PUSH#ArrayFunctionsPUSH_monkey;
arrayLiteral: PCI expressionList PCD #ArrayLiteral_monkey;
functionLiteral	: FN PRI functionParameters PRD blockStatement #FunctionLiteral_monkey;
functionParameters	: ID moreIdentifiers #FunctionParameters_monkey;
moreIdentifiers	: (COMA ID)*#MoreIdentifiers_monkey;
hashLiteral: LI hashContent moreHashContent LD #HashLiteral_monkey;
hashContent: expression DPTS expression#HashContet_monkey;
moreHashContent	: (COMA hashContent)*#MoreHashContet_monkey;
expressionList: expression moreExpressions #ExpressionListExpression_monkey
| #ExpressionListVacio_monkey;
moreExpressions: (COMA expression)* #MoreExpression_monkey;
printExpression: PUTS PRI expression PRD#PrintExpression_monkey;
ifExpression: IF expression blockStatement (ELSE blockStatement| )#IfExpression_monkey;
blockStatement	: LI statement* LD#BlockStatement_monkey;
