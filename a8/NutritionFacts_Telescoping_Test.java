/**
 *	G 01066284 Valeria L Green (VG)
 *	G 00402127 Jorge L Martinez (JM) 
 *	G 01082586 Blake Khan (BK)
 */


import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class NutritionFacts_Telescoping_Test {
	//just the servingSize and servings values are specified
	static NutritionFacts_Telescoping setter2 = new NutritionFacts_Telescoping(7, 1);
	
	//just the servingSize, servings, calories values are specified
	static NutritionFacts_Telescoping setter3 = new NutritionFacts_Telescoping(6, 2, 89);
	
	//just the servingSize, servings, calories, fat values are specified
	static NutritionFacts_Telescoping setter4 = new NutritionFacts_Telescoping(9, 45, 72, 45);
	
	//just the servingSize, servings, calories, fat, sodium values are specified
	static NutritionFacts_Telescoping setter5 = new NutritionFacts_Telescoping(79, 34, 52, 53, 12);
	
	//just the servingSize, servings, calories, fat, carbohydrate values are specified
	static NutritionFacts_Telescoping setter6 = new NutritionFacts_Telescoping(81, 84, 47, 9, 76, 94);
	
	//all fields values are specified
	static NutritionFacts_Telescoping setter7 = new NutritionFacts_Telescoping(82, 58, 38, 67, 13, 18, 90);
	
	/**
	 * Test method for the class {@link NutritionFacts_Telescoping}.
	 * This tests if the serving size field is defined in all the objects
	 */
	@Test
	void testGetServingSize() {
		assertEquals(7, setter2.getServingSize());
		assertEquals(6, setter3.getServingSize());
		assertEquals(9, setter4.getServingSize());
		assertEquals(79, setter5.getServingSize());
		assertEquals(81, setter6.getServingSize());
		assertEquals(82, setter7.getServingSize());
	}

	/**
	 * Test method for the class {@link NutritionFacts_Telescoping}.
	 * This tests if the servings field is defined in all the objects
	 */
	@Test
    void testGetServings() {
		
		assertEquals(1, setter2.getServings());
		assertEquals(2, setter3.getServings());
		assertEquals(45, setter4.getServings());
		assertEquals(34, setter5.getServings());
		assertEquals(84, setter6.getServings());
		assertEquals(58, setter7.getServings());
	}
    
	/**
	 * Test method for the class {@link NutritionFacts_Telescoping}.
	 * This tests if the calories field is undefined in some object(s) based of how many parameters are defined in the constructor
	 */
	@Test
    void testGetCalories() {	
		assertEquals(0, setter2.getCalories());
		
		assertEquals(89, setter3.getCalories());
		assertEquals(72, setter4.getCalories());
		assertEquals(52, setter5.getCalories());
		assertEquals(47, setter6.getCalories());
		assertEquals(38, setter7.getCalories());
	}
	
	/**
	 * Test method for the class {@link NutritionFacts_Telescoping}.
	 * This tests if the fat field is undefined in some object(s) based of how many parameters are defined in the constructor
	 */
	@Test
    void testGetFat() {

		assertEquals(0, setter2.getFat());
		assertEquals(0, setter3.getFat());
		
		assertEquals(45, setter4.getFat());
		assertEquals(53, setter5.getFat());
		assertEquals(9, setter6.getFat());
		assertEquals(67, setter7.getFat());
	}
	
	/**
	 * Test method for the class {@link NutritionFacts_Telescoping}.
	 * This tests if the sodium field is undefined in some object(s) based of how many parameters are defined in the constructor
	 */
	@Test
    void testGetSodium() {

		assertEquals(0, setter2.getSodium());
		assertEquals(0, setter3.getSodium());
		assertEquals(0, setter4.getSodium());
		
		assertEquals(12, setter5.getSodium());
		assertEquals(76, setter6.getSodium());
		assertEquals(13, setter7.getSodium());
	}
	
	/**
	 * Test method for the class {@link NutritionFacts_Telescoping}.
	 * This tests if the carbohydrate field is undefined in some object(s) based of how many parameters are defined in the constructor
	 */
	@Test
    void testGetCarbohydrate() {
		
		assertEquals(0, setter2.getCarbohydrate());
		assertEquals(0, setter3.getCarbohydrate());
		assertEquals(0, setter4.getCarbohydrate());
		assertEquals(0, setter5.getCarbohydrate());
		
		
		assertEquals(94, setter6.getCarbohydrate());
		assertEquals(18, setter7.getCarbohydrate());
	}
	
	/**
	 * Test method for the class {@link NutritionFacts_Telescoping}.
	 * This tests if the protein field is undefined in some object(s) based of how many parameters are defined in the constructor
	 */
	@Test
    void testGetProtein() {
		
		assertEquals(0, setter2.getProtein());
		assertEquals(0, setter3.getProtein());
		assertEquals(0, setter4.getProtein());
		assertEquals(0, setter5.getProtein());
		assertEquals(0, setter6.getProtein());
		
		assertEquals(90, setter7.getProtein());
	}
	

}
