/**
 *	G 01066284 Valeria L Green (VG)
 *	G 00402127 Jorge L Martinez (JM) 
 *	G 01082586 Blake Khan (BK)
 */


// Telescoping constructor pattern - does not scale well!
public class NutritionFacts_Telescoping {

    private final int servingSize;  // (mL)            required
    private final int servings;     // (per container) required
    private final int calories;     // (per serving)   optional
    private final int fat;          // (g/serving)     optional
    private final int sodium;       // (mg/serving)    optional
    private final int carbohydrate; // (g/serving)     optional
    private final int protein;        // (g/grams of protein per serving)     optional

    /**
     * Creates a new instance of {@link NutritionFacts_Telescoping} with 0 calories, fat, sodium, carbohydrates, and protein.
     *
     * @param servingSize the serving size
     * @param servings    the number of servings
     */
    public NutritionFacts_Telescoping(int servingSize, int servings) {
        this(servingSize, servings, 0);
    }

    /**
     * Creates a new instance of {@link NutritionFacts_Telescoping} with 0 fat, sodium, carbohydrates, and protein.
     *
     * @param servingSize the serving size
     * @param servings    the number of servings
     * @param calories    the number of calories
     */
    public NutritionFacts_Telescoping(int servingSize, int servings, int calories) {
        this(servingSize, servings, calories, 0);
    }

    /**
     * Creates a new instance of {@link NutritionFacts_Telescoping} with 0 sodium, carbohydrates, and protein.
     *
     * @param servingSize the serving size
     * @param servings    the number of servings
     * @param calories    the number of calories
     * @param fat         the amount of fat
     */
    public NutritionFacts_Telescoping(int servingSize, int servings, int calories, int fat) {
        this(servingSize, servings, calories, fat, 0);
    }

    /**
     * Creates a new instance of {@link NutritionFacts_Telescoping} with 0 carbohydrates and protein.
     *
     * @param servingSize the serving size
     * @param servings    the number of servings
     * @param calories    the number of calories
     * @param fat         the amount of fat
     * @param sodium      the amount of sodium
     */
    public NutritionFacts_Telescoping(int servingSize, int servings, int calories, int fat, int sodium) {
        this(servingSize, servings, calories, fat, sodium, 0);
    }

    /**
     * Creates a new instance of {@link NutritionFacts_Telescoping} with 0 protein.
     *
     * @param servingSize  the serving size
     * @param servings     the number of servings
     * @param calories     the number of calories
     * @param fat          the amount of fat
     * @param sodium       the amount of sodium
     * @param carbohydrate the amount of carbohydrates
     */
    public NutritionFacts_Telescoping(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
        this(servingSize, servings, calories, fat, sodium, carbohydrate, 0);
    }

    /**
     * Creates a new instance of {@link NutritionFacts_Telescoping}.
     *
     * @param servingSize  the serving size
     * @param servings     the number of servings
     * @param calories     the number of calories
     * @param fat          the amount of fat
     * @param sodium       the amount of sodium
     * @param carbohydrate the amount of carbohydrates
     * @param protein      the amount of protein
     */
    public NutritionFacts_Telescoping(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate, int protein) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
        this.protein = protein;   //extra parameter for this assignment
    }
    
     
    /**
     * Retrieves the serving size.
     *
     * @return serving size
     */
    public int getServingSize() {return this.servingSize;}

    /**
     * Retrieves the number of servings.
     *
     * @return number of servings
     */
    public int getServings() {return this.servings;}
    
    /**
     * Retrieves the calorie number.
     *
     * @return calorie number
     */
    public int getCalories() {return this.calories;}
    
    /**
     * Retrieves the fat count
     *
     * @return the fat count
     */
    public int getFat() {return this.fat;}
    
    /**
     * Retrieves the sodium count
     *
     * @return the sodium count
     */
    public int getSodium() {return this.sodium;}
    
    /**
     * Retrieves the carbohydrate count
     *
     * @return the carbohydrate count
     */
    public int getCarbohydrate() {return this.carbohydrate;}
    
    
    /**
     * Retrieves the protein count
     *
     * @return the protein count
     */
    public int getProtein() {return this.protein;}
    
}
