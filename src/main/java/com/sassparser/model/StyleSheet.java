package com.sassparser.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StyleSheet extends Node {

	public void add(RuleSet ruleSet) {
		for (Selector selector : ruleSet.getSelectors()) {
			List<RuleSet> ruleSetList = _ruleSetMap.get(selector);

			if (ruleSetList == null) {
                ruleSetList = new ArrayList<RuleSet>();

                _ruleSetMap.put(selector, ruleSetList);
            }

			ruleSetList.add(ruleSet);
		}
	}

	private Map<Selector, List<RuleSet>> _ruleSetMap =
		new LinkedHashMap<Selector, List<RuleSet>>();

}