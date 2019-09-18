/*
 * 
 * This program conducts test cases
 * @author Jorge L Martinez & Valeria Green & Blake Khan
 * 
 */
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
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
		assertEquals(null,imut_Stack.last());
		assertEquals('c', imut_Stack.push('a').push('b').push('c').last());
		assertEquals('d', imut_Stack.push('a').push('b').push('d').last());
	}//end test
	
	@Test
	void test_push_and_pop_iStack() {
		
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
	void test_all_stacks_performance() {
		
		Stack_Ft fStack   = new Stack_Ft();
		Stack_Original mStack = new Stack_Original();
		Stack iStack       = new Stack();
		
		//array of objects to pull from		
		String [] a = {"Dog", "Cat", "Rat"};
		Random rand = new Random();
		int total = 300;
		Instant time1, time2;
		//perform flyweight operations 
		time1 = Instant.now();
		fStack = (Stack_Ft) run_push(a,fStack  , total,rand);
		time2 = Instant.now();
		long flyweight_time = Duration.between(time1, time2).toMillis();

		//perform imut operations
		time1 = Instant.now();
		iStack = (Stack) run_push(a,iStack   , total,rand);
		time2 = Instant.now();
		long imut_time = Duration.between(time1, time2).toMillis();
		//perform mutable operation
		time1 = Instant.now();
		mStack	= (Stack_Original) run_push(a,mStack, total,rand);
		time2 = Instant.now();
		long mut_time = Duration.between(time1, time2).toMillis();

		//print stats
		printStats(total,flyweight_time,imut_time,mut_time,iStack,fStack,mStack,a);
				
		
	}//end test
	
	private static void printStats(int total,long flyweight_time,long imut_time,long mut_time,
									Stack iStack, Stack_Ft fStack, Stack_Original mStack, String  []a) {
		
		//print stats
				String lines = "----------------------------";
				String header = "Performance comparison report";
				System.out.printf("%s%s%s\n",
						lines,
						header,
						lines);
				System.out.println("Objects pushed at random:        "+Arrays.toString(a)+"\n");
				System.out.printf("%20s%20s%20s%20s\n"," ","Flyweight","Imutable","Mutable");
				System.out.printf("%20s%20d%20d%20d\n","pushed elements:",
						total,total,total);
				System.out.printf("%20s%20d%20d%20d\n","duration in mills:",
						flyweight_time,imut_time,mut_time);
				System.out.printf("%20s%20.2f%s%20.2f%s%20.2f%s\n","Slow down of:",
						100-(double)(double)mut_time/flyweight_time*100,
						"%",
						100-(double)(double)mut_time/imut_time*100,
						"%",
						100-(double)mut_time/(double)mut_time*100,
						"%"
						);
				System.out.printf("%20s%20d%20d%20d\n","Objects built:",
						Stack_Ft.getMapsize(),
						iStack.getSize(),
						mStack.getSize());
				System.out.printf("%20s%20d%20d%20d\n","Bytes:",
						Stack_Ft.getMapsize()*3,
						iStack.getSize()*3,
						mStack.getSize()*3);

	}
	private static Object run_push(String [] a, Object stack, int total, Random rand) 
	
	{// this will calculate the time it takes for "total" pushes on the stack received
		
		
			switch (stack.getClass().toString()) {
			case "class Stack_Ft":
				{//when pushing onto a fyweight
				Stack_Ft s = (Stack_Ft) stack;
				
					for (int i = 0 ; i < total ; i++) {
						s = s.push( a[ rand.nextInt(a.length) ]);
						System.out.printf("%s%f%s\n","Flyweight stack Progress on "+total+" elements: ",((double)i/(double)(total-1))*100,"%");
					}
					return s;
				}
				
			case "class Stack":
				{//when pushing into a imutable 
				Stack s = (Stack) stack;
					for (int i = 0 ; i < total ; i++) {
						s = s.push( a[ rand.nextInt(a.length) ]);
						System.out.printf("%s%f%s\n","Imutable stack Progress on "+total+" elements: ",((double)i/(double)(total-1))*100,"%");
					}
					return s;
				}
			default://when pushing into a mutable
				Stack_Original s = (Stack_Original) stack;
					for (int i = 0 ; i < total ; i++) {
						s.push( a[ rand.nextInt(a.length) ]);
						System.out.printf("%s%f%s\n","Mutable stack Progress on "+total+" elements: ",((double)i/(double)(total-1))*100,"%");
					}
				return s;	
			}//end switch
			
	}//end run push

}//end class Test_Suite
