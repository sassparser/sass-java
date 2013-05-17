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
			_outputStream.write(message.getBytes());
			_outputStream.write("\n".getBytes());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private OutputStream _outputStream;

}
