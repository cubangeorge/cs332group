import java.util.*;

/**
 * Consider the GrowList.java code from the in-class exercises. 
 * Let's suppose we drop the "grow" constraint, 
 * and allow the list to both grow and shrink.
 * To do this:
 * 1- add a method remove() to the API. 
 * 2- Provide a contract for remove().
 * 3- Do not change 
 * 			3.1-the representation, 
 * 			3.2-the abstraction function,
 * 			3.3-the representation invariant.
 * 4- Again, the deliverable is a story. 
 * 		- DISCUSS in Story:  
 * 			4.1- why you implemented remove() the way you did. 
 * 			4.2- address the efficiency consequences of your implementation.
 */

//GrowList is a mutable list that only gets longer.
/**
 * 
 *  @author G 01066284 Valeria L Green (VG)
 *	@author G 00402127 Jorge L Martinez (JM) 
 *	@author G 01082586 Blake Khan (BK)jorge
 *  @param <E>
 */

public class GrowList <E> {

	private Map<Integer,E> values;

	public GrowList() { values = new HashMap<Integer,E>();}

	// add to the end of the list
	public void add(E o) {
		values.put(size(), o);
	}


	/**
	 * OVERVIEW: Removes an element based on index
	 * STORY:
	 *  
	 * 	Removing an object by index was chosen since it can easily satisfy its contract of 
	 * removing an object at the specified location or throwing an IOBE. It is also more efficient since 
	 * there is no traversal or comparison necessary for a successful removal.
	 * 
	 * @
	 * @param i the index at which an element needs to be removed
	 * @return E the element that was removed
	 * @throws indexOutOfBoundsException when index is not in range. 
	 */

	public E remove(int i) {
		return values.remove(i); 
	}

	/**
	 * OVERVIEW: Removes an element based on user provided index, does a 1 place left shift 
	 * for all subsequent elements and then removes the last element
	 * 
	 * STORY:
	 *  
	 * 	Removing an object by index was chosen since it can easily satisfy its contract of 
	 * removing an object at the specified location or throwing an IOBE. It is also more efficient since 
	 * there is no traversal or comparison necessary for a successful removal.
	 * 
	 * @
	 * @param i the index at which an element needs to be removed
	 * @return E the element that was removed
	 * @throws indexOutOfBoundsException when index is not in range. 
	 */
	public E remove_jorge(int i) throws IndexOutOfBoundsException{
		if (! inRange(i)) throw new IndexOutOfBoundsException("GrowList.remove");
		//store return value
		E temp = values.get(i);
		//do the shifting
		while (i < size()) { //this loop will copy following objects to the previous index
			values.put(i,values.get(i+1));
			i++;
		}
		//now remove last element
		values.remove(size()-1);
		return temp;
	}
	  /**
	  * OVERVIEW: Removes instances of an element in the hash map
	  * STORY: This was implemented the way it was because it's more thorough to go and inspect each element of a hash map to see if it contains the specified object
	  * 
	  * @param E the object to be removed
	  */
	  public void removeObjects(E toRemove) {
		  for (int i = 0; i < values.size(); i++) {
			  if (values.get(i) == toRemove) {
				  if (values.get(i).equals(toRemove)) {
					  values.remove(i);
				  }
			  }
		  }	
	  }

	// number of values in list
	public int size() { return values.size(); }

	// get ith value in list
	public E get(int i) { 
		if (! inRange(i)) throw new IndexOutOfBoundsException("GrowList.get");
		return values.get(i);
	}

	// update ith value in list;  return previous value 
	public E set(int i, E o) {
		if (! inRange(i)) throw new IndexOutOfBoundsException("GrowList.set");
		return values.put(i, o);
	}

	// private helper method
	private boolean inRange(int i) { return (i >= 0) && (i < size()); }

	public String toString() {
		if (size() == 0) return "[]";
		String result = "[";
		for (int i = 0; i < size()-1; i++) {
			result += values.get(i) + ",";
		}
		return result + values.get(size() - 1) + "]";
	}

	public static void main(String[] args) {
		GrowList<String> list = new GrowList<String>();

		System.out.println("list is:" + list);
		list.add("cat");
		System.out.println("list is:" + list);
		list.add("dog");
		System.out.println("list is:" + list);
		list.set(1,"bat");
		System.out.println("list is:" + list);

	}

}
