import org.junit.jupiter.api.Test;


/**
 * @author G 01066284 Valeria L Green (VG)
 * @author G 00402127 Jorge L Martinez (JM) 
 * @author G 01082586 Blake Khan (BK)
 */
class BogusPeriodTest {

	@Test
	void test()  {
		BogusPeriod bp = new BogusPeriod();
	    Period p = (Period) BogusPeriod.deserialize(BogusPeriod.serializedForm);
	    System.out.println(p);
	}
	
	  
}
