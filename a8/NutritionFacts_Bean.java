// JavaBeans Pattern - allows inconsistency, mandates mutability
public class NutritionFacts_Bean {
    // Parameters initialized to default values (if any)
    private int servingSize  = -1; // Required; no default value
    private int servings     = -1; // Required; no default value
    private int calories     = 0;
    private int fat          = 0;
    private int sodium       = 0;
    private int carbohydrate = 0;
    private int protein = 0; 		// (g/grams of protein per serving)     optional


    public NutritionFacts_Bean() { }
    // Setters
    public void setServingSize(int val)  { servingSize = val; }
    public void setServings(int val)    { servings = val; }
    public void setCalories(int val)    { calories = val; }
    public void setFat(int val)         { fat = val; }
    public void setSodium(int val)      { sodium = val; }
    public void setCarbohydrate(int val) { carbohydrate = val; }
    public void setProtein(int val) { protein = val; }
    
    public int getServingSize() throws IllegalAccessException  { 
    	if (this.servingSize == -1) {
    		throw new IllegalAccessException("Cannot access it before it is set");
    	}
    	return servingSize; 
    }
    
    public int getServings() throws IllegalAccessException { 
     	if (this.servingSize == -1) {
    		throw new IllegalAccessException("Cannot access it before it is set");
    	}
    	return servings; 
    }
}
