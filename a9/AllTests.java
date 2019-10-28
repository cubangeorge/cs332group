import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * @author jorge
 *
 */
@TestMethodOrder(OrderAnnotation.class)
class AllTests {
	/**
	 * here we implement a test that shows the poorly 
	 * implemented  clone class which ultimately results 
	 * in a class cast cast exception inside the subclass
	 */
	@Test
	@Order(4)
	void poor_clone_imple_test() {
		Doomed_subclass d = new Doomed_subclass();
		d.add(1);
		d.add(2);
		d.add(3);
		System.out.println("Doomed_subclass_subclass class: "+d.toString());
		Doomed_subclass d_clone = new Doomed_subclass();
		System.out.println("created Doomed_subclass_subclass clone d_clone: "+d_clone);
		
		try {
			d_clone = (Doomed_subclass) d.clone();
			System.out.println("no Class Cast Exception thrown");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("Exception: \n"+e+
					"\nThis is our test showing the clone fault in IntSet.java");
			fail("end or testing\n=============================================");
		}
		
	}
	/**
	 * Test method for {@link NegativeIntSet#clone()}.
	 */
	@Test
	@Order(1)
	void nice_clone_imple_tets() {
		NegativeIntSet original = new NegativeIntSet();
		try {
			assertTrue(original.clone().getClass()==original.getClass());
		} catch (CloneNotSupportedException e1) {

			e1.printStackTrace();
			fail("intSetGood implementation failed");
		}
		int size = 10;
		for (int i = 0; i < size; i++) {
			original.add(i);
		}
		
		try {
			
			NegativeIntSet clone = (NegativeIntSet) original.clone();
			assertTrue(clone.equals(original)); //test happy path equal
			System.out.printf(
							  "clone_list class type:"+clone.getClass()+"\n"+
							  "origi_list class type:"+original.getClass()+"\n\n"+
							  "assertTrue(clone.equals(original)) passed:\n"+
							  "---------------\n"+
							  "clone list:"+clone+"\n"+
							  "origi list:"+original+"\n"+
							  "---------------\n"+
							  "Equal subclass lists "+
							  "copied by super class clone\n"+
							  "============================"+
							  "============================\n\n");
			
			original.set(0,24);
			System.out.println("modifying origi list to differ from cloned list...");
			assertFalse(clone.equals(original)); //test happy path not equal
			System.out.printf(
					  "clone_list class type:"+clone.getClass()+"\n"+
					  "origi_list class type:"+original.getClass()+"\n\n"+
					"test assertFalse passed:\n"+
					"---------------\n"+
					"clone list:"+clone+"\n"+
					"origi list:"+original+"\n"+
					"---------------\n"+
					"UnEqual subclass lists "+
					"copied by super class clone\n"+
					"============================"+
					"============================\n\n");

			clone.set(0, 4);//add a duplicate 
			System.out.println("attempting to add a duplicate using clone.set(0,4)");
			assertFalse(clone.equals(original)); //test happy path not equal again
			System.out.printf(
					"clone_list class type:"+clone.getClass()+"\n"+
					"origi_list class type:"+original.getClass()+"\n\n"+
					"test assertFalse passed:\n"+
					"---------------\n"+
					"clone list:"+clone+"\n"+
					"origi list:"+original+"\n"+
					"---------------\n"+
					"UnEqual subclass lists "+
					"cloned unmodified no duplicates allowed\n"+
					"============================"+
					"============================\n\n");

			clone.set(0, 24); // make the clone look like the original again
			System.out.println("now updating clone to match original list using clone.set(0,24)");
			assertTrue(clone.equals(original)); //test happy path equal
			System.out.printf(
					"clone_list class type:"+clone.getClass()+"\n"+
					"origi_list class type:"+original.getClass()+"\n\n"+
					"test assertTrue passed:\n"+
					"---------------\n"+
					"clone list:"+clone+"\n"+
					"origi list:"+original+"\n"+
					"---------------\n"+
					"Equal subclass lists "+
					"match again upadted using super class super.set(0,24)\n"+
					"============================"+
					"============================\n\n");


			
		} catch(CloneNotSupportedException e) {
			System.err.println("error " + e);
			fail("unexpected exception didn't happen");
		}
		
		
		
	}//end test
	//3#####################################################################3
	//		from here down is all internal testing and not clone
	//#######################################################################
	/**
	 * Test method for {@link NegativeIntSet#equals(java.lang.Object)}.
	 */
	@Test
	@Order(2)
	void test_NIS_equals() {
		//compare it with another instance 
		//of the same class
		NegativeIntSet il1 = new NegativeIntSet();
		NegativeIntSet il2 = new NegativeIntSet();
		assertTrue(il1.equals(il2)); //tests happy path equal empty lists

		il1.add(5);
		il1.add(6);
		il1.add(7);
		il1.add(8);
		assertFalse(il1.equals(il2)); //tests happy path not equal
		
		il2.add(5);
		il2.add(6);
		il2.add(7);
		il2.add(8);
		
		assertTrue(il1.equals(il2)); //tests happy path equal
		il2.add(9);
		assertFalse(il1.equals(il2)); //tests happy path not equal		
	}

	/**
	 * Test method for {@link NegativeIntSet#add(java.lang.Object)}.
	 */
	@Test
	@Order(3)
	void test_NIS_add() {
		
		NegativeIntSet il1 = new NegativeIntSet();
		assertEquals("[]", il1.toString());//tests empty list
		//add a few elements
		il1.add(5);
		il1.add(6);
		il1.add(7);
		il1.add(8);
		
		assertEquals("[-5, -6, -7, -8]",il1.toString());//test happy path
		il1.add(8);
		assertEquals("[-5, -6, -7, -8]",il1.toString());//test no duplicates
		
	}

}
