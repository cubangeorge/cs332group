/**
 *	G 01066284 Valeria L Green (VG)
 *	G 00402127 Jorge L Martinez (JM) 
 *	G 01082586 Blake Khan (BK)
 */


import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class NutritionFacts_Builder_Test {
	//everything is set
	static NutritionFacts_Builder setter1 = new NutritionFacts_Builder.Builder(5, 4).calories(900).sodium(800).carbohydrate(60).fat(80).protein(45).build();
	
	//not every field is set
	static NutritionFacts_Builder setter2 = new NutritionFacts_Builder.Builder(5, 4).sodium(800).carbohydrate(60).fat(80).protein(45).build();
	static NutritionFacts_Builder setter3 = new NutritionFacts_Builder.Builder(5, 4).calories(900).carbohydrate(60).fat(80).protein(45).build();
	static NutritionFacts_Builder setter4 = new NutritionFacts_Builder.Builder(5, 4).calories(900).sodium(800).carbohydrate(60).protein(45).build();
	static NutritionFacts_Builder setter5 = new NutritionFacts_Builder.Builder(5, 4).calories(900).sodium(800).fat(80).protein(45).build();
	static NutritionFacts_Builder setter6 = new NutritionFacts_Builder.Builder(5, 4).calories(900).sodium(800).carbohydrate(60).fat(80).build();
	
	/**
	 * Test method for the class {@link NutritionFacts_Builder}.
	 * This tests if one of the two required fields are set
	 */
	@Test
	void testGetServingSize() {assertEquals(5, setter1.getServingSize());}

	/**
	 * Test method for the class {@link NutritionFacts_Builder}.
	 * This tests if one of the two required fields are set
	 */
	@Test
    void testGetServings() {assertEquals(4, setter1.getServings());}
    
	/**
	 * Test method for the class {@link NutritionFacts_Builder}.
	 * This tests if a certain field will default to zero if not set with the builder.
	 */
	@Test
    void testGetCalories() {
		//object where all fields are set
		assertEquals(900, setter1.getCalories());
		
		//object where not all fields are set
		assertEquals(800, setter2.getSodium());
		assertEquals(60, setter2.getCarbohydrate());
		assertEquals(80, setter2.getFat());
		assertEquals(45, setter2.getProtein());
		
		assertEquals(0, setter2.getCalories());
	}
	
	/**
	 * Test method for the class {@link NutritionFacts_Builder}.
	 * This tests if a certain field will default to zero if not set with the builder.
	 */
	@Test
    void testGetSodium() {
		//object where all fields are set
		assertEquals(800, setter1.getSodium());
		
		//object where not all fields are set
		assertEquals(60, setter3.getCarbohydrate());
		assertEquals(80, setter3.getFat());
		assertEquals(45, setter3.getProtein());
		assertEquals(900, setter3.getCalories());
		
		assertEquals(0, setter3.getSodium());
	}
	
	
	/**
	 * Test method for the class {@link NutritionFacts_Builder}.
	 * This tests if a certain field will default to zero if not set with the builder.
	 */
	@Test
    void testGetFat() {
		//object where all fields are set
		assertEquals(80, setter1.getFat());
		
		//object where not all fields are set
		assertEquals(800, setter4.getSodium());
		assertEquals(60, setter4.getCarbohydrate());
		assertEquals(45, setter4.getProtein());
		assertEquals(900, setter4.getCalories());
		
		assertEquals(0, setter4.getFat());
	}
	
	/**
	 * Test method for the class {@link NutritionFacts_Builder}.
	 * This tests if a certain field will default to zero if not set with the builder.
	 */
	@Test
    void testGetCarbohydrate() {
		//object where all fields are set
		assertEquals(60, setter1.getCarbohydrate());
		
		//object where not all fields are set
		assertEquals(800, setter5.getSodium());
		assertEquals(80, setter5.getFat());
		assertEquals(45, setter5.getProtein());
		assertEquals(900, setter5.getCalories());
		
		assertEquals(0, setter5.getCarbohydrate());
	}
	
	/**
	 * Test method for the class {@link NutritionFacts_Builder}.
	 * This tests if a certain field will default to zero if not set with the builder.
	 */
	@Test
    void testGetProtein() {
		//object where all fields are set
		assertEquals(45, setter1.getProtein());
		
		//object where not all fields are set
		assertEquals(800, setter6.getSodium());
		assertEquals(60, setter6.getCarbohydrate());
		assertEquals(80, setter6.getFat());
		assertEquals(900, setter6.getCalories());
		
		assertEquals(0, setter6.getProtein());
	}
	

}
