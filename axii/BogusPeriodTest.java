import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.Period;

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
	void test() {
			BogusPeriod bp = new BogusPeriod();//this will contain  MODIFIED POINT
		    Period p = (Period) deserialize(bp.getBp());
		    System.out.println(p);

		  
	}
	// Returns the object with the specified serialized form
	  static Object deserialize(byte[] sf) {
	    try {
	      return new ObjectInputStream( new ByteArrayInputStream(sf))
	    		  .readObject();
	    } catch (IOException | ClassNotFoundException e) {
	      throw new IllegalArgumentException(e);
	    }
	  }

}
