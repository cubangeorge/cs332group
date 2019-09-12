/*
 * 
 * This program conducts test cases
 * @author Jorge L Martinez & Valeria Green
 * 
 */


import static org.junit.Assert.*;


import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;


public class Stack_Test_Suite {
	
	// ---------Altered immutable Stack class below -------

	/*test for the push method in the Stack.java file
	 * this is a test to see if the push method of awesome produces a new object
	 */
	@Test
	void test_push_diff() {
		Stack awesome = new Stack();
		assertNotSame(awesome.push(2), awesome.push(2));
	
	}//end test
	
	
	/*
	 * test for the push method in the Stack.java file
	*  tests to see if the push method is operating as fully intended
	*/
	@Test
	void test_implementation_changes() {
		Stack awesome = new Stack();

		assertEquals(0, awesome.getElements().length);
		assertEquals(1, awesome.push(2).getElements().length);
		assertEquals(2, awesome.push(2).push(10).getElements().length);
	}//end test
	
	
	

	// ---------Original mutable Stack class below -------
	
	
	//test for the push method in the Stack_Original.java file
	@Test
	void test_push_diff_stackOriginal() {
		
		Stack_Original awesome = new Stack_Original();
		//method call in case elements is public
		//assertEquals(0, awesome.elements.length);
		awesome.push(2);
		assertNotSame(awesome, awesome.pop());
		//method call in case elements is public
		//assertEquals(1, awesome.elements.length);
	}//end test

}
