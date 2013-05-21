package com.sassparser.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Marcellus Tavares
 */
public class StyleSheet {

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

	public Collection<List<RuleSet>> getRuleSets() {
		return _ruleSetMap.values();
	}

	private Map<Selector, List<RuleSet>> _ruleSetMap =
		new LinkedHashMap<Selector, List<RuleSet>>();

}