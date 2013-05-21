package com.sassparser.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RuleSet {

	public void add(Declaration declaration) {
		_declarations.add(declaration);
	}

	public void add(Selector selector) {
		_selectors.add(selector);
	}

	public List<Selector> getSelectors() {
		return _selectors;
	}

	private List<Declaration> _declarations = new ArrayList<Declaration>();
	private List<Selector> _selectors = new ArrayList<Selector>();

	private Map<String, Expression> _expressionMap =
		new LinkedHashMap<String, Expression>();

	public List<Declaration> getDeclarations() {
		return _declarations;
	}


}