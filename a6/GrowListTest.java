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
	@Test
	<E> void test_remove() {
//		GrowList <E> gl = new GrowList<E>();
//		gl.add( (E) "something");
//		gl.add( (E) new Integer(9));
//		gl.add( (E) new Character ('c'));
//		gl.remove(2);
//		
//		assertEquals("[something,9]",gl.toString() );
//		assertEquals(2, gl.size());
//		try {
//			gl.get(2);
//			System.err.println("error expected exception didn't happen" );
//			fail("expected exception didn't happen");
//		} catch(IndexOutOfBoundsException e) {
//			System.out.println("success: @test remove() passed " + e);
//		}
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
		gl.add((E) new Integer(4));
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
	@Test
	<E> void test_removeObjects() {
		GrowList <E> gl = new GrowList<E>();
		gl.add( (E) "something");
		gl.add( (E) new Integer(9));
		gl.add( (E) new Integer(9001));
		gl.add( (E) "something");
		gl.add( (E) "Brooklyn 99");
		gl.add( (E)"something");
		gl.add( (E)"something");
		
		System.out.println(gl.toString());
		gl.removeObjects((E) "something");
		for (int i = 0; i < gl.size(); i++) {
			try {
				if (gl.get(i).equals((E) "something")) {
					fail("Still in the hash map.");
				}
			} catch (NullPointerException e) {
				System.err.println("error " + e);
			}
		}
		System.out.println(gl.toString());
		assertEquals("[null,9,9001,null,Brooklyn 99]", gl.toString());
		assertEquals(5, gl.size());
		
	}

}
