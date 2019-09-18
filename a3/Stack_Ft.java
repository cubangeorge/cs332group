import java.util.HashMap;
import java.util.Objects;

/*
 * 
 * This program is a rewrite of the Stack class to make it immutable
 * @author Jorge L Martinez & Valeria Green & Blake Khan
 * 
 */

public class Stack_Ft{

	//Fields ---------------------------------------------
	
	private final int[] elements; // Stores the hashcodes. Used as keys in the bucket cache.
	private final int size;
	private static final HashMap<Integer, Object> bucket = new HashMap<>();
	
	//Constructors --------------------------------
	
	
	/**
	 *
	 * OVERVIEW: References the current object and initializes it with zero
	 * 
	 */
	public Stack_Ft() {
		this(0);
	}
	
	/**
	 *
	 * OVERVIEW: Creates a new array of elements of the size received from the parameter
	 * @param int the size of the object
	 * 
	 */
	private Stack_Ft(int e) {//called by push and last only
		elements = new int[e];
		size = e;
	}
	
	//Methods --------------------------------
	
	
	/**
	 *
	 * OVERVIEW: Returns the size of the stack
	 * @param int the size of the stack
	 * 
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 *
	 * OVERVIEW: Returns the size of the map
	 * @param int the size of the bucket
	 * 
	 */
	public static int getMapsize() {
		return bucket.size();
	}
	

	/**
	 *
	 * OVERVIEW: Returns a new stack with the inputed element added to it
	 * @param Object the new element to add to the end of the stack
	 * @return Stack_Ft the new stack to return
	 * 
	 */
	public Stack_Ft push(Object o){//went from mutator to producer
		Stack_Ft newStack = new Stack_Ft(size+1);//make new bigger stack
		return populate(o, newStack, size); //return new immutable stack
	}

	/**
	 * Copies over the current stack to the provided new stack, and appends the provided object.
	 * @param e the object to append to the new stack
	 * @param newStack the new stack
	 * @param size the size of the new stack
	 */
	private Stack_Ft populate(Object e, Stack_Ft newStack, int size) {
		// Copy over current array
		System.arraycopy(elements, 0, newStack.elements, 0, elements.length);

		// Append hashcode to new stack & cache in map
		int hash = Objects.hashCode(e);
		bucket.putIfAbsent(hash, e);
		newStack.elements[size] = hash;
		return newStack;
	}

	/**
	 *
	 * OVERVIEW: Makes a new stack with one less element in it
	 * @return Stack_Ft the new stack to return
	 * 
	 */
	public Stack_Ft pop() { // went from mutator to producer
		if (size == 0) {throw new IllegalStateException("The Stack is Empty ");}
		Stack_Ft newStack = new Stack_Ft(size-1);
		System.arraycopy(elements, 0, newStack.elements, 0, size	-1);
		return newStack;
	}
	
	/**
	 *
	 * OVERVIEW: Returns the last Object of an array 
	 * @return Object the last object to return
	 * @throws IllegalStateException if the stack is empty or of size zero
	 * 
	 */
	public Object last() {//went from mutator to observer
		if (size == 0) {throw new IllegalStateException("The Stack is Empty ");}
		return bucket.get(this.elements[this.size-1]);
	}

	/**
	 *
	 * OVERVIEW: Returns the string equivalent of the array
	 * @return String the string representation of the object it's being called upon
	 * 
	 */
	@Override
	public String toString() {
		String newString = "{";
		for (int i = 0; i < this.elements.length; i++) {
			
			newString += "\"";
			newString += bucket.get(this.elements[i]);
			newString += "\"";
			newString += ",";
		}

		return newString + "}";
	}
}