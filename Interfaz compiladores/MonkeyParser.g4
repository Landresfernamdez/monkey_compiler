parser grammar MonkeyParser;
options{
    tokenVocab=Scanner;
}
program:(statement)*;
statement: LET letStatement|RETURN returnStatement|expressionStatement;
letStatement: ID EQUAL expression  (PCOMA|SPACE);
returnStatement	: expression  (PCOMA|SPACE);
expressionStatement: expression  (PCOMA|SPACE);
expression: additionExpression comparison;
comparison: ((L|P|LE|PE|EE)  additionExpression)* ;
additionExpression: multiplicationExpression additionFactor;
additionFactor: ((SUM|SUB)  multiplicationExpression)*;
multiplicationExpression: elementExpression multiplicationFactor ;
multiplicationFactor: ((MUL|DIV) elementExpression)*;
elementExpression: primitiveExpression (elementAccess | callExpression | SPACE);
elementAccess: PCI expression PCD ;
callExpression: PRI expressionList PRD;
primitiveExpression: INTEGER|STRING|ID|TRUE|FALSE|PRI expression PRD | arrayLiteral |
arrayFunctions PRI expressionList PRD | functionLiteral | hashLiteral | printExpression | ifExpression;
arrayFunctions: LEN | FIRST | LAST | REST | PUSH;
arrayLiteral: PCI expressionList PCD ;
functionLiteral	: FN PRI functionParameters PRD blockStatement;
functionParameters	: ID moreIdentifiers;
moreIdentifiers	: (COMA ID)*;
hashLiteral: LI hashContent moreHashContent LD;
hashContent: expression DPTS expression;
moreHashContent	: (COMA hashContent)*;
expressionList: expression moreExpressions | SPACE;
moreExpressions: (COMA expression)*;
printExpression: PUTS PRI expression PRD;
ifExpression: IF expression blockStatement (ELSE blockStatement|SPACE);
blockStatement	: LI (statement)* LD;
