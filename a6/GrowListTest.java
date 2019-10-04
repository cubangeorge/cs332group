import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 *  @author G 01066284 Valeria L Green (VG)
 *	@author G 00402127 Jorge L Martinez (JM) 
 *	@author G 01082586 Blake Khan (BK)jorge
 */
class GrowListTest {

	

	
//	/**
//	 * Test method for {@link GrowList#add(java.lang.Object)}.
//	 * @param <E>
//	 */
//	@Test
//	<E> void testremove() {
//		
//		GrowList <E> gl = new GrowList<E>();
//		gl.add( (E) "something");
//		gl.add( (E) new Integer(9));
//		gl.add( (E) new Character ('c'));
//		
//		assertEquals('c',((char)gl.remove()));
//		assertEquals(9,((int)gl.remove()));
//		assertTrue("something".equals((String)gl.remove()));
//	}
	
			
	/**
	 * Test method for {@link GrowList#removeByIndex}.
	 */
	@Test
	<E> void test_removeByIndex() {
		GrowList <E> gl = new GrowList<E>();
		gl.add( (E) "something");
		gl.add( (E) new Integer(9));
		gl.add( (E) new Character ('c'));
		gl.removeByIndex(2);
		
		assertTrue("[something,9]".equals(gl.toString()));
		assertEquals(2, gl.size());
		try {
			gl.get(2);
			System.err.println("error expected exception didn't happen" );
			fail("expected exception didn't happen");
		} catch(IndexOutOfBoundsException e) {
			System.out.println("remove test succesful: " + e);
		}
		assertEquals(2, gl.size());
	}
	
	
//	/**
//	 * Test method for {@link GrowList#removeObjects}.
//	 */
//	@Test
//	<E> void test_removeObjects() {
//		GrowList <E> gl = new GrowList<E>();
//		gl.add( (E) "something");
//		gl.add( (E) new Integer(9));
//		gl.add( (E) new Integer(9001));
//		gl.add( (E) "something");
//		gl.add( (E) "Brooklyn 99");
//		gl.add((E)"something");
//		gl.add((E)"something");
//		
//		System.out.println(gl.toString());
//		gl.removeObjects((E) "something");
//		for (int i = 0; i < gl.size(); i++) {
//			if (gl.get(i) == (E) "something") {
//				fail("Still in the hash map.");
//			}
//		}
//		
//	}

}
