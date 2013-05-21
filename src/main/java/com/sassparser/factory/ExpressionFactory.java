package com.sassparser.factory;

import org.antlr.runtime.tree.Tree;

import com.sassparser.model.Expression;
import com.sassparser.model.LiteralExpression;
import com.sassparser.parser.antlr.SassLexer;

/**
 * @author Marcellus Tavares
 */
public class ExpressionFactory {

	public static Expression create(Tree tree) {
		Expression expression = null;

		switch (tree.getType()) {
			case SassLexer.EXPRESSION:
				break;

			case SassLexer.LITERAL:
				String text = getText(tree);

				expression = new LiteralExpression(text);

				break;
		 }

		return expression;
	}

	// TODO duplicate code Selector
	protected static String getText(Tree tree) {
		 StringBuilder sb = new StringBuilder();

		 for (int i = 0; i < tree.getChildCount(); i++) {
			Tree child = tree.getChild(i);

			sb.append(child.getText());
		}

		 return sb.toString();
	}

}