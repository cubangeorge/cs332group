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

	
	@Test
	void test_push_diff() {
		Stack awesome = new Stack();
		//Stack awesome2 = new Stack();
		assertNotSame(awesome, awesome.push(2));
		
		
		System.out.print(awesome.push(2).toString());
	}//end test
	

	
	/*@Test
	void test_pop_diff() {
		Stack awesome = new Stack();
		assertNotSame(awesome, awesome.immutable_pop());
		
	}//end test
	
	@Test
	void test_pop_same() {
		Stack awesome = new Stack();
		assertSame(awesome, awesome.mutable_pop());
		
	}//end test*/
	
}
