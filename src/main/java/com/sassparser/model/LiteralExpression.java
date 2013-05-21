package com.sassparser.model;

/**
 * @author Marcellus Tavares
 */
public class LiteralExpression implements Expression {

	public LiteralExpression(String value) {
		_value = value;
	}

	@Override
	public String toString() {
		return _value;
	}

	private String _value;

}