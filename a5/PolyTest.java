import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

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
class PolyTest {

	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link Poly#Poly()}.
	 */
	@Test
	void testPoly() {
		Poly p = new Poly();
		
		assertTrue((p.getCoefAtIndex(0)==0 && p.degree() == 0));
	}

	/**
	 * Test method for {@link Poly#Poly(int, int)}.
	 * 
	 */
	@Test
	void testPolyIntInt() {
		int c = 1;int d = 3;
		Poly p = new Poly(c,d);
		for (int i=0 ; i<p.degree(); i++) {
			
			if(i == d && p.getCoefAtIndex(i) == c) {
				//checked that coef and degree matched
				continue;
			}
			else {
				if (p.getCoefAtIndex(i)==0) {
					//every other field should be zero in the array
					continue;
				}
				else fail("trms not properly initialized");
			}
		}
		//if it didnt fail at this point Poly is good

	}
	
	/**
	 * Test method for {@link Poly#degree()}.
	 */
	@Test
	void testDegree() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link Poly#add(Poly)}.
	 */
	@Test
	void testAdd() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link Poly#toString()}.
	 */
	@Test
	void testToString() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link Poly#repOk()}.
	 */
	@Test
	void testRepOk_weakAdd() {
		// TODO: Check over this
		
		Poly p = new Poly(3, 5);
		Poly c = new Poly(-3, 5);
		Poly d = p.weakAdd(c);
		System.out.println(p.toString() + " + " + c.toString() + " = " + d.toString()  + " || ");
		assertFalse(d.repOk());
	}
	@Test
	void test_weakAdd() {
		
		Poly p = new Poly(3, 5);
		Poly c = new Poly(-3, 5);
		Poly d = p.weakAdd(c);
		System.out.println(p.toString() + " + " + c.toString() + " = " + d.toString()  + " || ");
		assertFalse(d.repOk());
	}

	/**
	 * Test method for {@link Poly#repOk()}.
	 */
	@Test
	void testRepOk_regAdd() {
		// TODO: Check over this
		
		Poly p = new Poly(3, 5);
		Poly c = new Poly(-3, 5);
		Poly d = p.add(c);
		System.out.println(p.toString() + " + " + c.toString() + " = " + d.toString()  + " || ");
		assertFalse(d.repOk());
	}

	/**
	 * Test method for {@link Poly#weakRepOk()}.
	 */
	@Test
	void testWeakRepOk_weakAdd() {
		// TODO: Check over this
		Poly p = new Poly(3, 5);
		Poly c = new Poly(-3, 5);
		Poly d = p.weakAdd(c);
		System.out.println(p.toString() + " + " + c.toString() + " = " + d.toString() + " || ");
		assertTrue(d.weakRepOk());
		
	}
	
	/**
	 * Test method for {@link Poly#weakRepOk()}.
	 */
	@Test
	void testWeakRepOk_regAdd() {
		// TODO: Check over this
		Poly p = new Poly(3, 5);
		Poly c = new Poly(-3, 5);
		Poly d = p.add(c);
		System.out.println(p.toString() + " + " + c.toString() + " = " + d.toString() + " || ");
		assertTrue(d.weakRepOk());
		
	}

}
