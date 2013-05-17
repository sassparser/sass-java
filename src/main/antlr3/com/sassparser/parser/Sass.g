grammar Sass;

options {
	language = Java;
	output = AST;
}

@lexer::header {
package com.sassparser.parser;
}

@parser::header {
package com.sassparser.parser;
}

SALUTATION:'Hello world';   
ENDSYMBOL:'!';

expression : SALUTATION ENDSYMBOL;