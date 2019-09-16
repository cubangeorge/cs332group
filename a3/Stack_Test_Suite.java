/*
 * 
 * This program conducts test cases
 * @author Jorge L Martinez & Valeria Green
 * 
 */
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

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

		assertEquals(0, awesome.getSize());
		assertEquals(1, awesome.push(2).getSize());
		assertEquals(2, awesome.push(2).push(10).getSize());
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

	@Test
	void test_default_constructor_and_getSize() {
		
		Stack imut_Stack = new Stack();
		assertEquals(0, imut_Stack.getSize());
	}//end test
	
	@Test
	void test_private_constructor() {
		
		Stack imut_Stack = new Stack();
		assertEquals(3, imut_Stack.push('a').push('b').push('c').getSize());
	}//end test
	
	@Test
	void test_last() {
		
		Stack imut_Stack = new Stack();
		try {
			imut_Stack.last();
			fail("no Excetion thrown");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("Exception caught OK: "+e);
		}
		assertEquals('c', imut_Stack.push('a').push('b').push('c').last());
		assertEquals('d', imut_Stack.push('a').push('b').push('d').last());
	}//end test
	
	@Test
	void test_push_and_pop() {
		
		Stack imut_Stack = new Stack();
		Stack_Original mutable = new Stack_Original();
		mutable.push('a');
		mutable.push('b');
		mutable.push('c');
		assertEquals(mutable.pop(), imut_Stack.push('a').push('b').push('c').last());
		assertEquals(mutable.pop(), imut_Stack.push('a').push('b').push('c').pop().last());
		assertEquals(mutable.pop(), imut_Stack.push('a').push('b').push('c').pop().pop().last());
	}//end test

	@Test
	void test_flyweight_Stack() {
		
		Stack_Ft imut_Stack = new Stack_Ft();
		Stack_Original mutable = new Stack_Original();
		mutable.push('a');
		mutable.push('b');
		mutable.push('c');
		assertEquals(mutable.pop(), imut_Stack.push('a').push('b').push('c').last());
		assertEquals(mutable.pop(), imut_Stack.push('a').push('b').push('c').pop().last());
		assertEquals(mutable.pop(), imut_Stack.push('a').push('b').push('c').pop().pop().last());
	}//end test
	@Test
	void test_flyweight_Stack2() {
		
		Stack_Ft imut_Stack = new Stack_Ft();
		Stack_Original mutable = new Stack_Original();
		mutable.push('a');
		mutable.push('b');
		mutable.push('c');
		mutable.push(456);
		imut_Stack= imut_Stack.push('a');
		imut_Stack= imut_Stack.push('b');
		imut_Stack= imut_Stack.push('c');
		imut_Stack= imut_Stack.push(456);
		
		assertEquals(mutable.pop(), imut_Stack.last());
		imut_Stack = imut_Stack.pop();
		assertEquals(mutable.pop(), imut_Stack.last());
		imut_Stack = imut_Stack.pop();
		assertEquals(mutable.pop(), imut_Stack.last());
		imut_Stack = imut_Stack.pop();
		assertEquals(mutable.pop(), imut_Stack.last());
		imut_Stack = imut_Stack.pop();
		
		
		//array of objects to pull from		
		String [] a = {"Dog", "Cat", "Mouse"};
        Random rand = new Random();

		for (int i = 0 ; i < 1000 ; i++) {
			
			imut_Stack = imut_Stack.push(a[ rand.nextInt( 3 ) ]);
				
		}
		System.out.println(imut_Stack.toString());
	}//end test
}
