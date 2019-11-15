import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 * @author jorge
 *
 */
class BogusPeriodTest {

	@Test
	void test()  {
		BogusPeriod bp = new BogusPeriod();
	    Period p = (Period) bp.deserialize(bp.serializedForm);
	    System.out.println(p);
	}
	
	  
}
