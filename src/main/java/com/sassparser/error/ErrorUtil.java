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
		 sb.append(". Location: line ");
		 sb.append(recognitionException.line);
		 sb.append(", col ");
		 sb.append(recognitionException.charPositionInLine);

		 SassException sassException = new SyntacticException(
			recognitionException);

		 errorHandler.handle(sb.toString(), sassException);
	 }

}