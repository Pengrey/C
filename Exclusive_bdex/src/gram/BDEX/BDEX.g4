

//Não esquecer: No fim, dá uma vista de olhos ao código todo. Something doesn't smell right (⌐■_■)



grammar BDEX;

program:
    stat* EOF;

stat:
        line? NEWLINE           
    ;

line:
		var	            	    #progVar
	|	define 					#progDef
    |   noRetFunc               #prognoRetFunc
    |   forloop                 #statLoop
    ;

expr: 
		Create WORD			                              #exprCreate
    |	Get WORD Line WORD (Where opBool )?	              #exprGetLine
    |	Get WORD WORD (Where opBool )?		              #exprGet
    |   Input '(' STRING ')'                              #exprPrint 	// Eu planeio dar input a qualquer coisa e dps vemos se essa coisa pode ser convertida no tipo certo, que acham? (ー_ーゞ
    |   Read '('STRING')'                                 #exprRead
    |   Save '('STRING')'                                 #exprSave
    |   WORD Join WORD 	On  opBool 		                  #exprJoinOn   
	|	WORD Join WORD			                          #exprJoin
	//|	Join'*' WORD				                      #exprJoinAll
    |   WORD Where opBool                                 #exprWhere
    |	'['(val',')* val ']'	                          #exprLine
	|	val						                          #exprVal
    ;			                                                                           

var:
		String WORD ('=' (expr)+)?				                            #varStr
    |	Bool  WORD	('=' (expr)+)?				                            #varBool
    |	Int  WORD	('=' (expr)+)?				                            #varInt
    |	Real 	WORD ('=' (expr)+)?				                            #varReal
    |   Line WORD	('=' (expr)+ )?				                            #varLine
    |   Table WORD	('=' (expr)+ )?                                         #varTable
    |	Template WORD  ('[' WORD ':'(type| WORD'.'WORD Where opBool)']')+ ('=' (expr)+ )?	            #varTableCat
    //|   Func Word ('=' func)                                              #varFunc
    |   Col type WORD ('=' (expr)+ )?				                        #varCol 
    ;

noRetFunc: 
        Print '(' val ')'                                                                #noRetPrint
    | 	Delete WORD	(Line Where opBool)?		                                         #noRetDel
	| 	Add WORD Line ('<'(WORD',')* WORD'>')? '(' (val ',')* val ')'                    #noRetAddLineCostum
    |   Add WORD Col '<' WORD '>' ('(' (val ',')* val ')')?                              #noRetAddCol
	|	Alter WORD Line ('<'(WORD',')* WORD'>')? '(' (val',')*val ')' Where opBool	     #noRetAlter    
    ;

func:                       // CUIDADO TÀ AQUI UM LOOP <(｀^´)>
    Func op+
    ;
forloop:
        For '(' type WORD ')' WORD('.'WORD)? '{' stat* '}'     
    ;

bool:	
    True 						        #boolTrue
    | False 					        #boolFalse
    //| val opBool  val		            #boolOp         // Another loop carefull ( ￣^￣ )
    ;


type: 
    
    String                  
    | Bool                  
    | Int                   
    | Real                  
    | Line                  
    | Table
    | func
    ;

opBool: 
    val ('<' | '>'| '==' | '!=' | '<=' | '!=') val
    ; 
opArit:
     val ('+' |  '-' |  '/' |  '*' | '%') val                                              
    ;

op:
        opBool          #opBoolean
   |    opArit          #opAritmetica
    ;
                                            //      Secalhar n precisamos de ter os ops Separados (｡◝‿◜ ｡)

define:
		WORD '=' expr		
    ;

val:
		NUM					#valNum
	|	REAL				#valReal
    |   WORD                #valWord
    |   WORD'.'WORD         #valTableColumn
	|   STRING			    #exprWord
	|	bool				#valBool                    // here the  other part
    |   func                #valFunc                    // ESTÀ AQUI!!!!!! vês? n sei se posso fazer isto ahahahaha
    ;                                                   // mas era fixe se pudesse ¬‿¬

    // Lexica

Create: [cC][rR][eE][aA][tT][eE];
Delete: [dD][eE][lL][eE][tT][eE];
Update: [uU][pP][dD][aA][tT][eE];
Line: [lL][iI][nN][eE];
Add: [aA][dD][dD];
Alter: [aA][lL][tT][eE][rR] ;
Where: [wW][hH][eE][rR][eE];
Get: [gG][eE][tT];
Input: [iI][nN][pP][uU][tT];
Read: [rR][eE][aA][dD];
Save: [sS][aA][vV][eE];
Join:[jJ][oO][iI][nN];
On: [oO][nN];

Col: [cC][oO][lL];
String:  [sS][tT][rR][iI][nN][gG];
Bool: [bB][oO][oO][lL];
Int: [iI][nN][tT];
Real: [rR][eE][aA][lL];
Table: [tT][aA][bB][lL][eE];
Template: [tT][eE][mM][pP][lL][aA][tT][eE];

Func: [fF][uU][nN][cC];
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
