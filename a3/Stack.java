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

//	public Stack(int size, Object[] elements) {
//		this.size = size;
//		this.elements = elements;
//	}

	//takes an object of a type and produces a new one
	//takes the old elements array and size of it to make a new array with the input parameter as the latest element. Then makes a new object based off of that.
	//   public Stack push(Object e) {
	//	   int newSize = elements.length + 1;
	//	   Object newishElements[] = new Object[newSize];
	//	   //System.arraycopy(elements, 0, newishElements, 0, newSize);
	//	   for (int i = 0; i < elements.length; i++) {
	//		   newishElements[i] = elements[i];
	//	   }
	//	   
	//	   newishElements[newSize-1] = e;
	//			   
	//	   Stack newerStack = new Stack(newSize, newishElements);
	//	     
	//	    return newerStack;
	//   }
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
		return this.elements[this.size];
	}

	public String toString() {
		String newString = "";
		for (int i = 0; i < this.elements.length; i++) {
			newString += this.elements[i];
		}

		return newString;
	}
}