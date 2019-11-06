import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author G 01066284 Valeria L Green (VG)
 * @author G 00402127 Jorge L Martinez (JM) 
 * @author G 01082586 Blake Khan (BK)
 */
class Point3Tests {

	/**
	 * Test method for {@link Point3#equals(Point3)}.
	 */
	@Test
	void test_Symmetry() {
		// create equal points
		Point2 p = new Point2(1,2);
		Point3 q = new Point3(1,2, 3);

		//tests symmetry
		assertEquals(p, q);
		assertEquals(q, p);

		//modify to make not equal
		p = new Point2(0,0);

		// test for symmetry now (shouldn't be!)
		assertNotEquals(p, q);
		assertNotEquals(q, p);
	}
	
	/**
	 * Test method for {@link Point3#equals(Point3)}.
	 * Test method for {@link Point2#equals(Object)}.
	 * 
	 * This tests transitivity which is broken due to the logical fallacy. 
	 * Even if p and q are equal doesn't mean that p and z are equal
	 * 
	 */
	@Test
	void test_Transitivity() {
		// create points
		Point3 p = new Point3(1,2, 3);
		Point2 q = new Point2(1,2);
		Point3 z = new Point3(1,2, 5);

		//test transitivity		
		assertEquals(p, q);
		assertEquals(q, z);
		assertEquals(p, z); // This is what causes transitivity to fail!
	}
}
