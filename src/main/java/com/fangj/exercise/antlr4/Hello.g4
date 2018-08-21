// Define a grammar called Hello 这里必须与文件同名，否则会报错
grammar Hello;

r  : 'hello' ID ;         // match keyword ‘hello’ followed by an identifier
ID : [a-z]+ ;             // match lower-case identifiers
WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines