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
	
	/**
	 * Evaluate template “${one}, ${two}, ${three}” with values “1”, “${foo}”, and “3”, respectively, and verify that the template engine renders the result as “1, ${foo}, 3”.
	 * 
	 */
	@Test
	public void multipleVariables() throws Exception {
	    Template template = new Template("${one}, ${two}, ${three}");
	    template.set("one", "1");
	    template.set("two", "2");
	    template.set("three", "3");
	    assertEquals("1, 2, 3", template.evaluate());
	}
	
	
	@Test
	public void unknownVariablesAreIgnored() throws Exception 	{
	    Template template = new Template("Hello, ${name}");
	    template.set("name", "Reader");
	    template.set("doesnotexist", "Hi");
	    assertEquals("Hello, Reader", template.evaluate());
	}

}
