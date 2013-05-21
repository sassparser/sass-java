package com.sassparser.compiler;

import java.io.ByteArrayOutputStream;

import com.sassparser.error.ErrorHandler;
import com.sassparser.io.StyleSheetWriter;
import com.sassparser.io.StyleSheetWriterImpl;
import com.sassparser.model.StyleSheet;
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

		StyleSheet styleSheet  = _styleSheetParser.parse(
			styleSheetResource, errorHandler);

		ByteArrayOutputStream byteArrayOutputStream =
			new ByteArrayOutputStream();

		_styleSheetWriter.write(styleSheet, byteArrayOutputStream);

		return byteArrayOutputStream.toString();
	}

	private StyleSheetParser _styleSheetParser = new SassStyleSheetParser();
	private StyleSheetWriter _styleSheetWriter = new StyleSheetWriterImpl();

}