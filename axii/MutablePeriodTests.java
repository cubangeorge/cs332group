import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.Period;
import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @author G 01066284 Valeria L Green (VG)
 * @author G 00402127 Jorge L Martinez (JM) 
 * @author G 01082586 Blake Khan (BK)
 */


class MutablePeriodTests {
	
	
	/**
	 * 
	 */
	@SuppressWarnings("deprecation")
	@Test
	void turnBackTime() {
		MutablePeriod mp = new MutablePeriod();
	    //Period p = mp.period;
	    Date pEnd = mp.end;
		assertFalse(true);
		//assertEquals("Wed Nov 22 00:21:29 PST 2017 - Wed Nov 22 00:21:29 PST 1978", pEnd.setYear(78).toString());
	}
	
	
	/**
	 * 
	 */
	@SuppressWarnings("deprecation")
	@Test
	void turnBackTimeAgain() {
		MutablePeriod mp = new MutablePeriod();
	    //Period p = mp.period;
	    Date pEnd = mp.end;
		assertFalse(true);
	    //assertEquals("Wed Nov 22 00:21:29 PST 2017 - Sat Nov 22 00:21:29 PST 1969", pEnd.setYear(69).toString());
	}


}
