package com.sassparser.model;

import java.util.List;

/**
 * @author Marcellus Tavares
 */
public class Declaration {

	public void setImportant(boolean important) {
		_important = important;
	}

	public void setProperty(String property) {
		_property = property;
	}

	public String getProperty() {
		return _property;
	}

	public void setValues(List<Object> values) {
		_values = values;
	}

	public List<Object> getValues() {
		return _values;
	}

	public boolean isImportant() {
		return _important;
	}

	private boolean _important;
	private String _property;
	private List<Object> _values;

}