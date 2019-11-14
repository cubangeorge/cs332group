
/**
 * @author G 01066284 Valeria L Green (VG)
 * @author G 00402127 Jorge L Martinez (JM) 
 * @author G 01082586 Blake Khan (BK)
 */

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

// Re-usable wrapper uses composition instead of inheritance 
// Note power of the implemented interface
public class ForwardingList<E> implements List<E> {

	// Fields --------------------------------------------------
	
	private final List<E> s;

	// Constructors ----------------------------------------------
	
	public ForwardingList(List<E> s) {
		this.s = s;
	}
	
	// Methods ------------------------------------------------------

   /**
    * Adds a new object to the list with a super call
    *
    * @param E The object to add
    * @return boolean Returns whether the addition was successful
    */
	@Override
	public boolean add(E e) {
		return s.add(e);
	}

  /**
    * Removes an object from the list with a super call
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
    * @return String The string version of the list
    * 
    */
	@Override
	public String toString() {
		return s.toString();
	}

  /**
    * Returns the size of the list
    *
    * @return Int The size of the list
    * 
    */
	@Override
	public int size() {
		return s.size();
	}

  /**
    * Returns whether or not the list is empty
    *
    * @return Boolean Whether or not the list is empty
    * 
    */
	@Override
	public boolean isEmpty() {
		return s.isEmpty();
	}

  /**
    * Returns whether or not the list contains the input object
    *
    * @return Boolean Whether or not the input object is in the list
    * 
    */
	@Override
	public boolean contains(Object o) {
		return s.contains(o);
	}

  /**
    * An iterator for the list
    *
    * @return Iterator<E> The iterator for the list
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
    * Returns whether or not the input collection is in the main list
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
    * Adds all of the input collection into the main list
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
    * Retains only the elements in this list if they match up with the specified collection
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
    * Removes all items from the list
    *
    */
	@Override
	public void clear() {
		s.clear();
	}

	//added methods from here down 
	
	/**
	* 
    * Gets the value/object that was found at that index
    *
    * @param int The index to find an object at
    * @return E The found object at the specified index
    * 
    */
	@Override
	public E get(int index) {
		return s.get(index);
	}
	
	/**
	* 
    * Replaces the value/object at the specified index
    *
    * @param int The index to replace an object at
    * @param E The object to replace at the specified index
    * @return E The replaced object at the specified index
    * 
    */
	@Override
	public E set(int index, E element) {
		E r = s.get(index);
		s.set(index, element);
		return r;
	}

	/**
	* 
    * Adds a value/object at the specified index
    *
    * @param int The index to add an object at
    * @param E The object to add at the specified index
    * 
    */
	@Override
	public void add(int index, E element) {
		s.add(index, element);
	}
	/**
	* 
    * Removes the value/object at the specified index
    *
    * @param int The index to remove an object from
    * @param E The object removed at the specified index
    * 
    */
	@Override
	public E remove(int index) {
		return s.remove(index);
	}

	/**
	* 
    * First index found of the input object
    *
    * @param Object The object to find
    * @return int The index the object was found at
    * 
    */
	@Override
	public int indexOf(Object o) {
		return s.indexOf(o);
	}

  /**
	* 
    * Last index found of the input object
    *
    * @param Object The object to find
    * @return int The last index the object was found at
    * 
    */
	@Override
	public int lastIndexOf(Object o) {
		return s.lastIndexOf(o);
	}

  /**
	* 
    * Returns a list iterator
    *
    * @return ListIterator<E> The list iterator
    * 
    */
	@Override
	public ListIterator<E> listIterator() {
		return s.listIterator();
	}

  /**
	* 
    * Returns a list iterator at the specified index
    *
    * @return ListIterator<E> The list iterator
    * 
    */
	@Override
	public ListIterator<E> listIterator(int index) {
		return s.listIterator(index);
	}

  /**
	* 
    * Returns a subset of the overall list between the two indexes
    *
    * @param int The starting index to extract the list from
    * @param int The ending index to extract the list from
    * @return List<E> The subset list
    * 
    */
	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		return s.subList(fromIndex, toIndex);
	}

  /**
	* 
    * Adds all from the collection at the specified index
    *
    * @param int The index to add the collection at
    * @param Collection<? extends E> The collection to add
    * @return boolean Whether or not the operation was successful
    * 
    */
	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		return s.addAll(c);
	}
}