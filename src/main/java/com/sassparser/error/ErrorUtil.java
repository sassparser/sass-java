package com.sassparser.error;

import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.RecognitionException;

/**
 * @author Marcellus Tavares
 */
public class ErrorUtil {

	 public static void handleError(
		ErrorHandler errorHandler, RecognitionException recognitionException,
		BaseRecognizer baseRecognizer) {

		 StringBuilder sb = new StringBuilder();

		 sb.append("Syntax error, ");
		 sb.append(
			baseRecognizer.getErrorMessage(
				recognitionException, baseRecognizer.getTokenNames()));
		 sb.append(". Line ");
		 sb.append(recognitionException.line);

		 SassException sassException = new SyntacticException(
			recognitionException);

		 errorHandler.handle(sb.toString(), sassException);
	 }

}