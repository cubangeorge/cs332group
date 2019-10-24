import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class NutritionFacts_Builder_Test {
	
	
	static NutritionFacts_Builder setter1 = new NutritionFacts_Builder.Builder(5, 4)
			.calories(900)
			.sodium(800)
			.carbohydrate(60)
			.fat(80)
			.protein(45)
			.build();
	
	static NutritionFacts_Builder nocal = new NutritionFacts_Builder.Builder(5, 4)
			//.calories(900)
			.sodium(800)
			.carbohydrate(60)
			.fat(80)
			.protein(45)
			.build();
	
	static NutritionFacts_Builder nosod = new NutritionFacts_Builder.Builder(5, 4)
			.calories(900)
			//.sodium(800)
			.carbohydrate(60)
			.fat(80)
			.protein(45)
			.build();
	
	static NutritionFacts_Builder nocarb = new NutritionFacts_Builder.Builder(5, 4)
			.calories(900)
			.sodium(800)
			//.carbohydrate(60)
			.fat(80)
			.protein(45)
			.build();
	
	static NutritionFacts_Builder nofat = new NutritionFacts_Builder.Builder(5, 4)
			.calories(900)
			.sodium(800)
			.carbohydrate(60)
			//.fat(80)
			.protein(45)
			.build();
	
	static NutritionFacts_Builder nopro = new NutritionFacts_Builder.Builder(5, 4)
			.calories(900)
			.sodium(800)
			.carbohydrate(60)
			.fat(80)
			//.protein(45)
			.build();
	
	static NutritionFacts_Builder noOptionals = new NutritionFacts_Builder.Builder(5, 4)
			//.calories(900)
			//.sodium(800)
			//.carbohydrate(60)
			//.fat(80)
			//.protein(45)
			.build();
	
	
	
	@Test
	void testnocal() {assertEquals(0, nocal.getCalories()) ;}
	@Test
	void testnosod() {assertEquals(0, nosod.getSodium()) ;}
	@Test
	void testnocarb() {assertEquals(0, nocarb.getCarbohydrate()) ;}
	@Test
	void testnofat() {assertEquals(0, nofat.getFat()) ;}
	@Test
	void testnopro() {assertEquals(0, nopro.getProtein()) ;}
	@Test
	void testnoOptionals() {
		assertEquals(0, noOptionals .getCalories());
		assertEquals(0, noOptionals .getSodium()) ;
		assertEquals(0, noOptionals.getCarbohydrate()) ;
		assertEquals(0, noOptionals .getFat()) ;
		assertEquals(0, noOptionals .getProtein()) ;
		assertEquals(0, noOptionals .getProtein()) ;
		assertEquals(4, noOptionals .getServings()) ;
		assertEquals(5, noOptionals .getServingSize()) ;
		
	}//end not Optionals

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
