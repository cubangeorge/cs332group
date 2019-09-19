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
	void test_nums() {
		Stack s = new Stack();
		s.push(1);
		s.push(new Integer (2));
		s.push(3);
		s.push(-3);
		s.push(-3.4);
		s.push(0.567);
		
		assertTrue("{bottom| 1 || 2 || 3 || -3 || -3.4 || 0.567 |top}".equals(s.toString()));
		
	}
	@Test
	void test_empty_stack() {
		Stack s = new Stack();
		assertTrue("{}".equals(s.toString()));
		
	}
	@Test
	void test_chars() {
		Stack s = new Stack();
		s.push(new Character ('a'));
		s.push('b');
		s.push('c');
		
		assertTrue("{bottom| 'a' || 'b' || 'c' |top}".equals(s.toString()));
		
	}
	@Test
	void test_Strings() {
		Stack s = new Stack();
		s.push("cat");
		s.push("dog");
		s.push("bat");
		
		assertTrue("{bottom| \"cat\" || \"dog\" || \"bat\" |top}".equals(s.toString()));
		
	}
	@Test
	void test_Objects() {
		Stack s = new Stack();
		s.push( new Object());
		s.push( new Object());
		s.push( new Object());
		assertTrue("{bottom| Obj_1 || Obj_2 || Obj_3 |top}".equals(s.toString()));
		
	}
	@Test
	void test_mix() {
		Stack s = new Stack();
		s.push( new Object());
		s.push( 2 );
		s.push( "well hello!");
		s.push( '4');
		assertTrue("{bottom| Obj_1 || 2 || \"well hello!\" || '4' |top}".equals(s.toString()));
		
	}
	@Test
	void test_null() {
		Stack s = new Stack();
		
		s.push( null );
		assertTrue("{bottom| null |top}".equals(s.toString()));
		
	}
	@Test
	void test_null_mix() {
		Stack s = new Stack();
		s.push( new Object());
		s.push( 2 );
		s.push( "well hello!");
		s.push( '4');
		s.push( null );
		s.push(5);
		s.push( new Object());
		assertTrue("{bottom| Obj_1 || 2 || \"well hello!\" || '4' || null || 5 || Obj_7 |top}".equals(s.toString()));
		
	}

}
