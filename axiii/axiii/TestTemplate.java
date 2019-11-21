/**
 * 
 */
package axiii;

import org.junit.Test;
public class TestTemplate {
	@Test
    public void oneVariable() throws Exception {
        Template template = new Template("Hello, ${name}");
        template.set("name", "Reader");
        assertEquals("Hello, Reader", template.evaluate());
    }
}