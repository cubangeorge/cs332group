/*
 * 
 * This program conducts test cases
 * @author Jorge L Martinez & Valeria Green
 * 
 */
import static org.junit.Assert.*;
import java.util.concurrent.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.Scanner;

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
		
		Stack_Ft flywt_Stack   = new Stack_Ft();
		Stack_Original mutable_Stack = new Stack_Original();
		Stack imut_Stack       = new Stack();
		
		//array of objects to pull from		
		String [] a = {"Dog", "Cat", "Mouse"};
		Random rand = new Random();
		int total = 30000;
		//perform flyweight operations 
		long flyweight_time = run_push(a,flywt_Stack  , total,rand, "fStack");
		//perform imut operations
		long imut_time 		= run_push(a,imut_Stack   , total,rand, "iStack");
		//perform mutable operation
		long mut_time 		= run_push(a,mutable_Stack, total,rand, "mStack");

		//print stats
		printStats(total,flyweight_time,imut_time,mut_time);
	}//end test
	private static void printStats(int total,long flyweight_time,long imut_time,long mut_time) {
		
		//print stats
				String lines = "----------------------------";
				String header = "Performance comparison report";
				System.out.printf("%s%s%s\n",
						lines,
						header,
						lines);
				System.out.printf("%20s%20s%20s%20s\n"," ","Flyweight","Imutable","Mutable");
				System.out.printf("%20s%20d%20d%20d\n","pushed elements:",total,total,total);
				System.out.printf("%20s%20d%20d%20d\n","duration in mills:",flyweight_time,imut_time,mut_time);
				System.out.printf("%20s%20.2f%s%20.2f%s%20.2f%s\n","Slow down of",
						100-(double)(double)mut_time/flyweight_time*100,
						"%",
						100-(double)(double)mut_time/imut_time*100,
						"%",
						100-(double)mut_time/(double)mut_time*100,
						"%"
						);
	}
	private static long run_push(String [] a, Object stack, int total, Random rand, String stakcType) 
	
	{// this will calculate the time it takes for "total" pushes on the stack received
		Instant time1, time2;
			switch (stakcType) {
			case "fStack":
				{//when pushing onto a fyweight
				Stack_Ft s = (Stack_Ft) stack;
				time1 = Instant.now();
					for (int i = 0 ; i < total ; i++) {
						s = s.push( a[ rand.nextInt(a.length) ]);
						System.out.printf("%s%f%s\n","Flyweight stack Progress on "+total+" elements: ",((double)i/(double)(total-1))*100,"%");
					}
				time2 = Instant.now();	
				}
				break;
			case "iStack":
				{//when pushing into a imutable 
				Stack s = (Stack) stack;
				time1 = Instant.now();
					for (int i = 0 ; i < total ; i++) {
						s = s.push( a[ rand.nextInt(a.length) ]);
						System.out.printf("%s%f%s\n","Flyweight stack Progress on "+total+" elements: ",((double)i/(double)(total-1))*100,"%");
					}
				time2 = Instant.now();	
	
				}
				break;
			default://when pushing into a mutable
				Stack_Original s = (Stack_Original) stack;
				time1 = Instant.now();
					for (int i = 0 ; i < total ; i++) {
						s.push( a[ rand.nextInt(a.length) ]);
						System.out.printf("%s%f%s\n","Flyweight stack Progress on "+total+" elements: ",((double)i/(double)(total-1))*100,"%");
					}
				time2 = Instant.now();	

			}//end switch
		
			return Duration.between(time1, time2).toMillis();
	}

	

}
