/*
 * 
 * This program is a rewrite of the Stack class to make it immutable
 * @author Jorge L Martinez & Valeria Green
 * 
 */

public class Stack {

	private Object[] elements;
	private int size;
	

	
	public int getSize() {
		return size;
	}
	
	public Stack() {
		this.elements = new Object[0];
		
	}
	
	private Stack(int e) {//called by push and last only
		elements = new Object[e];
		size = e;
		
	}

	public Stack push(Object e) {//went from mutator to producer

		Stack newStack = new Stack(size+1);//make new bigger stack
		System.arraycopy(elements, 0, newStack.elements, 0, size); //copy over
		newStack.elements[size]=e;	//stick it at the end
		return newStack; //return new immutable stack
	}

	public Stack pop() { // went from mutator to producer
		if (size == 0) {throw new IllegalStateException("The Stack is Empty ");}
		Stack newStack = new Stack(size-1);
		System.arraycopy(elements, 0, newStack.elements, 0, size	-1);
		return newStack;
	}	

	public Object last() {//went from mutator to observer
		if (size == 0) {throw new IllegalStateException("The Stack is Empty ");}
		return this.elements[this.size-1];
	}

	public String toString() {
		String newString = "";
		for (int i = 0; i < this.elements.length; i++) {
			newString += this.elements[i];
		}

		return newString;
	}
}