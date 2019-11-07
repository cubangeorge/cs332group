import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

/**
 * @author jorge
 *
 */
class ClientCode {

	@Test
	void test() {
		Set<String> r = new HashSet<String>();
		r.add("ant"); 
		r.add("bee");
		System.out.println("Executed :\n"+
				"		Set<String> r = new HashSet<String>();\n" + 
				"		r.add(\"ant\"); \n" + 
				"		r.add(\"bee\");\n" + 
				"");
		System.out.println("r is: "+r);
		System.out.println("------------------");

		Set<String> sh = new InstrumentedHashSet<String>();
		sh.addAll(r);
		sh.add("red");
		System.out.println("Executed :\n"+
				"		Set<String> sh = new InstrumentedHashSet<String>();\n" + 
				"		sh.addAll(r);\n");
		System.out.println("sh is: "+sh);
		System.out.println("------------------");
		Set<String> s =  new InstrumentedSet<String>(r);
		s.add("ant"); 
		s.add("cat");//this adds it to r as well
		System.out.println("Executed : \n"+
				"		Set<String> s =  new InstrumentedSet<String>(r);\n" + 
				"		s.add(\"ant\"); \n" + 
				"		s.add(\"cat\");\n" );
		System.out.println("s is:"+s);
		System.out.println("r is:"+r);
		System.out.println("------------------");
		Set<String> t = new InstrumentedSet<String>(s);
		t.add("dog");
		r.remove("bee"); 
		s.remove("ant");
		System.out.println("Executed: \n"
				+ "		Set<String> t = new InstrumentedSet<String>(s);\n" + 
				"		t.add(\"dog\");\n" + 
				"		r.remove(\"bee\"); \n" + 
				"		s.remove(\"ant\");\n" + 
				"");
		System.out.println(
				"t  is:"+t+"\n"+
				"r  is:"+r+"\n"+
				"s  is:"+s+"\n"+
				"sh is:"+sh+"\n"+
				"");
		System.out.println("------------------");
		System.out.println("##################end set execution##################");
		System.out.println("1) How do you think the addCount variable should be updated in the addAll() method in InstrumentedHashSet?\n" + 
				"	Answer: dont update it since add is called inside the addAll AbstractCollection class. See implementation below\n" + 
				"        public boolean addAll(Collection<? extends E> c) {\n" + 
				"               boolean modified = false;\n" + 
				"               for (E e : c)\n" + 
				"                  if (add(e))\n" + 
				"          		      modified = true;\n" + 
				"		        return modified;\n");
		System.out.println("2) Why is this an unpleasant question?\n"+
				"Answer 2: \n"+
				"	It requires client to know implementation detail about the super class\n");

		System.out.println("3) Is the answer documented anywhere?\n"
				+ "Answer 3: \n"
				+ "	NO, the answer cant be documented anywhere");
		System.out.println("4) Should it be?\n"
				+ "Answer 4:\n"
				+ "		Definitely should not be  since the whole idea behind Encapsulation\n" + 
				"		is to hide the implementation details from client classes\n" + 
				"		the only way to find the answer is to go take a look a the soruce \n"+ 
				"		code of the super class which is shown up in Answer 1\"");
		System.out.println("5) What does the answer say about inheritance?\n"
				+ "	Answer5: \n"
				+ "		shows that it is not appropriate in this case since it brakes encapsulation" ); 
		System.out.println("6) Does equals() behave correctly in InstrumentedHashSet?\n"
				+ "Answer 6:");
		
		
	}

}
