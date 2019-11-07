import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;


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

}
