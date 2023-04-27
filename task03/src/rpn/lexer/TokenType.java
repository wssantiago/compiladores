package rpn.lexer;

public enum TokenType {
	// Literals.
	NUM,

	// Single-character tokens for operations.
	MINUS, PLUS, SLASH, STAR, HAT,
	
	EOF
}
