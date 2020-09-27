package com.example.demo.reversePolishNotation;

import com.example.demo.stack.Stack;



/**
 * El problema consiste en escribir un algoritmo para parsear reverse polish notation.
 * https://en.wikipedia.org/wiki/Reverse_Polish_notation
 *
 * Para la soluci�n se utiliza un stack en el cu�l se van almacenando los n�meros que aparecen.
 * Cada vez que aparece un operando, este se aplica a los dos �ltimos elementos del stack, y el resultado se pushea.
 * Al final del procesamiento, si el string rpn est� bien formado, en ese stack va a quedar un �nico n�mero que es el resultado de la operaci�n
 *
 * Para la soluci�n escrib� una clase adicional Operation (un enum), que abstrae la l�gica de cada operando particular. 
 *
 */
public class ReversePolishNotation {

	//TODO: escribir caso de test
	public static void main(String[] args) {

		String rpn = "15,7,1,1,+,-,�,3,�,2,1,1,+,+,-";
		Integer integer = EvaluateRPN(rpn);

		rpn = "2,3,+,5,-";  //=
		integer = EvaluateRPN(rpn);

		rpn = "2,3,�,5,5,�,+";   //31
		integer = EvaluateRPN(rpn);

	}


	public static Integer EvaluateRPN(String RPN){

		String[] expressionSymbols  = RPN.split(",");

		Stack<String> numberStack = new Stack<String>();

		for (String symbol: expressionSymbols){

			if (Operation.isOperand(symbol)){
				String two = numberStack.pop();
				String one = numberStack.pop();
				Operation operation = Operation.getOperation(symbol);
				Integer result  = operation.operate(Integer.parseInt(one), Integer.parseInt(two));
				numberStack.push(result.toString());
			}else {
				numberStack.push(symbol);
			}
		}

		return Integer.valueOf(numberStack.pop());



	}


}
