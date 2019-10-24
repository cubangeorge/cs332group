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
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

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
	 * Test method for {@link IntSetFixed#IntSetFixed()}.
	 */
	@Test
	void testIntSetFixed() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link IntSetFixed#equals(java.lang.Object)}.
	 */
	@Test
	void testEqualsObject() {

		IntSetFixed il1 = new IntSetFixed();
		il1.add(5);
		il1.add(6);
		il1.add(7);
		il1.add(8);
		
		System.out.println(il1);
		
	}

	/**
	 * Test method for {@link IntSetFixed#add(java.lang.Object)}.
	 */
	@Test
	void testIntSetadd() {
		
		IntSetFixed il1 = new IntSetFixed();
		il1.add(5);
		il1.add(6);
		il1.add(7);
		il1.add(8);
		
		assertEquals("[5, 6, 7, 8]",il1.toString());
		
	}

	/**
	 * Test method for {@link IntSetFixed#clone()}.
	 */
	@Test
	void testClone() {
		IntSetFixed toClone = new IntSetFixed();
		for (int i = 0; i < 10; i++) {
			toClone.add(i);
		}

		
		
		fail("Not yet implemented"); // TODO
	}

}
