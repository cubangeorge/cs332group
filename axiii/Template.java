/**
 * @author G 01066284 Valeria L Green (VG)
 * @author G 00402127 Jorge L Martinez (JM) 
 * @author G 01082586 Blake Khan (BK)
 */

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Map.Entry;

public class Template {
	private Map<String, String> variables;
	private String templateText;
	public Template(String templateText) {
		this.variables = new HashMap<String, String>();
		this.templateText = templateText;
	}
	public void set(String name, String value) {
		this.variables.put(name, value);
	}
	public String evaluate() {
		String result = replaceVariables();//evaluate
		checkForMissingValues(result);//much better balanced
		return result;
	}
	private String replaceVariables() {							  //New Method 
		String result = templateText;							  //is simple 
		for (Entry<String, String> entry : variables.entrySet()) {//and single, 
			String regex = "\\$\\{" + entry.getKey() + "\\}";	  //clear 
			result = result.replaceAll(regex, entry.getValue());  //purpose 
		}														  //
		return result;											  //			
	}
	private void checkForMissingValues(String result) {
		Matcher m = Pattern.compile("\\$\\{.+\\}").matcher(result);
		if (m.find()) {
			throw new MissingValueException("No value for " + m.group());
		}
	}
}
