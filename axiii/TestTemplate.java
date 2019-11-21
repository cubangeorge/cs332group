import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


/**
 * @author G 01066284 Valeria L Green (VG)
 * @author G 00402127 Jorge L Martinez (JM) 
 * @author G 01082586 Blake Khan (BK)
 */

class TestTemplate {
	@Test
    public void oneVariable() throws Exception {
        Template template = new Template("Hello, ${name}");
        template.set("name", "Reader");
        assertEquals("Hello, Reader", template.evaluate());
    }
	
	@Test
	public void differentTemplate() throws Exception {
		Template template = new Template("Hi, ${name}");
		template.set("name", "someone else");
		assertEquals("Hi, someone else", template.evaluate());
		
	}

}
