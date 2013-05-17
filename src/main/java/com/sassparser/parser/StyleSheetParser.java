package com.sassparser.parser;

import com.sassparser.error.ErrorHandler;

/**
 * @author Marcellus Tavares
 */
public interface StyleSheetParser {

	public void parse(StyleSheetResource styleSheetResource) throws Exception;

	public void parse(
			StyleSheetResource styleSheetResource, ErrorHandler errorHandler)
		throws Exception;

}