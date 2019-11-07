import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collection;

import org.junit.jupiter.api.Test;


/**
 * @author G 01066284 Valeria L Green (VG)
 * @author G 00402127 Jorge L Martinez (JM) 
 * @author G 01082586 Blake Khan (BK)
 */

class Tests {
	@Test
	void test_InstrumentedList_equals() {
	
		List <String> l = Arrays.asList(new String[] {"1","2"});
		InstrumentedList<String> il = new InstrumentedList <String>(l);
		assertEquals(l, il);
		assertEquals(il, l);
		l.equals(il);
		System.out.println(il);
		System.out.println(l);
	}
	@Test
	void test_addInstrumentedCollection() {

		Collection<Integer> set1 = new ArrayList<Integer>();
		set1.add(3);
		set1.add(9);
		set1.add(38);
		
		InstrumentedCollection<Integer> collection1 = new InstrumentedCollection<Integer>(new ArrayList<Integer>());
		collection1.addAll(set1);
		
		assertEquals(3, collection1.getAddCount());
		
		collection1.add(8);
		collection1.add(39);
		collection1.add(300);
		assertEquals(6, collection1.getAddCount());
		
	}

	@Test
	void test_equalsInstrumentedCollection() {
		Collection<Integer> set1 = new ArrayList<Integer>();
		set1.add(3);
		set1.add(9);
		set1.add(38);
		
		InstrumentedCollection<Integer> collection1 = new InstrumentedCollection<Integer>(new ArrayList<Integer>());
		collection1.addAll(set1);
		
		
		ForwardingCollection<Integer> collection2 = new ForwardingCollection<Integer>(new ArrayList<Integer>());
		collection2.addAll(set1);

		assertEquals(3, collection1.getAddCount());
		assertEquals(3, collection2.size());
		
		assertFalse(collection2.equals(collection1)); //not equal even if add the same things
		assertFalse(collection2.equals(collection2)); //not equal even if add the same things
	}
}
