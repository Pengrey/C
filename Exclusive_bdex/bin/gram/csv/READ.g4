grammar READ;

file:   
    line+ EOF;

line:   
    field  (SEP   field)* '\r'?   '\n';

field:   
    TEXT   |   STRING   |   ;

SEP :    ' , ' ; //    ( '    '   |' \ t  ' )*
STRING: [ \t]*'"'  .*? '"'  [ \t]*;
TEXT :  ~[,"\r\n]~[,\r\n]*;