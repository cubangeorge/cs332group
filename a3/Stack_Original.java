//import java.util.*;
public class Stack_Original {
	/**
	  * Variant of Bloch's Stack example page 60, 3rd edition
	  * Used in SWE/CS 332 to discuss mutability and AF/RI
	  */

	

	//public class Stack {

	   private Object[] elements;
	   private int size = 0;


	   public Stack_Original() {
	     this.elements = new Object[0];
	   }

	   public void push (Object e) {
	     ensureCapacity();
	     elements[size++] = e;
	   }

	   public Object pop () {
	     if (size == 0) throw new IllegalStateException("Stack.pop");
	     Object result = elements[--size];
	     elements[size] = null;
	     return result;
	   }

	   private void ensureCapacity() {
	      if (elements.length == size) {
	         Object oldElements[] = elements;
	         elements = new Object[2*size + 1];
	         System.arraycopy(oldElements, 0, elements, 0, size);
	      }
	   }

	//}
}
