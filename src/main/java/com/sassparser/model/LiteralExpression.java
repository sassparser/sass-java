package com.sassparser.model;

public class LiteralExpression implements Expression {

	public LiteralExpression(String value) {
		_value = value;
	}

	private String _value;

}
