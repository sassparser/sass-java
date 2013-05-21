package com.sassparser.io;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Collection;
import java.util.List;

import com.sassparser.model.Declaration;
import com.sassparser.model.RuleSet;
import com.sassparser.model.Selector;
import com.sassparser.model.StyleSheet;

/**
 * @author Marcellus Tavares
 */
public class StyleSheetWriterImpl implements StyleSheetWriter {

	public void write(StyleSheet styleSheet, OutputStream outputStream)
		throws Exception {

		Writer writer = new OutputStreamWriter(outputStream);

		Collection<List<RuleSet>> ruleSets = styleSheet.getRuleSets();

		for (List<RuleSet> ruleSetList : ruleSets) {
			for (RuleSet ruleSet : ruleSetList) {
				write(ruleSet, writer);
			}
		}

		writer.close();
	}

	protected void write(RuleSet ruleSet, Writer writer) throws Exception {
		List<Selector> selectors = ruleSet.getSelectors();

		for (int i = 0; i < selectors.size(); i++) {
			Selector selector = selectors.get(i);

			writer.write(selector.getText());

			if ((i + 1) < selectors.size()) {
				writer.write(", ");
			}
		}

		 writer.write('{');

		 List<Declaration> declarations = ruleSet.getDeclarations();

		 for (int i = 0; i < declarations.size(); i++) {
			 Declaration declaration = declarations.get(i);

			 writer.write(declaration.getProperty());
			 writer.write(": ");

			 for (Object value : declaration.getValues()) {
	            writer.write(value.toString());
	        }

	        if (declaration.isImportant()) {
	            writer.write(" !important");
	        }

	        writer.write(";");
		 }

		 writer.write('}');

	}

}