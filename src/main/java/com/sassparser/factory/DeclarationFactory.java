package com.sassparser.factory;

import java.util.List;

import org.antlr.runtime.tree.Tree;

import com.sassparser.model.Declaration;
import com.sassparser.parser.antlr.SassLexer;

public class DeclarationFactory {

	public static Declaration create(Tree tree) {
		Declaration declaration = new Declaration();

		for (int i = 0; i < tree.getChildCount(); i++) {
			Tree child = tree.getChild(i);

			processChildNode(declaration, child);
		}

		return declaration;
	}

	protected static void processChildNode(Declaration declaration, Tree tree) {
		switch (tree.getType()) {
			case SassLexer.IDENT:
				String property = tree.getText();

				declaration.setProperty(property);

				break;

			case SassLexer.IMPORTANT_SYM:
				declaration.setImportant(true);

				break;

			case SassLexer.PROPERTY_VALUE:
				List<Object> values = PropertyValueFactory.create(tree);

				declaration.setValues(values);

				break;
		}
	}

}
