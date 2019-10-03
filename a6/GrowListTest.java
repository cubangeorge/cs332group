import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
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

	

	/**
	 * Test method for {@link GrowList#GrowList()}.
	 */
	@Test
	void testGrowList() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link GrowList#add(java.lang.Object)}.
	 */
	@Test
	void testAdd() {
		fail("Not yet implemented"); // TODO
	}
	
	/**
	 * Test method for {@link GrowList#add(java.lang.Object)}.
	 * @param <E>
	 */
	@Test
	<E> void testremove() {
		
		GrowList <E> gl = new GrowList<E>();
		gl.add( (E) "something");
		gl.add( (E) new Integer(9));
		gl.add( (E) new Character ('c'));
		
		assertEquals('c',((char)gl.remove()));
		assertEquals(9,((int)gl.remove()));
		assertTrue("something".equals((String)gl.remove()));
	}
	
	

	/**
	 * Test method for {@link GrowList#size()}.
	 */
	@Test
	void testSize() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link GrowList#get(int)}.
	 */
	@Test
	void testGet() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link GrowList#set(int, java.lang.Object)}.
	 */
	@Test
	void testSet() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link GrowList#toString()}.
	 */
	@Test
	void testToString() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link GrowList#main(java.lang.String[])}.
	 */
	@Test
	void testMain() {
		fail("Not yet implemented"); // TODO
	}
	
	
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
		
		
		try {
			gl.get(2);
			fail("expected exception didn't happen");
		} catch(IndexOutOfBoundsException e) {
			System.err.println("error " + e);
		}
		assertEquals(2, gl.size());
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
		
		gl.removeObjects((E) "something");
		
		for (int i = 0; i < gl.size(); i++) {
			if (gl.get(i) == (E) "something") {
				fail("Still in the hash map.");
			}
		}
		
		
		
	}

}
