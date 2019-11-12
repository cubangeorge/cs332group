import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

// Re-usable wrapper uses composition instead of inheritance 
// Note power of the implemented interface
public class ForwardingList<E> implements List<E> {

	private final List<E> s;

	public ForwardingList(List<E> s) {
		this.s = s;
	}

	@Override
	public boolean add(E e) {
		return s.add(e);
	}

	@Override
	public boolean remove(Object o) {
		return s.remove(o);
	}

	@Override
	public boolean equals(Object o) {
		return s.equals(o);
	}

	@Override
	public int hashCode() {
		return s.hashCode();
	}

	@Override
	public String toString() {
		return s.toString();
	}

	@Override
	public int size() {
		return s.size();
	}

	@Override
	public boolean isEmpty() {
		return s.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return s.contains(o);
	}

	@Override
	public Iterator<E> iterator() {
		return s.iterator();
	}

	@Override
	public Object[] toArray() {
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return null;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return s.contains(c);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		return s.addAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return s.retainAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return s.removeAll(c);
	}

	@Override
	public void clear() {
		s.clear();
	}

	//added methods from here down 
	@Override
	public E get(int index) {
		return s.get(index);
	}

	@Override
	public E set(int index, E element) {
		E r = s.get(index);
		s.set(index, element);
		return r;
	}

	@Override
	public void add(int index, E element) {
		s.add(index, element);
	}

	@Override
	public E remove(int index) {
		return s.remove(index);
	}

	@Override
	public int indexOf(Object o) {
		return s.indexOf(o);
	}

	@Override
	public int lastIndexOf(Object o) {
		return s.lastIndexOf(o);
	}

	@Override
	public ListIterator<E> listIterator() {
		return s.listIterator();
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		return s.listIterator(index);
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		return s.subList(fromIndex, toIndex);
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		return s.addAll(c);
	}
}