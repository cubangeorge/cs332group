/**
 * @author G 01066284 Valeria L Green (VG)
 * @author G 00402127 Jorge L Martinez (JM) 
 * @author G 01082586 Blake Khan (BK)
 */

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
public class TestTemplatePerformance {
	private Template template;
	@Before
	public void setUp() throws Exception {
		String[] numbers = new String[] {"One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen","Twenty","Twenty-one","Twenty-two","Twenty-three","Twenty-four","Twenty-five","Twenty-six","Twenty-seven","Twenty-eight","Twenty-nine","Thirty","Thirty-one","Thirty-two","Thirty-three","Thirty-four","Thirty-five","Thirty-six","Thirty-seven","Thirty-eight","Thirty-nine","Forty","Forty-one","Forty-two","Forty-three","Forty-four","Forty-five","Forty-six","Forty-seven","Forty-eight","Forty-nine","Fifty","Fifty-one","Fifty-two","Fifty-three","Fifty-four","Fifty-five","Fifty-six","Fifty-seven","Fifty-eight","Fifty-nine","Sixty","Sixty-one","Sixty-two","Sixty-three","Sixty-four","Sixty-five","Sixty-six","Sixty-seven","Sixty-eight","Sixty-nine","Seventy","Seventy-one","Seventy-two","Seventy-three","Seventy-four","Seventy-five","Seventy-six","Seventy-seven","Seventy-eight","Seventy-nine","Eighty","Eighty-one","Eighty-two","Eighty-three","Eighty-four","Eighty-five","Eighty-six","Eighty-seven","Eighty-eight","Eighty-nine","Ninety","Ninety-one","Ninety-two","Ninety-three","Ninety-four","Ninety-five","Ninety-six","Ninety-seven","Ninety-eight","Ninety-nine","One hundred"};
		for (int i = 1; i < numbers.length; i++) {
			template = new Template("${" + numbers[i] + "}");
			template.set(numbers[i], Integer.toString(i));
		}
	}

    // Omitted the setUp() for creating a 100-word template
    // with 20 variables and populating it with approximately
    // 15-character values

    @Test
    public void templateWith100WordsAnd20Variables() throws Exception {
        long expected = 200L;
        long time = System.currentTimeMillis();
        template.evaluate();
        time = System.currentTimeMillis() - time;
        assertTrue("Rendering the template took " + time + "ms while the target was " + expected + "ms", time <= expected);
    }
}