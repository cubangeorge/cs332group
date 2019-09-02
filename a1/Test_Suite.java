import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class Test_Suite {

	@Test
	void test_is_prime() {
		
		assertEquals(1,Prime.is_prime(2));//checking primes 
		assertEquals(1,Prime.is_prime(3));
		assertEquals(1,Prime.is_prime(5));
		assertEquals(1,Prime.is_prime(7));
		assertEquals(1,Prime.is_prime(11));
		
		assertEquals(0,Prime.is_prime(1));//check not primes less than 1st prime 
		assertEquals(0,Prime.is_prime(0));
	
		assertEquals(0,Prime.is_prime(4));//check not primes more than first prime 
		assertEquals(0,Prime.is_prime(6)); 
		assertEquals(0,Prime.is_prime(10)); 
		
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
