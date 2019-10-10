import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 *  @author G 01066284 Valeria L Green (VG)
 *	@author G 00402127 Jorge L Martinez (JM) 
 *	@author G 01082586 Blake Khan (BK)
 */
class GrowListTest {
		
	/**
	 * Test method for {@link GrowList#remove}.
	 * this tests checks the remove method 
	 * its effect and its exception throwing capabilities 
	 * when its argument is out of bounds. 
	 */
	@SuppressWarnings("unchecked")
	@Test
	<E> void test_remove() {

		GrowList <E> gl = new GrowList<E>();
		gl.add((E) "one");
		gl.add((E) "two");
		gl.add((E) "three");
		//[one, two , three]
		assertEquals(3, gl.size());
		//check each index content
		assertEquals("one", gl.get(0));
		assertEquals("two", gl.get(1));
		assertEquals("three", gl.get(2));
		//now remove first element
		assertEquals("one" , gl.remove(0));
		//now try and get the last item
		assertEquals("three", gl.get(1));
		//check that the size has decrease
		assertEquals(2, gl.size());
		//double check using toString
		assertEquals("[two,three]", gl.toString());
		//now add a new element 
		gl.add((E) Integer.valueOf(4));
		//check the list
		assertEquals("[two,three,4]", gl.toString());
		//remove last element again 
		gl.remove(2);
		assertEquals("[two,three]", gl.toString());
		//add a null
		gl.add(null);
		//check the list 
		assertEquals("[two,three,null]", gl.toString());
		assertEquals(3, gl.size());
		//remove the middle element
		assertEquals("three" , gl.remove(1));
		//check the list 
		assertEquals("[two,null]", gl.toString());
		assertEquals(2, gl.size());
		//remove all elements
		gl.remove(0);
		gl.remove(0);
		assertEquals("[]", gl.toString());
		assertEquals(0, gl.size());
		//test exception 
		//trying to remove from an empty list
		Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> gl.remove(0));
	    assertEquals("GrowList.remove", exception.getMessage());
	}
	
	
	/**
	 * Test method for {@link GrowList#removeObjects}.
	 */
	@SuppressWarnings({ "unchecked"})
	@Test
	<E> void test_removeObjects() {
		
		GrowList <E> gl = new GrowList<E>();
		gl.add( (E) "something");
		gl.add( (E) Integer.valueOf(9));
		gl.add( (E) Integer.valueOf(9001));
		gl.add( (E) "something");
		gl.add( (E) "Brooklyn 99");
		gl.add( (E)"something");
		gl.add( (E)"something");
		
		System.out.println(gl.toString());
		gl.removeObjects((E) "something");
		for (int i = 0; i < gl.size(); i++) {
			if (gl.get(i) == (E) "something") {
				fail("Still in the hash map.");
			}
		}
		System.out.println(gl.toString());
		assertEquals("[9,9001,Brookling 99]", gl.toString());
		assertEquals(4, gl.size());
		
	}

}
