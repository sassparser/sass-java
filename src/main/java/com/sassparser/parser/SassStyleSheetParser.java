package com.sassparser.parser;

import java.io.InputStream;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.Tree;

import com.sassparser.error.ErrorHandler;
import com.sassparser.parser.antlr.SassLexer;
import com.sassparser.parser.antlr.SassParser;

/**
 * @author Marcellus Tavares
 */
public class SassStyleSheetParser implements StyleSheetParser {

	public void parse(StyleSheetResource styleSheetResource) throws Exception {
		parse(styleSheetResource, null);
	}

	public void parse(
			StyleSheetResource styleSheetResource, ErrorHandler errorHandler)
		throws Exception {

		parse(styleSheetResource.getInputStream(), errorHandler);
	}

	protected Tree parse(InputStream inputStream, ErrorHandler errorHandler)
		throws Exception {

		ANTLRInputStream antlrInputStream = new ANTLRInputStream(inputStream);

		SassLexer sassLexer = new SassLexer(antlrInputStream);

		SassParser sassParser = new SassParser(
			new CommonTokenStream(sassLexer));

		sassParser.setErrorHandler(errorHandler);

		return (Tree)sassParser.stylesheet().getTree();
	}

}