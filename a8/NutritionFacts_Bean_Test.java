/**
 *	G 01066284 Valeria L Green (VG)
 *	G 00402127 Jorge L Martinez (JM) 
 *	G 01082586 Blake Khan (BK)
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;

public class NutritionFacts_Bean_Test {
	
	/**
	 * Test method for the class {@link NutritionFacts_Bean}.
	 * This tests whether an exception is thrown from accessing a field before initialization is complete. It expects an exception to be thrown.
	 */
	@Test
	void testGetServingSize() {
		NutritionFacts_Bean setter1 = new NutritionFacts_Bean();

		setter1.setCalories(2);
		setter1.setFat(5);
		setter1.setSodium(6);
		setter1.setCarbohydrate(6);
		setter1.setProtein(3);

		try {
			setter1.getServingSize();
			fail("expected exception didn't happen");
		} catch (IllegalAccessException e) {
			System.err.println("error " + e);
		}

	}

	/**
	 * Test method for the class {@link NutritionFacts_Bean}.
	 * This tests whether an exception is thrown from accessing a field before initialization is complete. It expects an exception to be thrown.
	 */
	@Test
	void testGetServings() {
		NutritionFacts_Bean setter1 = new NutritionFacts_Bean();

		setter1.setCalories(2);
		setter1.setFat(5);
		setter1.setSodium(6);
		setter1.setCarbohydrate(6);
		setter1.setProtein(3);

		try {
			setter1.getServings();
			fail("expected exception didn't happen");
		} catch (IllegalAccessException e) {
			System.err.println("error " + e);
		}
	}

	/**
	 * Test method for the class {@link NutritionFacts_Bean}.
	 * This tests accessing a field after the required initialization is complete. It doesn't expect an exception to be thrown.
	 */
	@Test
	void testSetServingSize() {
		NutritionFacts_Bean setter1 = new NutritionFacts_Bean();

		setter1.setCalories(2);
		setter1.setFat(5);
		setter1.setSodium(6);
		setter1.setCarbohydrate(6);
		setter1.setProtein(3);
		setter1.setServingSize(2);


		try {
			assertEquals(2, setter1.getServingSize());
		} catch (IllegalAccessException e) {
			System.err.println("error " + e);
		}

	}

	/**
	 * Test method for the class {@link NutritionFacts_Bean}.
	 * This tests accessing a field after the required initialization is complete. It doesn't expect an exception to be thrown.
	 */
	@Test
	void testSetServings() {
		NutritionFacts_Bean setter1 = new NutritionFacts_Bean();

		setter1.setCalories(2);
		setter1.setFat(5);
		setter1.setSodium(6);
		setter1.setCarbohydrate(6);
		setter1.setProtein(3);
		setter1.setServings(7);


		try {
			assertEquals(7, setter1.getServings());
		} catch (IllegalAccessException e) {
			System.err.println("error " + e);
		}

	}
}
