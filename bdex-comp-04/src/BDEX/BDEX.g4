

grammar BDEX;

program:
    stat* EOF;

stat:
		var	    ';'       	    
	|	define 	';'			
    |   noRetFunc  ';'            
    |   forloop 
    |   NEWLINE                
    ;

expr: 
		Create WORD			                                                        #exprCreate
    |	Get WORD (WORD)* (where)?		                                            #exprGet
    |   Read '(' STRING ')'                                                         #exprRead
    |   WORD Join WORD 	On  WORD '=' WORD                         		            #exprJoinOn   
	|	WORD Join WORD			                                                    #exprJoin
    |   WORD where                                                                  #exprWhere    
	|	val						                                                    #exprVal
    ;			                                                                           

var:
    	Template WORD  ('[' WORD ':'type']')+ 	                                    #varTemplate
    |   type WORD ('=' (expr | (Input '(' STRING ')'))  )?				            #varType 
    |   Expr WORD ('=' where )?                                                     #varExpr
    |   Bool WORD ('=' (bool | WORD Where val))?                                    #varBool
    ;

noRetFunc: 
        Print '(' val? ')'                                                           #noRetPrint
    |   Save '(' STRING ',' WORD ')'                                                 #exprSave
    | 	Delete WORD	(Line where)?		                                             #noRetDel
	| 	Add WORD Line ('<'(WORD',')* WORD'>')? '(' (val ',')* val ')'                #noRetAddLineCostum
    |   Add WORD Col '<' WORD ':' type '>' ('(' (val ',')* val ')')?                 #noRetAddCol
    ;

where:
        Where WORD                                                                   #savedWhere
    |    Where val operation val (andOr val operation val)*                          #normalWhere
    ;


forloop:
        For '(' Line WORD ')' WORD '{' stat+ '}'                    #forLine
    |    For '(' type WORD ')' WORD'.'WORD '{' stat+ '}'            #forVal
    ;

bool:	
    True 						        
    | False 					                
    ;


type: 
    
    String        #tStr          
    | Int         #tInt          
    | Real        #tReal         
    | Table       #tTable
    ;

andOr:
        '&&'       
    |   '||'       
    ;

define:
		WORD '=' expr		
    ;


operation: 
        '<' | '>'| '==' | '!=' | '<=' | '>=' 
        ;

val:
        val op=(  '/' |  '*' | '%') val       #valAritMul                                      
    |   val op=( '+' |  '-') val              #valAritSum             
    |   '('val')'                             #valPar
    |   where                                 #valBool
    |	REAL				                  #valReal
    |	NUM					                  #valNum
    |   WORD'.'WORD                           #valTableColumn
    |   WORD                                  #valWord
	|   STRING			                      #valString
    ;                                                 

    // Lexica

Create: [cC][rR][eE][aA][tT][eE];
Delete: [dD][eE][lL][eE][tT][eE];
Line: [lL][iI][nN][eE];
Add: [aA][dD][dD];
Where: [wW][hH][eE][rR][eE];
Get: [gG][eE][tT];
Input: [iI][nN][pP][uU][tT];
Read: [rR][eE][aA][dD];
Save: [sS][aA][vV][eE];
Join:[jJ][oO][iI][nN];
On: [oO][nN];
Expr: [eE][xX][pP][rR];

Col: [cC][oO][lL];
String:  [sS][tT][rR][iI][nN][gG];
Bool: [bB][oO][oO][lL];
Int: [iI][nN][tT];
Real: [rR][eE][aA][lL];
Table: [tT][aA][bB][lL][eE];
Template: [tT][eE][mM][pP][lL][aA][tT][eE];

Print: [pP][rR][iI][nN][tT];
For: [fF][oO][rR];

True: [tT][rR][uU][eE];
False: [fF][aA][lL][sS][eE];




WORD: LETTER (LETTER | DIGIT)*;
STRING: '"' (ESC | . )*? '"';   
NUM: '-'?DIGIT+;
REAL: NUM('.'DIGIT+)?;         



NEWLINE: '\r'? '\n';
WS: [ \t]+ -> skip;

LINE_COMMENT: '#' .*? NEWLINE ->skip;
COMMENT: '/*' .*? '*/' ->skip;

fragment LETTER: 'a'..'z'|'A'..'Z'|'_';
fragment DIGIT: '0'..'9';
fragment ESC: '\\"' | '\\\\';

ERROR: . ;

