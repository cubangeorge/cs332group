import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;

public class NutritionFacts_Bean_Test {

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
