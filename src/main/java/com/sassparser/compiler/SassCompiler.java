package com.sassparser.compiler;

import com.sassparser.error.ErrorHandler;
import com.sassparser.parser.StyleSheetResource;

/**
 * @author Marcellus Tavares
 */
public interface SassCompiler {

	public String compile(StyleSheetResource styleSheetResource)
		throws Exception;

	public String compile(
			StyleSheetResource styleSheetResource, ErrorHandler errorHandler)
		throws Exception;

}