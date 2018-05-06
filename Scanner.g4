lexer grammar Scanner;
/*
palabras reservadas
*/
LET:'let';
RETURN:'return';
TRUE:'true';
FALSE:'false';
LEN:'len';
FIRST:'first';
LAST:'last';
REST:'rest';
PUSH:'push';
FN:'fn';
PUTS:'puts';
IF:'if';
ELSE:'else';

/*
signos
*/
L:'<';
P:'>';
LE:'<=';
PE:'>=';
EE:'==';

SUM:'+';
SUB:'-';
MUL:'*';
DIV:'/';

EQUAL:'=';
PCOMA:';';
PCI:'[';
PCD:']';
PRI:'(';
PRD:')';
DCOM:'"';
COMA:',';
LI:'{';
LD:'}';
DPTS:':';

ID: LETTER(LETTER|DIGIT)*;
INTEGER: DIGIT DIGIT*;
STRING: DCOM LETTER(LETTER|SIGN)* DCOM;


BOOLEAN:TRUE|FALSE;
fragment SIGN: EQUAL|PCOMA|L|P|PCI|PCD|PRI|PRD|COMA|LI|LD|DPTS|LE|PE|EE|DIGIT;
fragment LETTER :'a'..'z' | 'A'..'Z'|'_';
fragment DIGIT :'0'..'9';


WS : [ \t\n\r]+ -> skip;
LINE_COMMENT:   '//'.*?'\r'?'\n' -> skip ;
SPECIAL_COMMENT: '/*'( SPECIAL_COMMENT | . )*?'*/' -> skip;
