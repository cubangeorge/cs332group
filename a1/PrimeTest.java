package a1_PrimeFactor;


import static org.junit.jupiter.api.Assertions.*;

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

}
