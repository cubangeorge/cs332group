/**
 * @author G 01066284 Valeria L Green (VG)
 * @author G 00402127 Jorge L Martinez (JM) 
 * @author G 01082586 Blake Khan (BK)
 */

import java.util.Collection;
import java.util.Iterator;

// Re-usable wrapper uses composition instead of inheritance 
// Note power of the implemented interface
public class ForwardingCollection<E> implements Collection<E> {

	// Fields --------------------------------------------------
	
	private final Collection<E> s;
	
	// Constructors ----------------------------------------------

	public ForwardingCollection(Collection<E> s) {
		this.s = s;
	}
	
	// Methods ------------------------------------------------------

   /**
    * Adds a new object to the collection with a super call
    *
    * @param E The object to add
    * @return boolean Returns whether the addition was successful
    */
	@Override
	public boolean add(E e) {
		return s.add(e);
	}

   /**
    * Removes an object to the collection with a super call
    *
    * @param Object The object to remove
    * @return boolean Returns whether the removal was successful
    */
	@Override
	public boolean remove(Object o) {
		return s.remove(o);
	}

   /**
    * Compares an object to see if the two objects are equal
    *
    * @param Object The object to compare
    * @return boolean Returns whether the objects are equal
    */
	@Override
	public boolean equals(Object o) {
		return s.equals(o);
	}

   /**
    * Returns the hash code computed
    *
    * @return Int The hashcode computed
    * 
    */
	@Override
	public int hashCode() {
		return s.hashCode();
	}

   /**
    * Returns the string representation
    *
    * @return String The string version of the collection
    * 
    */
	@Override
	public String toString() {
		return s.toString();
	}

   /**
    * Returns the size of the collection
    *
    * @return Int The size of the collection
    * 
    */
	@Override
	public int size() {
		return s.size();
	}

  /**
    * Returns whether or not the collection is empty
    *
    * @return Boolean Whether or not the collection is empty
    * 
    */
	@Override
	public boolean isEmpty() {
		return s.isEmpty();
	}

  /**
    * Returns whether or not the collection contains the input object
    *
    * @return Boolean Whether or not the input object is in the collection
    * 
    */
	@Override
	public boolean contains(Object o) {
		return s.contains(o);
	}

	/**
    * An iterator for the collection
    *
    * @return Iterator<E> The iterator for the collection
    * 
    */
	@Override
	public Iterator<E> iterator() {
		return s.iterator();
	}

	/**
    * Returns a null
    *
    * @return Object[] The converted as a null
    * 
    */
	@Override
	public Object[] toArray() {
		return null;
	}

	/**
    * Returns a null
    *
    * @param T[] The input array
    * @return <T> T[] The converted as a null
    * 
    */
	@Override
	public <T> T[] toArray(T[] a) {
		return null;
	}

	/**
    * Returns whether or not the input collection is in the main collection
    *
    * @param Collection<?> The input collection to compare
    * @return boolean Whether or not the input collection is found inside the current
    * 
    */
	@Override
	public boolean containsAll(Collection<?> c) {
		return s.contains(c);
	}

	/**
    * Adds all of the input collection into the main collection
    *
    * @param Collection<?> The input collection to add
    * @return boolean Whether or not the addition operation was successful
    * 
    */
	@Override
	public boolean addAll(Collection<? extends E> c) {
		return s.addAll(c);
	}

	/**
	* 
    * Retains only the elements in this collection if they match up with the specified collection
    *
    * @param Collection<?> The input collection to check
    * @return boolean Whether or not the input collection is retained
    * 
    */
	@Override
	public boolean retainAll(Collection<?> c) {
		return s.retainAll(c);
	}

	/**
	* 
    * Removes all matching items in the collection matched between both
    *
    * @param Collection<?> The input collection to check to remove with
    * @return boolean Whether or not the operation was successful
    * 
    */
	@Override
	public boolean removeAll(Collection<?> c) {
		return s.removeAll(c);
	}

	/**
	* 
    * Removes all items from the collection
    *
    */
	@Override
	public void clear() {
		s.clear();
	}

}