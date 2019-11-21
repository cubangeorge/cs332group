import java.util.HashMap;
import java.util.Map;

/**
 * @author G 01066284 Valeria L Green (VG)
 * @author G 00402127 Jorge L Martinez (JM) 
 * @author G 01082586 Blake Khan (BK)
 */


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
        return null;
        
    }
}

