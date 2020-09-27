package com.example.demo.stackWithMaxApi;

import com.example.demo.stack.Stack;

/**
 * El ejercicio consiste en implementar un stack con un metodo
 * que permita obtener el máximo.
 * @param <T>
 */


/**
 * Esta solución consiste en mantener un stack auxiliar que va registrando el maximo visto hasta el momento.
 * Si pusheas un elemento mayor (o igual) a este máximo, lo pusheas al stack auxiliar. (tu stack principal tiene un nuevo máximo)
 * Si haces pop y el elemento es igual al máximo, entonces tenes que popearlo del stack auxiliar (ya no está más en tu stack principal)
 * @param <T>
 *
 *
 * La solución óptima desde el punto de vista de la complejidad especial implica un algoritmo
 * similar, pero almacenando en el stack auxiliar las veces que apareció el máximo (para evitar insertar repetidos)
 *
 */
public class StackWithMaxApi<T extends Comparable>{

	private Stack<T> stack;
	private Stack<T> maxStack;



	public void push(T value) {
		stack.push(value);
		//El igual es necesario para el caso de que se inserten múltiples valores repetidos iguales al máximo.
		if (value.compareTo(maxStack.peek()) >= 0){
			maxStack.push(value);
		}
	}

	public T pop() {
		T pop = stack.pop();
		if (pop.compareTo(maxStack.peek()) == 0){
			maxStack.pop();
		}
		return pop;
	}

	public T getMax(){
		return maxStack.peek();
	}

	@Override public String toString() {
		return stack.toString() + "\n" + maxStack.toString();
	}
}