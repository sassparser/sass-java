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

// ==============================================================
// Lexer
// ==============================================================

fragment A
	: ('a'|'A') 
	| '\\' ('0' ('0' ('0' '0'?)?)?)? ('4'|'6')'1'
	;

fragment B
	: ('b'|'B') 
	| '\\' ('0' ('0' ('0' '0'?)?)?)? ('4'|'6')'2'
	;

fragment C
	: ('c'|'C') 
	| '\\' ('0' ('0' ('0' '0'?)?)?)? ('4'|'6')'3'
	;

fragment D
	: ('d'|'D') 
	| '\\' ('0' ('0' ('0' '0'?)?)?)? ('4'|'6')'4'
	;

fragment E
	: ('e'|'E') 
	| '\\' ('0' ('0' ('0' '0'?)?)?)? ('4'|'6')'5'
	;

fragment F
	: ('f'|'F')
	| '\\' ('0' ('0' ('0' '0'?)?)?)? ('4'|'6')'6'
	;

fragment G
	: ('g'|'G')
	| '\\' ( 'g' | 'G' | ('0' ('0' ('0' '0'?)?)?)? ('4'|'6')'7' )
	;

fragment H
	: ('h'|'H') 
	| '\\' ( 'h' | 'H' | ('0' ('0' ('0' '0'?)?)?)? ('4'|'6')'8' )
	;

fragment I
	: ('i'|'I') | '\\' ( 'i' | 'I' | ('0' ('0' ('0' '0'?)?)?)? ('4'|'6')'9' )
	;

fragment J
	: ('j'|'J') 
	| '\\' ( 'j' | 'J' | ('0' ('0' ('0' '0'?)?)?)? ('4'|'6')('A'|'a') )
	;

fragment K
	: ('k'|'K') 
	| '\\' ( 'k' | 'K' | ('0' ('0' ('0' '0'?)?)?)? ('4'|'6')('B'|'b') )
	;

fragment L
	: ('l'|'L') 
	| '\\' ( 'l' | 'L' | ('0' ('0' ('0' '0'?)?)?)? ('4'|'6')('C'|'c') )
	;

fragment M
	: ('m'|'M') 
	| '\\' ( 'm' | 'M' | ('0' ('0' ('0' '0'?)?)?)? ('4'|'6')('D'|'d') )
	;

fragment N
	: ('n'|'N') 
	| '\\' ( 'n' | 'N' | ('0' ('0' ('0' '0'?)?)?)? ('4'|'6')('E'|'e') )
	;

fragment O
	: ('o'|'O')
	| '\\' ( 'o' | 'O' | ('0' ('0' ('0' '0'?)?)?)? ('4'|'6')('F'|'f') )
	;

fragment P
	: ('p'|'P')
	| '\\' ( 'p' | 'P' | ('0' ('0' ('0' '0'?)?)?)? ('5'|'7')('0') )
	;

fragment Q
	: ('q'|'Q')
	| '\\' ( 'q' | 'Q' | ('0' ('0' ('0' '0'?)?)?)? ('5'|'7')('1') )
	;

fragment R
	: ('r'|'R')
	| '\\' ( 'r' | 'R' | ('0' ('0' ('0' '0'?)?)?)? ('5'|'7')('2') )
	;

fragment S
	: ('s'|'S')
	| '\\' ( 's' | 'S' | ('0' ('0' ('0' '0'?)?)?)? ('5'|'7')('3') )
	;

fragment T
	: ('t'|'T') 
	| '\\' ( 't' | 'T' | ('0' ('0' ('0' '0'?)?)?)? ('5'|'7')('4') )
	;

fragment U
	: ('u'|'U') 
	| '\\' ( 'u' | 'U' | ('0' ('0' ('0' '0'?)?)?)? ('5'|'7')('5') )
	;

fragment V
	: ('v'|'V')
	| '\\' ( 'v' | 'V' | ('0' ('0' ('0' '0'?)?)?)? ('5'|'7')('6') )
	;

fragment W
	: ('w'|'W')
	| '\\' ( 'w' | 'W' | ('0' ('0' ('0' '0'?)?)?)? ('5'|'7')('7') )
	;
fragment X
	: ('x'|'X')
	| '\\' ( 'x' | 'X' | ('0' ('0' ('0' '0'?)?)?)? ('5'|'7')('8') )
	;

fragment Y
	: ('y'|'Y')
	| '\\' ( 'y' | 'Y' | ('0' ('0' ('0' '0'?)?)?)? ('5'|'7')('9') )
	;

