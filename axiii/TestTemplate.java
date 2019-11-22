import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
/**
 * @author G 01066284 Valeria L Green (VG)
 * @author G 00402127 Jorge L Martinez (JM) 
 * @author G 01082586 Blake Khan (BK)
 */
public class TestTemplate {
	private Template template;//a commont fixture for all tests	
	private Template template2;//a commont fixture for all tests	
	@Before
	public void setUp() throws Exception {
		template = new Template("${one}, ${two}, ${three}");
		template.set("one", "1");
		template.set("two", "2");
		template.set("three", "3");
		//----------performance setup-----------------
		String[] numbers = new String[] {"One","Two","Three","Four","Five","Six","Seven",
				"Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen",
				"Sixteen","Seventeen","Eighteen","Nineteen","Twenty","Twenty-one","Twenty-two",
				"Twenty-three","Twenty-four","Twenty-five","Twenty-six","Twenty-seven",
				"Twenty-eight","Twenty-nine","Thirty","Thirty-one","Thirty-two","Thirty-three",
				"Thirty-four","Thirty-five","Thirty-six","Thirty-seven","Thirty-eight",
				"Thirty-nine","Forty","Forty-one","Forty-two","Forty-three","Forty-four",
				"Forty-five","Forty-six","Forty-seven","Forty-eight","Forty-nine","Fifty",
				"Fifty-one","Fifty-two","Fifty-three","Fifty-four","Fifty-five","Fifty-six",
				"Fifty-seven","Fifty-eight","Fifty-nine","Sixty","Sixty-one","Sixty-two",
				"Sixty-three","Sixty-four","Sixty-five","Sixty-six","Sixty-seven","Sixty-eight",
				"Sixty-nine","Seventy","Seventy-one","Seventy-two","Seventy-three","Seventy-four",
				"Seventy-five","Seventy-six","Seventy-seven","Seventy-eight","Seventy-nine",
				"Eighty","Eighty-one","Eighty-two","Eighty-three","Eighty-four","Eighty-five",
				"Eighty-six","Eighty-seven","Eighty-eight","Eighty-nine","Ninety","Ninety-one",
				"Ninety-two","Ninety-three","Ninety-four","Ninety-five","Ninety-six","Ninety-seven",
				"Ninety-eight","Ninety-nine","One hundred"};
		for (int i = 1; i < numbers.length; i++) {
			template2 = new Template("${" + numbers[i] + "}");
			template2.set(numbers[i], Integer.toString(i));
		}
	}
	@Test
	public void multipleVariables() throws Exception {
		assertTemplateEvaluatesTo("1, 2, 3"); // simple focused test 
	}
	@Test
	public void unknownVariablesAreIgnored() throws Exception {
		template.set("doesnotexist", "whatever");//|simplefocused tests|
		assertTemplateEvaluatesTo("1, 2, 3");	  //|-------------------|
	}
	private void assertTemplateEvaluatesTo(String expected) {
		assertEquals(expected, template.evaluate());
	}
	@Test
	public void missingValueRaisesException() throws Exception {
		try {
			new Template("${foo}").evaluate();
			fail("evaluate() should throw an exception if "
					+ "a variable was left without a value!");
		} catch (MissingValueException expected) {
			assertEquals("No value for ${foo}",
					expected.getMessage());
		}
	}
	@Test
	public void templateWith100WordsAnd20Variables() throws Exception {
		long expected = 200L;
		long time = System.currentTimeMillis();
		template2.evaluate();
		time = System.currentTimeMillis() - time;
		assertTrue("Rendering the template took " + time
				+ "ms while the target was " + expected + "ms",
				time <= expected);
	}
	@Test
	public void variablesGetProcessedJustOnce() throws Exception {
		template.set("one", "${one}");
		template.set("two", "${three}");
		template.set("three", "${two}");
		assertTemplateEvaluatesTo("${one}, ${three}, ${two}");
	}
	
}

