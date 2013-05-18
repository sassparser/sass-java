package com.sassparser.model;

import java.util.List;

public class Declaration {

	public void setImportant(boolean important) {
		_important = important;
	}

	public void setProperty(String property) {
		_property = property;
	}

	public void setValues(List<Object> values) {
		_values = values;
	}

	private boolean _important;
	private String _property;
	private List<Object> _values;

}
