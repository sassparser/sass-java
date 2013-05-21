package com.sassparser.error;

/**
 * @author Marcellus Tavares
 */
public class SassException extends Exception {

	public SassException() {
		super();
	}

	public SassException(String message) {
		super(message);
	}

	public SassException(Throwable cause) {
		super(cause);
	}

	public SassException(String message, Throwable cause) {
		super(message, cause);
	}

}