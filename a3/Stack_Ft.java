import java.util.HashMap;

/*
 * 
 * This program is a rewrite of the Stack class to make it immutable
 * @author Jorge L Martinez & Valeria Green
 * 
 */

public class Stack_Ft{

	private Object[] elements;
	private int size;
	final static private HashMap<Integer ,Object> bucket = new HashMap<Integer,Object>();
	
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
	private void populate (Object e, Stack_Ft newStack, int size) {
		//will check if Object is not in Hasmap
		// if found it will share it 
		// if not found will add it 
		for (int i = 0; i < this.elements.length; i++) {
			newStack.elements[i] = elements[i];
			//	   }
		
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