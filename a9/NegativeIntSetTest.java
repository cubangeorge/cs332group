import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author jorge
 *
 */
class NegativeIntSetTest {
	
	/**
	 * Test method for {@link NegativeIntSet#equals(java.lang.Object)}.
	 */
	@Test
	void test_NIS_equals() {
		//compare it with another instance 
		//of the same class
		NegativeIntSet il1 = new NegativeIntSet();
		NegativeIntSet il2 = new NegativeIntSet();
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
	 * Test method for {@link NegativeIntSet#add(java.lang.Object)}.
	 */
	@Test
	void test_NIS_add() {
		
		NegativeIntSet il1 = new NegativeIntSet();
		assertEquals("[]", il1.toString());//tests empty list
		//add a few elements
		il1.add(5);
		il1.add(6);
		il1.add(7);
		il1.add(8);
		
		assertEquals("[-5, -6, -7, -8]",il1.toString());//test happy path
		il1.add(8);
		assertEquals("[-5, -6, -7, -8]",il1.toString());//test no duplicates
		
	}

	/**
	 * Test method for {@link NegativeIntSet#clone()}.
	 */
	@Test
	void test_NIS_clone() {
		NegativeIntSet original = new NegativeIntSet();
		int size = 10;
		for (int i = 0; i < size; i++) {
			original.add(i);
		}
		
		try {
			
			System.out.println("origi list:"+original);
			NegativeIntSet clone = (NegativeIntSet) original.clone();
			System.out.println("clone list:"+clone);
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
