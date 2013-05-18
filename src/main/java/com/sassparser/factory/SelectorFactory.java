package com.sassparser.factory;

import org.antlr.runtime.tree.Tree;

import com.sassparser.model.Selector;

public class SelectorFactory {

	public static Selector create(Tree tree) {
		Selector selector = new Selector();

		String text = getText(tree);

		selector.setText(text);

		return selector;
	}

	protected static String getText(Tree tree) {
		 StringBuilder sb = new StringBuilder();

		 for (int i = 0; i < tree.getChildCount(); i++) {
			Tree child = tree.getChild(i);

			sb.append(child.getText());
		}

		 return sb.toString();
	}

}
