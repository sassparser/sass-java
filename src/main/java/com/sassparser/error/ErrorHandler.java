package com.sassparser.error;

/**
 * @author Marcellus Tavares
 */
public interface ErrorHandler {

	public void handle(String message, SassException sassException);

}