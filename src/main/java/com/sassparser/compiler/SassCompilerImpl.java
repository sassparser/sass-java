package com.sassparser.compiler;

import com.sassparser.error.ErrorHandler;
import com.sassparser.parser.SassStyleSheetParser;
import com.sassparser.parser.StyleSheetParser;
import com.sassparser.parser.StyleSheetResource;

/**
 * @author Marcellus Tavares
 */
public class SassCompilerImpl implements SassCompiler {

	public String compile(StyleSheetResource styleSheetResource)
		throws Exception {

		return compile(styleSheetResource, null);
	}

	@Override
	public String compile(
			StyleSheetResource styleSheetResource, ErrorHandler errorHandler)
		throws Exception {

		_styleSheetParser.parse(styleSheetResource, errorHandler);

		return null;
	}

	private StyleSheetParser _styleSheetParser = new SassStyleSheetParser();

}