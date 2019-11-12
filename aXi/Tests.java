import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.Test;

/**
 * @author G 01066284 Valeria L Green (VG)
 * @author G 00402127 Jorge L Martinez (JM) 
 * @author G 01082586 Blake Khan (BK)
 */

class Tests {

	/**
	 * this answers question number 1 and 
	 * shows that the equals method does work for list in terms of symmetry
	 */
	@Test
	void test_InstrumentedList_equals_Symmetry() {

		List<String> list_1 = new ArrayList<>();
		list_1.add("1");
		list_1.add("2");
		List<String> list_2 = new ArrayList<>();
		list_2.add("1");
		list_2.add("2");
		List<String> il = new InstrumentedList<>(list_1);
		assertEquals(list_1, il); //compared to it self
		assertEquals(il, list_1);// compared to it self 
		assertEquals(list_2, il);// compared to another identical list
		il.add("3");//changed the list 
		assertEquals(list_1, il); // the change can be seen through the wrapper class
	}

	/**
	 * this answers question number 1 and 
	 * shows that the equals method does work for list in terms of transitivity
	 */
	@Test
	void test_InstrumentedList_equals_Transitivity() {

		List<String> list_1 = new ArrayList<>();
		list_1.add("1");
		list_1.add("2");
		List<String> list_2 = new ArrayList<>();
		list_2.add("1");
		list_2.add("2");
		List<String> list_3 = new ArrayList<>();
		list_3.add("1");
		list_3.add("2");

		List<String> fl = new ForwardingList<>(list_2);
		//il corresponds to list_1
		List<String> il = new InstrumentedList<>(list_1);
		//ily corresponds to list_3
		List<String> ily = new InstrumentedList<>(list_3);

		//Demonstrating transitivity ---------------

		assertEquals(list_1, fl);
		assertEquals(fl, il);
		assertEquals(il, ily);
		assertEquals(list_1, ily);
	}

	/**
	 * This answers question 2 
	 * Shows that the equals method fails
	 * for the intrumentedCollection class
	 */
	@Test
	void test_collections() {
		//testing instrumented collection against sets 
		Set<Integer> s = new HashSet<>();
		s.add(1);
		s.add(2);
		Collection<Integer> ic = new InstrumentedCollection<>(s);

		/*
		 * The test below passes since it dispatches to the
		 * HashSetclass equals() inside the instrumented collection,
		 *  which then compares it to
		 * an identical set using the set interface overridden
		 * equals.
		 */
		assertEquals(ic, (s));
		/* the test below fails equality since it is dispatched to
		 * the HashSet class which implements Set and
		 * thus checks if ic is an instance of Set, since it is
		 * not, then the test fails even though the class wraps
		 * an identical HashSet.
		 */
		assertNotEquals(s, ic);

		///testing it now again Lists 
		List<Integer> l = new ArrayList<>();
		l.add(1);
		l.add(2);
		ic = new InstrumentedCollection<>(l);

		/*
		 * The test below passes since it dispatches to the
		 * ArrayList class equals() inside the instrumented collection,
		 *  which then compares it to
		 * an identical list using the List interface overRidden
		 * equals.
		 */
		assertEquals(ic, l);//<--------here the test passes

		/* the test below fails equality since it is dispatched to
		 * the ArrayList class which implements List and
		 * thus checks if ic is an instance of List, since it is
		 * not, then the test fails even though the class wraps
		 * an ArrayList which does.
		 */
		assertEquals(l, ic);//<------ !!! this shows broken symmetry (i.e. SHOULD FAIL) !!!

	}//end test
}
