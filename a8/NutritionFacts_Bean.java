/**
 *	G 01066284 Valeria L Green (VG)
 *	G 00402127 Jorge L Martinez (JM) 
 *	G 01082586 Blake Khan (BK)
 */

// JavaBeans Pattern - allows inconsistency, mandates mutability
public class NutritionFacts_Bean {

    // Fields initialized to default values (if any)
    private int servingSize = -1; // Required; no default value
    private int servings = -1; // Required; no default value
    private int calories = 0;
    private int fat = 0;
    private int sodium = 0;
    private int carbohydrate = 0;
    private int protein = 0; // Additional field for this assignment. (g/grams of protein per serving)

    /**
     * Sets the serving size to a specified value.
     *
     * @param val the value to set as the serving size
     */
    public void setServingSize(int val) {
        this.servingSize = val;
    }

    /**
     * Sets the number of servings to a specified value.
     *
     * @param val the value to set as the number of servings
     */
    public void setServings(int val) {
        this.servings = val;
    }

    /**
     * Sets the calories to a specified value.
     *
     * @param val the value to set as the calories
     */
    public void setCalories(int val) {
        this.calories = val;
    }

    /**
     * Sets the fat to a specified value.
     *
     * @param val the value to set as the fat
     */
    public void setFat(int val) {
        this.fat = val;
    }

    /**
     * Sets the sodium to a specified value.
     *
     * @param val the value to set as the sodium
     */
    public void setSodium(int val) {
        this.sodium = val;
    }

    /**
     * Sets the carbohydrates to a specified value.
     *
     * @param val the value to set as the carbohydrates
     */
    public void setCarbohydrate(int val) {
        this.carbohydrate = val;
    }

    /**
     * Sets the protein to a specified value.
     *
     * @param val the value to set as the protein
     */
    public void setProtein(int val) {
        this.protein = val;
    }

    /**
     * Retrieves the serving size.
     *
     * @return serving size
     * @throws IllegalAccessException if serving size was not set
     */
    public int getServingSize() throws IllegalAccessException {
        if (this.servingSize == -1) {
            throw new IllegalAccessException("Cannot access serving size before it is set");
        }

        return this.servingSize;
    }

    /**
     * Retrieves the number of servings.
     *
     * @return number of servings
     * @throws IllegalAccessException if servings was not set
     */
    public int getServings() throws IllegalAccessException {
        if (this.servings == -1) {
            throw new IllegalAccessException("Cannot access servings before it is set");
        }

        return this.servings;
    }
}
