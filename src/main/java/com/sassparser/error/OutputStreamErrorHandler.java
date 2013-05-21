package com.sassparser.error;

import java.io.OutputStream;

/**
 * @author Marcellus Tavares
 */
public class OutputStreamErrorHandler implements ErrorHandler {

	public OutputStreamErrorHandler(OutputStream outputStream) {
		_outputStream = outputStream;
	}

	public void handle(String message, SassException sassException) {
		try {
			message = message.concat("\n");

			_outputStream.write(message.getBytes());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private OutputStream _outputStream;

}