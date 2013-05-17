package com.sassparser;

import static org.junit.Assert.assertEquals;

import org.antlr.runtime.tree.CommonTree;
import org.junit.Test;

import com.sassparser.parser.SassParser;

public class AppTest {

	@Test
	public void testCorrectExpression() {

		App app = new App();

		CommonTree ast = app.compile("Hello world!");

		assertEquals(SassParser.SALUTATION, ast.getChild(0).getType());
		assertEquals(SassParser.ENDSYMBOL, ast.getChild(1).getType());
	}
}
