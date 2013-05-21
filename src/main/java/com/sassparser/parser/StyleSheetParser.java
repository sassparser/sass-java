package com.sassparser.parser;

import com.sassparser.error.ErrorHandler;
import com.sassparser.model.StyleSheet;

/**
 * @author Marcellus Tavares
 */
public interface StyleSheetParser {

	public StyleSheet parse(StyleSheetResource styleSheetResource)
		throws Exception;

	public StyleSheet parse(
			StyleSheetResource styleSheetResource, ErrorHandler errorHandler)
		throws Exception;

}