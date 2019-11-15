import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

import org.junit.jupiter.api.Test;


/**
 * @author G 01066284 Valeria L Green (VG)
 * @author G 00402127 Jorge L Martinez (JM) 
 * @author G 01082586 Blake Khan (BK)
 */
class BogusPeriodTest {

	@SuppressWarnings("deprecation")
	@Test
	void test()  {
		System.out.println("This shows the bogus period from Bloch 88:");
		BogusPeriod bp = new BogusPeriod();
	    Period p = (Period) BogusPeriod.deserialize(BogusPeriod.serializedForm);
	    System.out.println("\t"+p);
	   
	    //now making a good period 
	    Date start = new Date();
	    Date end  = new Date();
	    end.setYear(2029-1900);//for obiousness
	    Period goodPeriod = new Period(start,end);
	    System.out.println("printing goodPedriod:\n"+"\t"+goodPeriod);
	    //serializing it 
	    try {
            FileOutputStream fos = new FileOutputStream("goodPoint.tmp");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(goodPeriod);
            oos.flush();
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
	    //now making a bad point and corrupting bytes on file
	    Period malPeriod = new MaliciousPeriod(end,start);
	    try {
            FileOutputStream fos = new FileOutputStream("goodPoint.tmp");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(malPeriod);
            oos.flush();
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
	    
	    // Deserialize in to new class object
        try {
            FileInputStream fis = new FileInputStream("goodPoint.tmp");
            ObjectInputStream ois = new ObjectInputStream(fis);
            goodPeriod = (Period) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        
        //printing corrupted goodPeriod
        System.out.println("Corrupted goodPeriod:\n\t"+goodPeriod);
	   
	    
	   
	    
	}
	
	  
}