fragment Z
	: ('z'|'Z')
	| '\\' ( 'z' | 'Z' | ('0' ('0' ('0' '0'?)?)?)? ('5'|'7')('A'|'a') )
	;

fragment DIGIT
	: '0'..'9'
	;

fragment ESCAPE
	: UNICODE
	| '\\' ~('\r'|'\n'|'\f'|HEXCHAR)
	;
	
fragment HEXCHAR
	: ('a'..'f'|'A'..'F'|'0'..'9')  
	;


fragment NMCHAR
    : NMSTART
    | DIGIT
    | MINUS
    ;

fragment NMSTART
	: '_'
	| 'a'..'z'
	| 'A'..'Z'
	| NONASCII
	| ESCAPE
	;

fragment NONASCII
	: '\u0080'..'\uFFFF'
	;

fragment SIGN
	: PLUS
	| MINUS
	;

fragment UNICODE
	: '\\' HEXCHAR 
			(HEXCHAR 
				(HEXCHAR 
					(HEXCHAR 
						(HEXCHAR HEXCHAR?)?
					)?
				)?
			)? 
	;

fragment URL_NO_WS
	: ~('\n'|'\r'|'\f'|'\''|'"'|RPAREN|' '|'\t')
	;

fragment INVALID :;

COLON : ':' ;

COMMA : ',' ;

DOT : '.' ;

END_MATCH : '$=' ;

GREATER : '>' ;

LBRACE : '{' ;

LBRACKET : '[';

LPAREN : '(' ;

MINUS : '-' ;

EQUAL : '=' ;

PERCENT : '%' ;

PLUS : '+' ;

RBRACE : '}' ;

RBRACKET : ']' ;

RPAREN : ')' ;

SEMI : ';' ;

SLASH : '/' ;

STAR : '*' ;

START_MATCH : '^=' ;

SUBSTR_MATCH : '*=' ;

UNDERSCORE : '_' ;
	
COMMENT
	: '/*' ( options { greedy = false; } : .* ) '*/'
		{ 
			$channel = HIDDEN; 
		}
	;

CDO
	: '<!--'
		{
			$channel = HIDDEN; 
		}
	;

CDC
	: '-->'
		{
			$channel = HIDDEN; 
		}
	;

STRING
	: '\'' ( ~('\n'|'\r'|'\f'|'\'') )* ( '\'' | { $type = INVALID; } )
	| '"'  ( ~('\n'|'\r'|'\f'|'"')  )* ( '"'  | { $type = INVALID; } )
	;
	
IMPORT_SYM
	: '@' I M P O R T
	;

IMPORTANT_SYM
	: '!' I M P O R T A N T
	;

PAGE_SYM
	: '@' P A G E
	;

MEDIA_SYM
	: '@' M E D I A
	;

CHARSET
	: '@charset'
	;
	
IDENT
	: MINUS? NMSTART NMCHAR*
	;

HASH
	: '#' NMCHAR+
	;

fragment UNIT
    : ('a'..'z' | 'A'..'Z' | NONASCII | ESCAPE)+ | PERCENT
    ;

NUMBER
    : ( (DIGIT+ (DOT DIGIT*)? | DOT DIGIT+) ) UNIT?
    ;

RGB_COLOR
	: R G B   WS* LPAREN WS* NUMBER WS* COMMA WS* NUMBER WS* COMMA WS* NUMBER WS* RPAREN
	| R G B A WS* LPAREN WS* NUMBER WS* COMMA WS* NUMBER WS* COMMA WS* NUMBER WS* COMMA WS* NUMBER WS* RPAREN 
	;
    
HSL_COLOR
    : H S L   WS* LPAREN WS* NUMBER WS* COMMA WS* NUMBER WS* COMMA WS* NUMBER WS* RPAREN
    | H S L A WS* LPAREN WS* NUMBER WS* COMMA WS* NUMBER WS* COMMA WS* NUMBER WS* COMMA WS* NUMBER WS* RPAREN 
    ;

URI 
	: U R L 
		(
			LPAREN WS* (STRING) WS* RPAREN
			| LPAREN WS*  URL_NO_WS (~('\n'|'\r'|'\f'|'\''|'"'|RPAREN)* URL_NO_WS)? WS* ( RPAREN | { $type = INVALID; } )
         )
    ;

WS : ( ' ' | '\t' | '\r' | '\n' | '\f' )+ ;