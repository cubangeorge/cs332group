import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 * @author jorge
 *
 */
class IntSetFixedTest {
	
	/**
	 * Test method for {@link IntSetFixed#equals(java.lang.Object)}.
	 */
	@Test
	void testEqualsObject() {
		//compare it with another instance 
		//of the same class
		IntSetFixed il1 = new IntSetFixed();
		IntSetFixed il2 = new IntSetFixed();
		assertTrue(il1.equals(il2)); //tests happy path equal empty lists

		il1.add(5);
		il1.add(6);
		il1.add(7);
		il1.add(8);
		assertFalse(il1.equals(il2)); //tests happy path not equal
		
		il2.add(5);
		il2.add(6);
		il2.add(7);
		il2.add(8);
		
		assertTrue(il1.equals(il2)); //tests happy path equal
		il2.add(9);
		assertFalse(il1.equals(il2)); //tests happy path not equal
		
		//now make comparisons with subclassed objects
		
		
	}

	/**
	 * Test method for {@link IntSetFixed#add(java.lang.Object)}.
	 */
	@Test
	void testIntSet_addTest() {
		
		IntSetFixed il1 = new IntSetFixed();
		assertEquals("[]", il1.toString());//tests empty list
		//add a few elements
		il1.add(5);
		il1.add(6);
		il1.add(7);
		il1.add(8);
		
		assertEquals("[5, 6, 7, 8]",il1.toString());//test happy path
		il1.add(8);
		assertEquals("[5, 6, 7, 8]",il1.toString());//test no duplicates
		
	}

	/**
	 * Test method for {@link IntSetFixed#clone()}.
	 */
	@Test
	void testCloneSameClass() {
		IntSetFixed original = new IntSetFixed();
		int size = 10;
		for (int i = 0; i < size; i++) {
			original.add(i);
		}
		
		try {
			
			IntSetFixed clone = original.clone();
			assertTrue(clone.equals(original)); //test happy path equal 
			original.set(0,24);
			System.out.println("clone list:"+clone);
			System.out.println("origi list:"+original);
			assertFalse(clone.equals(original)); //test happy path not equal
			clone.set(0, 4);//add a duplicate 
			assertFalse(clone.equals(original)); //test happy path not equal again
			System.out.println("clone list:"+clone);
			System.out.println("origi list:"+original);
			clone.set(0, 24); // make the clone look like the original again
			assertTrue(clone.equals(original)); //test happy path equal 
			System.out.println("clone list:"+clone);
			System.out.println("origi list:"+original);

			
		} catch(CloneNotSupportedException e) {
			System.err.println("error " + e);
			fail("unexpected exception didn't happen");
		}
		
		
		
	}

}
