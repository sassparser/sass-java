package com.sassparser.factory;

import org.antlr.runtime.tree.Tree;

import com.sassparser.model.Declaration;
import com.sassparser.model.RuleSet;
import com.sassparser.model.Selector;
import com.sassparser.parser.antlr.SassLexer;

public class RuleSetFactory {

	public static RuleSet create(Tree tree) {
		RuleSet ruleSet = new RuleSet();

		for (int i = 0; i < tree.getChildCount(); i++) {
			Tree child = tree.getChild(i);

			processChildNode(ruleSet, child);
		}

		return ruleSet;
	}

	protected static void processChildNode(RuleSet ruleSet, Tree tree) {
		switch (tree.getType()) {
			case SassLexer.DECLARATION:
				Declaration declaration = DeclarationFactory.create(tree);

				ruleSet.add(declaration);

				break;

			case SassLexer.SELECTOR:
				Selector selector = SelectorFactory.create(tree);

				ruleSet.add(selector);

				break;
		}
	}

}
