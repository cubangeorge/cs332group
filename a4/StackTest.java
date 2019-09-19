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
 * @author Jorge, Valeria, Blake   
 *
 */
class StackTest {

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
	void setUp() throws Exception {}	

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		
	}

	/**
	 * Test method for {@link java.lang.Object#toString()}.
	 */
	@Test
	void test_ints() {
		Stack s = new Stack();
//		s.push("cat");
//		s.push("dog");
//		s.push("bat");
//		s.push( new Object());
//		s.push( new Object());
//		s.push( new Object());
		s.push(1);
		s.push(2);
		s.push(3);
		
		assertArrayEquals("{top|1||2||3|bottom}\n",s.toString());
		
	}

}
