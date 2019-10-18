// Telescoping constructor pattern - does not scale well!
public class NutritionFacts_Telescoping {
    private final int servingSize;  // (mL)            required
    private final int servings;     // (per container) required
    private final int calories;     // (per serving)   optional
    private final int fat;          // (g/serving)     optional
    private final int sodium;       // (mg/serving)    optional
    private final int carbohydrate; // (g/serving)     optional
    private final int protein; 		// (g/grams of protein per serving)     optional

    public NutritionFacts_Telescoping(int servingSize, int servings) {
        this(servingSize, servings, 0);
    }

    public NutritionFacts_Telescoping(int servingSize, int servings, int calories) {
        this(servingSize, servings, calories, 0);
    }

    public NutritionFacts_Telescoping(int servingSize, int servings, int calories, int fat) {
        this(servingSize, servings, calories, fat, 0);
    }

    public NutritionFacts_Telescoping(int servingSize, int servings, int calories, int fat, int sodium) {
        this(servingSize, servings, calories, fat, sodium, 0);
    }
    
    public NutritionFacts_Telescoping(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
    	this(servingSize, servings, calories, fat, sodium, carbohydrate, 0);
    }

    public NutritionFacts_Telescoping(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate, int protein) {
        this.servingSize  = servingSize;
        this.servings     = servings;
        this.calories     = calories;
        this.fat          = fat;
        this.sodium       = sodium;
        this.carbohydrate = carbohydrate;
        this.protein 	  = protein;   //extra parameter for this assingment 
    }
}
