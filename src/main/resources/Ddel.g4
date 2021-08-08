grammar Ddel;

@header {
    package cn.emengjzs.ddel.antlr;
}

expression
    : expression '[' expressionSequence ']' # MemberIndexExpression
    | expression '.' IDENTIFIER             # MemberDotExpression
    | IDENTIFIER                            # IdentifierExpression
    | arrayLiteral                          # ArrayLiteralExpression
    | literal                               # LiteralExpression
    ;

expressionSequence
    : expression (',' expression)?
    ;

arrayLiteral
    : ('[' elementList ']')
    ;

elementList
    : arrayElement? (',' arrayElement)*
    ;

arrayElement
    : expression
    ;

literal
    : DECIMAL_LITERAL                    # DecimalLiteral
    | STRING_LITERAL                     # StringLiteral
    ;

DECIMAL_LITERAL:    ('0' | [1-9] Digits?);
STRING_LITERAL:     '\'' (~['\\\r\n] | EscapeSequence)* '\'';

DOT:                '.';
LBRACK:             '[';
RBRACK:             ']';
COMMA:              ',';

IDENTIFIER:         Letter LetterOrDigit*;

WS:                 [ \t\r\n\u000C]+ -> channel(HIDDEN);

fragment ExponentPart
    : [eE] [+-]? Digits
    ;

fragment EscapeSequence
    : '\\' [btnfr"'\\]
    | '\\' ([0-3]? [0-7])? [0-7]
    | '\\' 'u'+ HexDigit HexDigit HexDigit HexDigit
    ;

fragment HexDigit
    : [0-9a-fA-F]
    ;

fragment Digits
    : [0-9] ([0-9_]* [0-9])?
    ;

fragment LetterOrDigit
    : Letter
    | [0-9]
    ;
fragment Letter
    : [a-zA-Z$_] // these are the "java letters" below 0x7F
    | ~[\u0000-\u007F\uD800-\uDBFF] // covers all characters above 0x7F which are not a surrogate
    | [\uD800-\uDBFF] [\uDC00-\uDFFF] // covers UTF-16 surrogate pairs encodings for U+10000 to U+10FFFF
    ;