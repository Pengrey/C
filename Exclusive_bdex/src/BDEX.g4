

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
	|	expr+ 					#progPrint
    ;

expr:
		[cC][rR][eE][aA][tT][eE] WORD			/*Create*/                                                                          #exprCreate
	| 	[dD][eE][lL][eE][tT][eE] WORD			/*Create*/                                                                          #exprDel
    |   [dD][eE][lL][eE][tT][eE] WORD [lL][iI][nN][eE] [wW][hH][eE][rR][eE] bool            /*Delete*/                              #exprDelLine
	|	[aA][dD][dD] WORD [lL][iI][nN][eE] '('(val',')*val')' 		                        /*ADD Line*/                            #exprAddLine
	| 	[aA][dD][dD] WORD [lL][iI][nN][eE] '<'(WORD',')* WORD'>' '(' (val ',')* val ')'     /*ADD Line*/                            #exprAddLineCostum
    |   [aA][dD][dD] WORD [cC][oO][lL] '<' WORD '>' ('(' (val ',')* val ')')?      /*ADD col*/                                      #exprAddCol
	|	[aA][lL][tT][eE][rR] WORD [lL][iI][nN][eE] ('<'(WORD',')* WORD'>')? '(' (val',')*val ')' [wW][hH][eE][rR][eE] (WORD | val) opBool (WORD | val)	    #exprAlter   /*Alter where*/ 
    |	[gG][eE][tT] WORD [lL][iI][nN][eE] WORD ([wW][hH][eE][rR][eE] (WORD | val) opBool (WORD | val))?	/*get line*/            #exprGetLine
    |	[gG][eE][tT] WORD WORD ([wW][hH][eE][rR][eE] (WORD | val) opBool (WORD | val))?		/*get*/                                 #exprGet
    |   [iI][nN][pP][uU][tT] '(' STRING ')'                                                 /*input*/                               #exprPrint 	// Eu planeio dar input a qualquer coisa e dps vemos se essa coisa pode ser convertida no tipo certo, que acham? (ー_ーゞ
    |   [rR][eE][aA][dD] '('STRING')'                                                       /*read*/                                #exprRead
    |   [sS][aA][vV][eE] '('STRING')'                                                       /*save*/                                #exprSave
    |   WORD [jJ][oO][iI][nN] WORD 	[oO][nN] (WORD | val) opBool (WORD | val)		        /*join on*/                             #exprJoinOn   
	|	WORD [jJ][oO][iI][nN] WORD			                                                /*join*/                                #exprJoin
	|	[jJ][oO][iI][nN]'*' WORD				                                            /*join**/                               #exprJoinAll
    |   WORD [wW][hH][eE][rR][eE] bool                                                      /*where*/                               #exprWhere
    |	'['(val',')* val ']'	                                                                                                    #exprLine
	|	val						                                                                                                    #exprVal
    ;			                                                                           

var:
		[sS][tT][rR][iI][nN][gG] WORD ('=' (expr)+)?				                        #varString
    |	[bB][oO][oO][lL]  WORD	('=' (expr)+)?				                                #varBool
    |	[iI][nN][tT]  WORD	('=' (expr)+)?				                                    #varInt
    |	[rR][eE][aA][lL] 	WORD ('=' (expr)+)?				                                #varReal
    |   [lL][iI][nN][eE] WORD	('=' (expr)+ )?				                                #varLine
    |   [tT][aA][bB][lL][eE] WORD	('=' (expr)+ )?                                         #varTable
    |	[tT][eE][mM][pP][lL][aA][tT][eE] WORD  ('<' WORD ':'type'>')+ ('=' (expr)+ )?	    #varTableCat
    |   [fF][uU][nN][cC] Word ('=' func)
    ;

print: 
    [pP][rR][iI][nN][tT] '(' val ')'
    ;

func:                       // CUIDADO TÀ AQUI UM LOOP <(｀^´)>
    [fF][uU][nN][cC] val (op val)+
    ;
forloop:
    [fF][oO][rR] '(' type word ')' table=( WORD| WORD'.'WORD ) '{' line* '}'


bool:	
    [tT][rR][uU][eE] 						        #boolTrue
    | [fF][aA][lL][sS][eE] 					        #boolFalse
    | val opBool  val		                        #boolOp         // Another loop carefull ( ￣^￣ )
    ;

col:
	[cC][oO][lL] var
	;

type: 
    
    [sS][tT][rR][iI][nN][gG]            /*String*/
    | [bB][oO][oO][lL]                  /*bool*/
    | [iI][nN][tT]                      /*int*/
    | [rR][eE][aA][lL]                  /*real*/
    | [lL][iI][nN][eE]                  /*line*/
    ;

opBool: 
    '<' | '>'| '==' | '!=' | '<=' | '!='
    ; 
opArit:
     '+' |  '-' |  '/' |  '*' | '%'                                              
    ;

op:
    opBool | opArit
    ;
                                            //      Secalhar n precisamos de ter os ops Separados (｡◝‿◜ ｡)

define:
		WORD '=' expr		
    ;

val:
		NUM					#valNum
	|	REAL				#valReal
    |   WORD'.'WORD         #valTableColumn
	|   STRING			    #exprWord
	|	bool				#valBool                    // here the  other part
    |   func                #valFunc                    // ESTÀ AQUI!!!!!! vês? n sei se posso fazer isto ahahahaha
    ;                                                   // mas era fixe se pudesse ¬‿¬
    


    // Lexica
WORD: LETTER (LETTER | DIGIT)*;
STRING: ’"’ (ESC | . )*? ’"’;             
NUM: DIGIT+;
REAL: NUM('.'NUM)? ('e'NUM)?;

fragment LETTER: ’a’..’z’|’A’..’Z’|’_’;
fragment DIGIT: ’0’..’9’;
fragment ESC: ’\\"’ | ’\\\\’ ;

NEWLINE: '\r'? '\n';
WS: [ \t]+ -> skip;

LINE_COMMENT: ’#’ .*? ’\n’ ->skip;
COMMENT: ’/*’ .*? ’*/’ ->skip;
