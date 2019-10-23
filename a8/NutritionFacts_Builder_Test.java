import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class NutritionFacts_Builder_Test {
	static NutritionFacts_Builder setter1 = new NutritionFacts_Builder.Builder(5, 4).calories(900).sodium(800).carbohydrate(60).fat(80).protein(45).build();

	
	
	@Test
	void testGetServingSize() {assertEquals(5, setter1.getServingSize());}

	@Test
    void testGetServings() {assertEquals(4, setter1.getServings());}
    
	
	@Test
    void testGetCalories() {assertEquals(900, setter1.getCalories());}
	
	
	@Test
    void testGetFat() {assertEquals(80, setter1.getFat());}
	
	@Test
    void testGetSodium() {assertEquals(800, setter1.getSodium());}
	
	
	@Test
    void testGetCarbohydrate() {assertEquals(60, setter1.getCarbohydrate());}
	
	
	@Test
    void testGetProtein() {assertEquals(45, setter1.getProtein());}
	

}
