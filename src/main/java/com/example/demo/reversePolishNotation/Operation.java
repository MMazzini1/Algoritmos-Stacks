package com.example.demo.reversePolishNotation;

public enum Operation {


	SUMA("+"){
		@Override public Integer operate(Integer operand1, Integer operand2) {
			return  operand1 + operand2;

		}
	},
	RESTA("-") {
		@Override public Integer operate(Integer operand1, Integer operand2) {
			return operand1 - operand2;
		}
	},
	MULTIPLICACION("×") {
		@Override public Integer operate(Integer operand1, Integer operand2) {
			return operand1 * operand2;
		}
	},
	DIVISION("÷") {
		@Override public Integer operate(Integer operand1, Integer operand2) {
			return operand1 / operand2;
		}
	};

	private String symbol;
	public abstract Integer operate(Integer operand1, Integer operand2);

	Operation(String symbol) {
		this.symbol = symbol;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public static Boolean isOperand(String symbol){

		for (Operation op: values()){
			if (op.getSymbol().equals(symbol)) return true;
		}

		return false;

	}

	public static Operation getOperation(String symbol){
		for (Operation op: values()){
			if (op.getSymbol().equals(symbol)) return op;
		}
		return null;
	}

}
