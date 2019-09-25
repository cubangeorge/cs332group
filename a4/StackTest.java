import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * @author Jorge, Valeria, Blake   
 *
 */
class StackTest {

	private Stack s;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		s = new Stack();
	}	

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		s = null;
	}

	/**
	 * Test method for {@link java.lang.Object#toString()}.
	 */
	@Test
	void test_nums() {
		
		s.push(1);
		s.push(new Integer (2));
		s.push(3);
		s.push(-3);
		s.push(-3.4);
		s.pop();
		s.push(-3.4);
		s.push(0.567);
		s.pop();
		s.push(0.567);
		s.pop();
		s.push(0.567);
		assertTrue("{bottom| 1 || 2 || 3 || -3 || -3.4 || 0.567 |top}".equals(s.toString()));
		
	}
	@Test
	void test_empty_stack() {
		assertTrue("{}".equals(s.toString()));
		
	}
	@Test
	void test_chars() {
		s.push(new Character ('a'));
		s.push('b');
		s.push('c');
		
		assertTrue("{bottom| 'a' || 'b' || 'c' |top}".equals(s.toString()));
		
	}
	@Test
	void test_Strings() {
		s.push("cat");
		s.push("dog");
		s.push("bat");
		assertTrue("{bottom| \"cat\" || \"dog\" || \"bat\" |top}".equals(s.toString()));
		
	}
	@Test
	void test_Objects() {
		s.push( new Object());
		s.push( new Object());
		s.push( new Object());
		assertTrue("{bottom| Obj_1 || Obj_2 || Obj_3 |top}".equals(s.toString()));
		
	}
	@Test
	void test_mix() {
		s.push( new Object());
		s.push( 2 );
		s.push( "well hello!");
		s.push( '4');
		assertTrue("{bottom| Obj_1 || 2 || \"well hello!\" || '4' |top}".equals(s.toString()));
		
	}
	@Test
	void test_nulls() {
		Stack s = new Stack();
		s.push( null );
		s.push( null );
		s.push( null );
		assertTrue("{bottom| null || null || null |top}".equals(s.toString()));
		
	}
	@Test
	void test_Xtra_nulls() {
		
		s.push( null );
		s.push( null );
		s.push( null );
		s.push( 2 );
		s.push( 0 );
		s.push( null );
		//System.out.println(s);
		assertTrue("{bottom| null || null || null || 2 || 0 || null |top}".equals(s.toString()));
		
	}
	@Test
	void test_null() {
		s.push( null );
		assertTrue("{bottom| null |top}".equals(s.toString()));
		
	}
	
	@Test
	void test_black_box() {
		BlackBox b = new BlackBox();
		String r="";
		s.push(1);
		s.push(new Integer (2));
		s.push(3);
		s.push(-3);
		s.push(-3.4);
		s.pop();
		s.push(-3.4);
		s.push(0.567);
		s.pop();
		s.push(0.567);
		s.pop();
		s.push(0.567);
		s.push( null );
		s.push( null );
		s.push( null );
		r = s.toString().substring(0, 7);
		r += s.toString().substring(7, 45);
		r += "| null || null || null |";
		r += "| Obj_"+1+""+0+" |";
		r += s.toString().substring(69);
		s.push(b);
		//mmmmmwwwwahahahahahahaha
		assertEquals(r,s.toString());
	
	}
	@Test
	void test_null_mix() {
		s.push( new Object());
		s.push( 2 );
		s.push( "well hello!");
		s.push( '4');
		s.push( null );
		s.push(5);
		s.push( new Object());
		s.push( new Object());
		assertTrue("{bottom| Obj_1 || 2 || \"well hello!\" || '4' || null || 5 || Obj_7 || Obj_8 |top}".equals(s.toString()));
	}

	@Test
	void test_fault_size_ri() {
		s.push(5);
		s.push(3);
		s.push(2);
		s.push(4);
		assertEquals(4, s.getSize());
		assertEquals(7, s.elements.length);
		// Set size greater than the array length
		s.size = 8;
		assertFalse(s.repOK());
	}

	@Test
	void test_fault_array_ri() {
		s.push(5);
		s.push(3);
		s.push(2);
		s.push(4);
		assertEquals(4, s.getSize());
		assertEquals(7, s.elements.length);
		// Set element as non null past the size.
		s.elements[s.elements.length - 1] = -99;
		assertFalse(s.repOK());
	}
	@Test
	void test_Gui() throws InvocationTargetException, InterruptedException {
		s.push( new Object());
		s.push( 2 );
		s.push( "well hello!");
		s.push( '4');
		s.push( null );
		s.push(5);
		s.push( new Object());
		s.push( new Object());
		
		DrawStackGui.main2(s);
		assertTrue("{bottom| Obj_1 || 2 || \"well hello!\" || '4' || null || 5 || Obj_7 || Obj_8 |top}".equals(s.toString()));
		Thread.sleep(10000);
		
	}

}
