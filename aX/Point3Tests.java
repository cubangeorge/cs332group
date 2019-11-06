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
		System.out.println("=======================");
		System.out.println("----testing Symmetry------");
		System.out.println("Created Point p:"+p);
		System.out.println("Created Point q:"+q);

		//tests symmetry
		assertEquals(p, q);
		assertEquals(q, p);
		System.out.println("testing p.equals(q):"+p.equals(q));
		System.out.println("testing q.equals(p):"+q.equals(p));
		System.out.println("Symmetry test:"+(p.equals(q)&&q.equals(p)));

		//modify to make not equal
		p = new Point2(0,0);
		System.out.println("modified p to"+p);

		// test for symmetry now (shouldn't be!)
		assertNotEquals(p, q);
		assertNotEquals(q, p);
		System.out.println("p is now"+p);
		System.out.println("q is now"+q);
		System.out.println("testing p.equals(q):"+p.equals(q));
		System.out.println("testing q.equals(p):"+q.equals(p));
		System.out.println("Symmetry test:"+(!p.equals(q)&&!q.equals(p)));

	}
	@Test
	void test_Transitivity() {
		// create points
		Point3 p = new Point3(1,2, 3);
		Point2 q = new Point2(1,2);
		Point3 z = new Point3(1,2, 5);

		System.out.println("======================");
		System.out.println("testing transtivity");
		System.out.println("Created Point p:"+p);
		System.out.println("Created Point q:"+q);
		System.out.println("Created Point z:"+z);

		System.out.println("testing p.equals(q):"+p.equals(q));
		System.out.println("testing q.equals(z):"+q.equals(z));
		System.out.println("Transitivity test p.equals(z):"+p.equals(z));

		//test transitivity		
		assertEquals(p, q);
		assertEquals(q, z);
		assertEquals(p, z); // This is what causes transitivity to fail!
	}

}
