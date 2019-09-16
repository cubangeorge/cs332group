/*
 * 
 * This program is a rewrite of the Stack class to make it immutable
 * @author Jorge L Martinez & Valeria Green & Blake Khan
 * 
 */

public class Stack {
	
	//Fields ---------------------------------------------

	private Object[] elements;
	private int size;


	//Constructors --------------------------------
	
	
	
	/*
	 *
	 * OVERVIEW: Default Constructor without parameters
	 */
	public Stack() {
		this.elements = new Object[0];
	}
	
	/*
	 * @param: Int e - which is the size of the array of elements and the size for the Stack object
	 *
	 * OVERVIEW: Constructor with parameters. Called by push and last only
	 * 
	 */
	private Stack(int e) {
		elements = new Object[e];
		size = e;
	}

	
	//Methods --------------------------------------



	/*
	 * @return: Returns the size of the Stack object
	 *
	 * OVERVIEW: A getter method for returning the size of the object
	 * 
	 */
	public int getSize() {
		return size;
	}
	
	
	/*
	 * @param: Object e - The object to add to the end of the stack
	 * @return: Returns a new stack that is identical to the old stack but with an additional element
	 *
	 * OVERVIEW: A push method to add an element to the end of a stack
	 * Went from mutator to producer
	 */
	public Stack push(Object e) {

		//make new bigger stack
		Stack newStack = new Stack(size+1);
		System.arraycopy(elements, 0, newStack.elements, 0, size); 
		
		//new array has it's elements copied over from the older one and sticks a new element to the end
		newStack.elements[size]=e;	
		//return new immutable stack
		return newStack; 
	}

	
	/*
	 * 
	 * @return: Returns a new stack without the last element in the stack
	 * @throws: IllegalStateException if the array is empty
	 *
	 * REQUIRES: The stack object to not be empty
	 * OVERVIEW: A pop method to return a new stack without the last element.
	 * Went from mutator to producer
	 */
	public Stack pop() { 
		if (size == 0) {throw new IllegalStateException("The Stack is Empty ");}
		Stack newStack = new Stack(size-1);
		System.arraycopy(elements, 0, newStack.elements, 0, size	-1);
		return newStack;
	}	

	/*
	 * 
	 * @return: Returns the last element in an array
	 * @throws: IllegalStateException if the array is empty
	 *
	 * REQUIRES: The stack object to not be empty
	 * OVERVIEW: A method to return the last element in an array
	 * 
	 * went from mutator to observer
	 */
	public Object last() {
		if (size == 0) {throw new IllegalStateException("The Stack is Empty ");}
		return this.elements[this.size-1];
	}

	/*
	 * 
	 * @return: A string of the object's contents
	 * 
	 * OVERVIEW: A method to return a string version of the object
	 * 
	 */
	public String toString() {
		String newString = "";
		for (int i = 0; i < this.elements.length; i++) {
			newString += this.elements[i];
		}

		return newString;
	}
}