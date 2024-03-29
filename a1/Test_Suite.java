import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;


class Test_Suite {
	
	
	//test data arrays for more comprehensive testing
	public static int[] nonPrimes = new int[] {0, 1, 4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20, 21, 22, 24, 25, 26, 27, 28, 30, 32, 33, 34, 35, 36, 38, 39, 40, 42, 44, 45, 46, 48, 49, 50, 51, 52, 54, 55, 56, 57, 58, 60, 62, 63 };
	
	public static int[] primes = new int[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};

	public static int[] compositeNumbers = new int[] {4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20, 21, 22, 24, 25, 26, 27, 28, 30, 32, 33, 34, 35, 36, 38, 39, 40, 42, 44, 45, 46, 48, 49, 50, 51, 52, 54, 55, 56, 57, 58, 60, 62, 63, 64, 65, 66, 68, 69, 70, 72, 74, 75, 76, 77, 78, 80, 81, 82, 84, 85, 86, 87, 88, 90, 91, 92, 93, 94, 95, 96, 98, 99, 100};
	
	
	
	@Test
	void test_is_prime() {
		
		assertEquals(0,Prime.is_prime(1));//check not primes less than 1st prime 
		assertEquals(0,Prime.is_prime(0));
	
		for (int i = 0; i < nonPrimes.length; i++) {	
				assertEquals(0, Prime.is_prime(nonPrimes[i]));	
		}
		
		
		for (int i = 0; i < primes.length; i++) {
			assertEquals(1, Prime.is_prime(primes[i]));
		}
		
	}

	@Test
	void test_is_factor() {
	
		assertEquals(0,Factor.is_factor(0, 0)); //0*0 =0
		assertEquals(1,Factor.is_factor(4, 0));	//0*anything = 0
		assertEquals(0,Factor.is_factor(4, 1)); //1*4 = 4
		assertEquals(0,Factor.is_factor(4, 4));	//4*1 = 4
		assertEquals(0,Factor.is_factor(4, 2));
		assertEquals(0,Factor.is_factor(4, -2));
		assertEquals(0,Factor.is_factor(4, -4));
		assertEquals(0,Factor.is_factor(4, -1));
		assertEquals(0,Factor.is_factor(4, 2));
		assertEquals(1,Factor.is_factor(4, 3));
		assertEquals(1,Factor.is_factor(4, 6));
		assertEquals(1,Factor.is_factor(4, 8));
		assertEquals(1,Factor.is_factor(3, -12));
		assertEquals(0,Factor.is_factor(3, -3));
		assertEquals(1,Factor.is_factor(3, -5));

		//cases with a negative "a" variable 
		assertEquals(1,Factor.is_factor(-1, 0));//zero times anything is always zero 
		assertEquals(0,Factor.is_factor(-0, 0));//zero times anything is always zero 
		assertEquals(0,Factor.is_factor(-4, 2)); //2*-2 =-4  
		assertEquals(0,Factor.is_factor(-4, -2)); //2*-2 =-4  
		assertEquals(1,Factor.is_factor(-4, -6));   
		assertEquals(1,Factor.is_factor(-4, 6));   
		assertEquals(1,Factor.is_factor(-4, -8)); //8*-.5 =-4  
		assertEquals(1,Factor.is_factor(-4, 8)); //8*.5 =-4  
		
		
		for (int j = 0; j < compositeNumbers.length; j++) {
			for (int i = 1; i < compositeNumbers.length; i++) {
			
				if (compositeNumbers[j] % i == 0) {
					assertEquals(0,Factor.is_factor(compositeNumbers[j], i));				
				}
				
				if ((-1 * compositeNumbers[j]) % (-1* i) == 0) {
					assertEquals(0,Factor.is_factor(compositeNumbers[j], i));
				}	
				
			}
		}
		
		
	}
	
	@Test 
	void test_integerToBoolean(){
		
		assertEquals(true, FindPrimeFactors.integerToBoolean(1));
		assertEquals(false, FindPrimeFactors.integerToBoolean(0));
		assertEquals(true, FindPrimeFactors.integerToBoolean(4));
		assertEquals(true, FindPrimeFactors.integerToBoolean(-1));
	}//end test
	
	@Test
	void test_fPF_1() {
		//here the first number is a prime factor 
		List<Integer> a = Arrays.asList(12,24,3  ,4 ,5);
		List<Integer> b = Arrays.asList(3 ,2 ,16 ,1 ,5); //list with pf @ 0
		assertEquals(0,FindPrimeFactors.findPrimeFactor(a, b));
		
	}//end test
	
	@Test
	void test_fPF_2() {
		//here the last number is a prime factor 
		List<Integer> a = Arrays.asList(5 ,23,3  ,34 ,25);
		List<Integer> b = Arrays.asList(3 ,2 ,16 ,12  ,5); //list with pf @ 4
		assertEquals(4,FindPrimeFactors.findPrimeFactor(a, b));
		
	}//end test
	
	@Test
	void test_fPF_3() {
		//here the middle index number is a prime factor 
		List<Integer> a = Arrays.asList(5 ,23,25,34 ,24);
		List<Integer> b = Arrays.asList(3 ,2 ,5 ,12  ,5); //list with pf @ 2
		assertEquals(2,FindPrimeFactors.findPrimeFactor(a, b));
	}//end test
	@Test
	void test_fPF_4() {
		//here the middle index number and last are a prime factor 
		List<Integer> a = Arrays.asList(5 ,23,25,34 ,25);
		List<Integer> b = Arrays.asList(3 ,2 ,5 ,12  ,5); //list with pf @ 2
		assertEquals(2,FindPrimeFactors.findPrimeFactor(a, b));
	}//end test
	
	@Test
	void test_fPF_5() {
		//here no prime factor 
		List<Integer> a = Arrays.asList(5 ,23,66,34 ,23);
		List<Integer> b = Arrays.asList(3 ,2 ,5 ,12  ,5); //list with pf @ -1
		assertEquals(-1,FindPrimeFactors.findPrimeFactor(a, b));
	}//end test
	
}
