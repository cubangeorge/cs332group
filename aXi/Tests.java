import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.jupiter.api.Test;


/**
 * @author G 01066284 Valeria L Green (VG)
 * @author G 00402127 Jorge L Martinez (JM) 
 * @author G 01082586 Blake Khan (BK)
 */

class Tests {
	@Test
	/**
	 * this answers question number 1 and 
	 * shows that the equals method does work for list in terms of symmetry
	 */
	void test_InstrumentedList_equals_Symmetry() {
	
		ArrayList<String> list_1 = new ArrayList<String>();
		list_1.add("1");
		list_1.add("2");		
		ArrayList<String> list_2 = new ArrayList<String>();
		list_2.add("1");
		list_2.add("2");		
		InstrumentedList<String> il = new InstrumentedList <String>(list_1);
		assertEquals(list_1, il); //compared to it self
		assertEquals(il, list_1);// compared to it self 
		assertEquals(list_2,il);// compared to another identical list
		il.add("3");//changed the list 
		assertEquals(list_1,il); // the change can be seen through the wrapper class
	}
	
	@Test
	/**
	 * this answers question number 1 and 
	 * shows that the equals method does work for list in terms of transitivity
	 */
	void test_InstrumentedList_equals_Transitivity() {
	
		ArrayList<String> list_1 = new ArrayList<String>();
		list_1.add("1");
		list_1.add("2");		
		ArrayList<String> list_2 = new ArrayList<String>();
		list_2.add("1");
		list_2.add("2");	
		ArrayList<String> list_3 = new ArrayList<String>();
		list_3.add("1");
		list_3.add("2");
		//il corresponds to list_1
		InstrumentedList<String> il = new InstrumentedList <String>(list_1);
		//ily corresponds to list_3
		InstrumentedList<String> ily = new InstrumentedList <String>(list_3);
		
		//Demonstrating transitivity ---------------
		assertEquals (il,list_2);
		assertEquals (list_2,ily);
		assertEquals (il,ily);
//		assertEquals(list_1, il);
//		assertEquals(il, list_1);
//		
//		assertEquals(list_3, ily);
//		assertEquals(ily, list_3);
//		
//		
//		//x.equals(y) where x is il and y is list_2
//		assertEquals(list_2,il);
//		assertEquals(il, list_2);
//	
//		//y.equals(z) where y is list_2 and z is ily
//		assertEquals(list_2, ily);
//		assertEquals(ily, list_2);
//		
//		
//		//x.equals(z) where x is il and z is ily
//		assertEquals(il, ily);
//		assertEquals(ily, il);
//			
	}
	
	/**
	 * This answers question 2 
	 * Shows that the equals method fails
	 * for the intrumentedCollection class
	 */
	@Test
	void test_collections() {
		//testing instrumented collection against sets 
		HashSet <Integer> s = new HashSet<Integer>();
		s.add(1);
		s.add(2);
		InstrumentedCollection<Integer> ic = new InstrumentedCollection<Integer>(s);

		/*
		 * The test below passes since it dispatches to the 
		 * HashSetclass equals() inside the instrumented collection,
		 *  which then compares it to 
		 * an identical set using the set interface overridden 
		 * equals. 
		 */		
		assertEquals(ic,(s));
		/* the test below fails equality since it is dispatched to
		 * the HashSet class which implements Set and 
		 * thus checks if ic is an instance of Set, since it is 
		 * not, then the test fails even though the class wraps
		 * an identical HashSet. 
		 */		
		assertNotEquals(s,ic);
		///testing it now again Lists 
		ArrayList<Integer> l = new ArrayList<Integer>();
		l.add(1);
		l.add(2);
		ic = new InstrumentedCollection<Integer>(l);	
		
		/*
		 * The test below passes since it dispatches to the 
		 * ArrayList class equals() inside the instrumented collection,
		 *  which then compares it to 
		 * an identical list using the List interface overRidden 
		 * equals. 
		 */
		assertEquals(ic,l);//<--------here the test passes
		
		/* the test below fails equality since it is dispatched to
		 * the ArrayList class which implements List and 
		 * thus checks if ic is an instance of List, since it is 
		 * not, then the test fails even though the class wraps
		 * an ArrayList which does. 
		 */
		assertNotEquals(l,ic);//<------this shows broken symmetry
		
	}//end test
}
