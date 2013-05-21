package com.sassparser.parser;

import java.io.InputStream;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.Tree;

import com.sassparser.error.ErrorHandler;
import com.sassparser.factory.StyleSheetFactory;
import com.sassparser.model.StyleSheet;
import com.sassparser.parser.antlr.SassLexer;
import com.sassparser.parser.antlr.SassParser;

/**
 * @author Marcellus Tavares
 */
public class SassStyleSheetParser implements StyleSheetParser {

	public StyleSheet parse(StyleSheetResource styleSheetResource)
		throws Exception {

		return parse(styleSheetResource, null);
	}

	public StyleSheet parse(
			StyleSheetResource styleSheetResource, ErrorHandler errorHandler)
		throws Exception {

		Tree tree = parse(styleSheetResource.getInputStream(), errorHandler);

		StyleSheet styleSheet = StyleSheetFactory.create(tree);

		return styleSheet;
	}

	protected Tree parse(InputStream inputStream, ErrorHandler errorHandler)
		throws Exception {

		ANTLRInputStream antlrInputStream = new ANTLRInputStream(inputStream);

		SassLexer sassLexer = new SassLexer(antlrInputStream);

		SassParser sassParser = new SassParser(
			new CommonTokenStream(sassLexer));

		sassParser.setErrorHandler(errorHandler);

		SassParser.stylesheet_return stylesheet = sassParser.stylesheet();

		return (Tree)stylesheet.getTree();
	}

}