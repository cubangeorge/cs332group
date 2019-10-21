// Builder Pattern
public class NutritionFacts_Builder {

    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;
    private final int protein; // (g/grams of protein per serving)

    /**
     * Builder class for {@link NutritionFacts_Builder}.
     */
    public static class Builder {
        // Required fields
        private final int servingSize;
        private final int servings;

        // Optional fields
        private int calories;
        private int fat;
        private int sodium;
        private int carbohydrate;
        private int protein; // Additional field for this assignment

        /**
         * Creates a {@link NutritionFacts_Builder.Builder} instance.
         *
         * @param servingSize the serving size
         * @param servings    the number of servings
         */
        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        /**
         * Sets calories to the provided value.
         *
         * @param val the value to set as the calories
         * @return this modified builder
         */
        public Builder calories(int val) {
            calories = val;
            return this;
        }

        /**
         * Sets fat to the provided value.
         *
         * @param val the value to set as the fat
         * @return this modified builder
         */
        public Builder fat(int val) {
            fat = val;
            return this;
        }

        /**
         * Sets sodium to the provided value.
         *
         * @param val the value to set as the sodium
         * @return this modified builder
         */
        public Builder sodium(int val) {
            sodium = val;
            return this;
        }

        /**
         * Sets carbohydrates to the provided value.
         *
         * @param val the value to set as the carbohydrates
         * @return this modified builder
         */
        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }

        /**
         * Sets protein to the provided value.
         *
         * @param val the value to set as the protein
         * @return this modified builder
         */
        public Builder protein(int val) {
            protein = val;
            return this;
        }

        /**
         * Creates an instance of {@link NutritionFacts_Builder} with this builder's attributes.
         *
         * @return new nutritionfacts_builder
         */
        public NutritionFacts_Builder build() {
            return new NutritionFacts_Builder(this);
        }
    }

    /**
     * Creates a new instance of {@link NutritionFacts_Builder} from a provided {@link NutritionFacts_Builder.Builder}.
     *
     * @param builder the builder to create the instance from
     */
    private NutritionFacts_Builder(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
        protein = builder.protein;
    }
}
