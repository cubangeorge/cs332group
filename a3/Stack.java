/*
 * This program is a rewrite of the Stack class to make it immutable
 * @author Jorge L Martinez & Valeria Green & Blake Khan
 * 
 */

public class Stack {

	//Fields ---------------------------------------------
	
	private Object[] elements;
	private int size;
	
	//Constructors --------------------------------
	
	
	/**
	 *
	 * OVERVIEW: A default constructor which initializes the array as empty
	 *
	 */
	public Stack() {
		this.elements = new Object[0];
		
	}
	
	/**
	 *
	 * OVERVIEW: A constructor that accepts parameters for the size
	 * @param int the size of the elements array of the stack
	 *
	 */
	private Stack(int e) {//called by push and last only
		elements = new Object[e];
		size = e;
		
	}
	
	//Methods --------------------------------
	
	
	/**
	 *
	 * OVERVIEW: Returns the size of the stack
	 * @return int the size of the elements array
	 * 
	 */
	public int getSize() {
		return elements.length;
	}

	/**
	 *
	 * OVERVIEW: Returns a new stack with the inputed element added to it
	 * @param Object the new element to add to the end of the stack
	 * @return Stack the new bigger stack to return
	 * 
	 */
	public Stack push(Object e) {//went from mutator to producer

		Stack newStack = new Stack(size+1);//make new bigger stack
		System.arraycopy(elements, 0, newStack.elements, 0, size); //copy over
		newStack.elements[size]=e;	//stick it at the end
		return newStack; //return new immutable stack
	}

	/**
	 *
	 * OVERVIEW: Makes a new stack with one less element in it
	 * @return Stack the new smaller stack to return
	 * 
	 */
	public Stack pop() { // went from mutator to producer
		if (size == 0) {throw new IllegalStateException("The Stack is Empty ");}
		Stack newStack = new Stack(size-1);
		System.arraycopy(elements, 0, newStack.elements, 0, size	-1);
		return newStack;
	}	

	/**
	 *
	 * OVERVIEW: Returns the last Object of an array 
	 * @return Object the last object to return unless the size is zero
	 * 
	 */
	public Object last() {//went from mutator to observer
		if (size == 0) return null;//{throw new IllegalStateException("The Stack is Empty ");}
		return this.elements[this.size-1];
	}

	/**
	 *
	 * OVERVIEW: Returns the string equivalent of the array
	 * @return String the string representation of the object it's being called upon
	 * 
	 */
	@Override
	public String toString() {
		String newString = "";
		for (int i = 0; i < this.elements.length; i++) {
			newString += this.elements[i];
		}

		return newString;
	}
}