package com.sassparser.factory;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.tree.Tree;

import com.sassparser.model.Expression;
import com.sassparser.parser.antlr.SassLexer;

/**
 * @author Marcellus Tavares
 */
public class PropertyValueFactory {

	public static List<Object> create(Tree tree) {
		List<Object> values = new ArrayList<Object>();

		for (int i = 0; i < tree.getChildCount(); i++) {
			Tree child = tree.getChild(i);

			processChildNode(values, child);
		}

		return values;
	}

	protected static void processChildNode(List<Object> values, Tree tree) {
		switch (tree.getType()) {
			case SassLexer.EXPRESSION:
			case SassLexer.LITERAL:
				Expression expression = ExpressionFactory.create(tree);

				values.add(expression);

				break;

			case SassLexer.COMMA:
			case SassLexer.NUMBER:
			case SassLexer.IDENT:
			case SassLexer.STRING:
				values.add(tree.getText());

				break;
		}
	}

}