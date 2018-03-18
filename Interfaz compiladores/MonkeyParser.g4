parser grammar MonkeyParser;
options{
    tokenVocab=Scanner;
}
program:(statement)*;
statement: LET letStatement | RETURN returnStatement | expressionStatement;
letStatement: ID EQUAL expression PRI PCOMA|SPACE PRD;
returnStatement	: expression PRI PCOMA | SPACE PRD;
expressionStatement: expression PRI PCOMA | SPACE PRD;
expression: additionExpression comparison;
comparison: (PRI L | P| LE | PE|EE PRD additionExpression)* ;
additionExpression: multiplicationExpression additionFactor;
additionFactor: (PRI SUM|SUB PRD multiplicationExpression)*;
multiplicationExpression: elementExpression multiplicationFactor ;
multiplicationFactor: ( PRI MUL | DIV PRD elementExpression)*;
elementExpression: primitiveExpression (elementAccess | callExpression | SPACE);
elementAccess: PCI expression PCD ;
callExpression: PRI expressionList PRD;
primitiveExpression: INTEGER | STRING | ID | TRUE | FALSE | PRI expression PRD | arrayLiteral |
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
printExpression: PUTS ( expression );
ifExpression: IF expression blockStatement (ELSE blockStatement | SPACE);
blockStatement	: LI statement* LD;
