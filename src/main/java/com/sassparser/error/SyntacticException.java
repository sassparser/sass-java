package com.sassparser.error;

/**
 * @author Marcellus Tavares
 */
public class SyntacticException extends SassException {

	public SyntacticException() {
		super();
	}

	public SyntacticException(String message) {
		super(message);
	}

	public SyntacticException(Throwable cause) {
		super(cause);
	}

	public SyntacticException(String message, Throwable cause) {
		super(message, cause);
	}

}