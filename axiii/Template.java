/**
 * @author G 01066284 Valeria L Green (VG)
 * @author G 00402127 Jorge L Martinez (JM) 
 * @author G 01082586 Blake Khan (BK)
 */


public class Template {
	
	private String variableValue;
	
	public Template(String templateText) {
    }

    public void set(String variable, String value) {
    	this.variableValue = value;
    }

    public String evaluate() {
        return "Hello, " + variableValue;
    }
}

