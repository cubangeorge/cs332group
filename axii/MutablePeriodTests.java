import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
//import java.time.Period;
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
	 * Sets the dates in the wrong order by having the 1978 date by the end and then test ensures that the dates are in the wrong order
	 * 
	 */
	@SuppressWarnings("deprecation")
	@Test
	void turnBackTime() {
		MutablePeriod mp = new MutablePeriod();
	    Period p = (Period) mp.period;
	    Date pEnd = mp.end;
	    pEnd.setYear(78);
	    LocalDateTime nowTime = LocalDateTime.now();
	    DateTimeFormatter formatty1 = DateTimeFormatter.ofPattern("E MMM dd HH:mm 'EST' yyyy"); 
	    DateTimeFormatter formatty2 = DateTimeFormatter.ofPattern("'Tue' MMM dd HH:mm 'EST 1978'"); 
	    String theTimeIsNow = formatty1.format(nowTime);
	    String theTimeIsNotNow = formatty2.format(nowTime);
	    
	    String overallString = theTimeIsNow + " - " + theTimeIsNotNow;
	    
	    //removes the last seconds of the mutable period object so that the equality can be more correct
	    String resultantString3 = p.toString().substring(0, 16) + " " + p.toString().substring(20, 47) + " " + p.toString().substring(51, p.toString().length());

		assertEquals(overallString, resultantString3);
	}
	
	
	/**
	 * 
	 * Sets the dates in the wrong order by having the 1969 date by the end and then test ensures that the dates are in the wrong order
	 */
	@SuppressWarnings("deprecation")
	@Test
	void turnBackTimeAgain() {
		MutablePeriod mp = new MutablePeriod();
	    Period p = (Period) mp.period;
	    Date pEnd = mp.end;
	    pEnd.setYear(69);
	    LocalDateTime nowTime = LocalDateTime.now();
	    DateTimeFormatter formatty1 = DateTimeFormatter.ofPattern("E MMM dd HH:mm 'EST' yyyy"); 
	    DateTimeFormatter formatty2 = DateTimeFormatter.ofPattern("'Fri' MMM dd HH:mm 'EST 1969'"); 
	    String theTimeIsNow = formatty1.format(nowTime);
	    String theTimeIsNotNow = formatty2.format(nowTime);
	    
	    String overallString = theTimeIsNow + " - " + theTimeIsNotNow;
	    
	    //removes the last seconds of the mutable period object so that the equality can be more correct
	    String resultantString3 = p.toString().substring(0, 16) + " " + p.toString().substring(20, 47) + " " + p.toString().substring(51, p.toString().length());

	    
		assertEquals(overallString, resultantString3);
	}


}
