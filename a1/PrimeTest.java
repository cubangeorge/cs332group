import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PrimeTest {

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
}
