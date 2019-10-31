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
		Point2 p = new Point2(0,0);
		Point3 q = new Point3(0,0);

		//tests symmetry
		assertTrue(p.equals(q));
		assertTrue(q.equals(p));
		//tests symmetry with different points 
		p = new Point2(1,2);
		q = new Point3(0,0);
		assertFalse(p.equals(q));
		assertFalse(q.equals(p));
	}
	@Test
	void test_Transitivity() {
		Point2 p = new Point2(0,0);
		Point3 q = new Point3(0,0);
		Point3 z = new Point3(0,0);
		//test transitivity		
		assertTrue(p.equals(q));
		assertTrue(q.equals(z));
		assertTrue(p.equals(z));
	}
	

	
	@Test
	void test_LSP() {
		Point2 point2 = new Point2(0,0);
		Point3 point3 = new Point3(0,0);
		
		//test LSP	
		
		//point3 is a Point2 object because Point 3 object derives from Point 2
		assertTrue(point3 instanceof Point2);
		
		//point2 is not a Point3 object because Point 2 is the superclass of Point 3
		assertFalse(point2 instanceof Point3);
		
		//Conclusion: Point 3 is a Point 2 but a Point 2 isn't a Point 3.
	}
}
