grammar READ;

file:   
    line+ EOF;

line:   
    field  (SEP   field)* '\r'?   '\n';

field:   
    TEXT            #fieldText
    |   STRING      #fieldString
    |   INT         #fieldInt
    |   REAL        #fieldReal
    |               #fieldEmpty
    ;

SEP :   ',' ; //    ( '    '   |' \ t  ' )*
STRING: [ \t]*'"'  .*? '"'  [ \t]*;
INT : [ \t]* [0-9]+ [ \t]*;
REAL : [ \t]* [0-9]+('.'[0-9]+) [ \t]*;
TEXT :  ~[,"\r\n]~[,\r\n]*;