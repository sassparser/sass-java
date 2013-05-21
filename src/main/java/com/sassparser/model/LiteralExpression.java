package com.sassparser.model;

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
