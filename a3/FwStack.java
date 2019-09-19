import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;

/**
 * 
 */

/**
 * @author jorge
 *
 */
public class FwStack {

	private final int[] elements; // Stores the hashcodes. Used as keys in the bucket cache.
	private int size;
	private static final HashMap<Integer, Object> bucket = new HashMap<>();
	
	public int getSize() {
		return size;
	}
	
	public static int getMapsize() {
		return bucket.size();
	}
	
	public FwStack() {
		this(0);
	}
	
	private FwStack(int e) {//called by push and last only
		elements = new int[e];
		size = e;
	}

	public FwStack push(Object o){//went from mutator to producer
		FwStack newStack = new FwStack(size+1);//make new bigger stack
		return populate(o, newStack, size); //return new immutable stack
	}

	/**
	 * Copies over the current stack to the provided new stack, and appends the provided object.
	 * @param e the object to append to the new stack
	 * @param newStack the new stack
	 * @param size the size of the new stack
	 */
	private FwStack populate(Object e, FwStack newStack, int size) {
		// Copy over current array
		System.arraycopy(elements, 0, newStack.elements, 0, elements.length);

		// Append hashcode to new stack & cache in map
		int hash = Objects.hashCode(e);
		bucket.putIfAbsent(hash, e);
		newStack.elements[size] = hash;
		return newStack;
	}

	public FwStack pop() { // went from mutator to producer
		if (size == 0) {throw new IllegalStateException("The Stack is Empty ");}
		FwStack newStack = new FwStack(size-1);
		System.arraycopy(elements, 0, newStack.elements, 0, size	-1);
		return newStack;
	}	
	/**
	 * 
	 * @return
	 */
	public Object last() {//went from mutator to observer
		if (size == 0) {throw new IllegalStateException("The Stack is Empty ");}
		return bucket.get(this.elements[this.size-1]);
	}

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
