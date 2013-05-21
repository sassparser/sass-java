package com.sassparser.compiler;

import java.net.URL;

import junit.framework.TestCase;

import com.sassparser.error.ErrorHandler;
import com.sassparser.error.OutputStreamErrorHandler;
import com.sassparser.parser.StyleSheetResource;
import com.sassparser.parser.URLStyleSheetResource;

/**
 * @author Marcellus Tavares
 */
public class SassCompilerTest extends TestCase {

	@Override
	protected void setUp() throws Exception {
		_saasCompiler = new SassCompilerImpl();
	}

	public void testParser() throws Exception {
		compile("css/css.css");
	}

	protected void compile(String sassFilePath) throws Exception {
		Class<?> clazz = getClass();

		ClassLoader classLoader = clazz.getClassLoader();

		URL url = classLoader.getResource(sassFilePath);

		StyleSheetResource styleSheetResource = new URLStyleSheetResource(url);

		ErrorHandler errorHandler = new OutputStreamErrorHandler(System.err);

		String css = _saasCompiler.compile(styleSheetResource, errorHandler);

		System.out.println(css);
	}

	private SassCompiler _saasCompiler;

}
