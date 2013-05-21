package com.sassparser.factory;

import org.antlr.runtime.tree.Tree;

import com.sassparser.model.RuleSet;
import com.sassparser.model.StyleSheet;
import com.sassparser.parser.antlr.SassLexer;

/**
 * @author Marcellus Tavares
 */
public class StyleSheetFactory {

	public static StyleSheet create(Tree tree) {
		StyleSheet styleSheet = new StyleSheet();

		for (int i = 0; i < tree.getChildCount(); i++) {
			Tree child = tree.getChild(i);

			processChildNode(styleSheet, child);
		}

		return styleSheet;
	}

	protected static void processChildNode(StyleSheet styleSheet, Tree tree) {
		switch (tree.getType()) {
			case SassLexer.RULESET:
				RuleSet ruleSet = RuleSetFactory.create(tree);

				styleSheet.add(ruleSet);

				break;
		}
	}

}