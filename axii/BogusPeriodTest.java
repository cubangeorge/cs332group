import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.jupiter.api.Test;


/**
 * @author G 01066284 Valeria L Green (VG)
 * @author G 00402127 Jorge L Martinez (JM) 
 * @author G 01082586 Blake Khan (BK)
 */
class BogusPeriodTest {

	
	@Test
	void test()  {
		//printing Bogus point
		System.out.println("This shows the bogus period from Bloch 88:");
	    Period p = (Period) BogusPeriod.deserialize(BogusPeriod.serializedForm);
	    System.out.println("\t"+p);
	   
	    //now setting up date preliminaries
	    Date start=null;
	    Date end=null ;
	    SimpleDateFormat sdf = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
	    
		try {
			start = sdf.parse("Thu Nov 14 00:29:32 EST 2019");
			end   = sdf.parse("Thu Nov 15 00:29:32 EST 2029");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
	    
		//now making good and bad points 

	    Period goodPeriod = new Period(start,end);//good Period 
	    Period malPeriod = new MaliciousPeriod(end,start);//bad Period
	    
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
	   
	    //now making a bad point and corrupting bytes on file by reversing bit pattern
	    byte[] b = {(byte) 0xac, (byte) 0xed, 0x00, 0x05, 0x73, 0x72, 0x00, 0x0f,
	    		0x4d, 0x61, 0x6c, 0x69, 0x63, 0x69, 0x6f, 0x75, 0x73, 0x50, 0x65, 
	    		0x72, 0x69, 0x6f, 0x64, 0x65, (byte) 0xf9, 0x31, 0x39, 0x31, 0x7e, 
	    		(byte) 0xaf, (byte) 0xaa, 0x02, 0x00, 0x02, 0x4c, 0x00, 0x03, 0x65, 
	    		0x6e, 0x64, 0x74, 0x00, 0x10, 0x4c, 0x6a, 0x61, 0x76, 0x61, 0x2f, 
	    		0x75, 0x74, 0x69, 0x6c, 0x2f, 0x44, 0x61, 0x74, 0x65, 0x3b, 0x4c, 
	    		0x00, 0x05, 0x73, 0x74, 0x61, 0x72, 0x74, 0x71, 0x00, 0x7e, 0x00, 
	    		0x01, 0x78, 0x72, 0x00, 0x06, 0x50, 0x65, 0x72, 0x69, 0x6f, 0x64, 
	    		0x40, 0x7e, (byte) 0xf8, 0x2b, 0x4f, 0x46, (byte) 0xc0, (byte) 0xf4,
	    		0x02, 0x00, 0x02, 0x4c, 0x00, 0x03, 0x65, 0x6e, 0x64, 0x71, 0x00, 
	    		0x7e, 0x00, 0x01, 0x4c, 0x00, 0x05, 0x73, 0x74, 0x61, 0x72, 0x74, 
	    		0x71, 0x00, 0x7e, 0x00, 0x01, 0x78, 0x70, 0x73, 0x72, 0x00, 0x0e, 
	    		0x6a, 0x61, 0x76, 0x61, 0x2e, 0x75, 0x74, 0x69, 0x6c, 0x2e, 0x44, 
	    		0x61, 0x74, 0x65, 0x68, 0x6a, (byte) 0x81, 0x01, 0x4b, 0x59, 0x74, 
	    		0x19, 0x03, 0x00, 0x00, 0x78, 0x70, 0x77, 0x08, 0x00, 0x00, 0x01, 
	    		0x6e, 0x68, 0x63, 0x5a, 0x60, 0x78, 0x73, 0x71, 0x00, 0x7e, 0x00, 
	    		0x04, 0x77, 0x08, 0x00, 0x00, 0x01, 0x6e, 0x68, 0x63, 0x5a, 0x60, 
	    		0x78, 0x73, 0x71, 0x00, 0x7e, 0x00, 0x04, 0x77, 0x08, 0x00, 0x00, 
	    		0x01, 0x6e, 0x68, 0x63, 0x5a, 0x60, 0x78, 0x73, 0x71, 0x00, 0x7e, 
	    		0x00, 0x04, 0x77, 0x08, 0x00, 0x00, 0x01, (byte) 0xb7, (byte) 0xe9,
	    		(byte) 0xe8, (byte) 0x82, 0x60, 0x78, 0x0a };
	    
	    try {
			Files.write(new File("goodPeriod.tmp").toPath(), b);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	  
	  //show they are different before corruption
        assertNotEquals(goodPeriod.toString(),malPeriod.toString()); 

	    // Deserialize it to load corrupted Period
        try {
            FileInputStream fis = new FileInputStream("goodPeriod.tmp");
            ObjectInputStream ois = new ObjectInputStream(fis);
            goodPeriod = (Period) ois.readObject();
            ois.close();
        	//goodPeriod = (Period) new ObjectInputStream( new ByteArrayInputStream(b)).readObject();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        
        //printing corrupted goodPeriod 
        //show they are the same now
        System.out.println("Corrupted goodPeriod:\n\t"+goodPeriod);
	    assertEquals("Thu Nov 15 00:29:32 EST 2029 - Thu Nov 14 00:29:32 EST 2019", goodPeriod.toString()); 
	    assertEquals(goodPeriod.toString(),malPeriod.toString());
	    
	}
	
	  
}
