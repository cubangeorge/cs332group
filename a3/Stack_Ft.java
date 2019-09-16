import java.util.HashMap;
import java.util.Objects;

/*
 * 
 * This program is a rewrite of the Stack class to make it immutable
 * @author Jorge L Martinez & Valeria Green
 * 
 */

public class Stack_Ft{

	private Object[] elements;
	private int size;
	private static final HashMap<Integer ,Object> bucket = new HashMap<>();
	
	public int getSize() {
		return size;
	}
	
	public Stack_Ft() {
		this.elements = new Object[0];
	}
	
	private Stack_Ft(int e) {//called by push and last only
		elements = new Object[e];
		size = e;
		
		
	}

	public Stack_Ft push(Object o){//went from mutator to producer

		Stack_Ft newStack = new Stack_Ft(size+1);//make new bigger stack
		//t = this.bucket;//pass the pointer
		
		
		populate ( o, newStack, size);
		
		return newStack; //return new immutable stack
	}

	/**
	 * Copies over the current stack to the provided new stack, and appends the provided object.
	 * @param e the object to append to the new stack
	 * @param newStack the new stack
	 * @param size the size of the new stack
	 */
	private void populate(Object e, Stack_Ft newStack, int size) {
		// Copy over references from bucket
		for (int i = 0; i < this.elements.length; i++) {
			Object current = elements[i];
			newStack.elements[i] = bucket.putIfAbsent(Objects.hashCode(current), current);
		}

		// Append object to new stack
		newStack.elements[size] = bucket.putIfAbsent(Objects.hashCode(e), e);
	}

	public Stack_Ft pop() { // went from mutator to producer
		if (size == 0) {throw new IllegalStateException("The Stack is Empty ");}
		Stack_Ft newStack = new Stack_Ft(size-1);
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