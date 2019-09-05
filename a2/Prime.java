


public class Prime {
	// used globally in this class
	static int firstprime = 2;

	/*
	 * @param: int num - the number to check if prime
	 * @param: int i - the very first possible prime to compare against
	 * @return: 0 or 1 - based on if primes in the list have been found
	 *  
	   * OVERVIEW: This determines whether the received number is prime or not in a recursive style. No preconditions because it can handle any input number as it will default to zero if it's a bad number.
	   *      
	    * 
	    */
	public static int check_if_prime(int num, int i) {
		
		// stop condition: return a zero since is less than smallest prime
		if (num < firstprime)
			return 0; 		
		
		// stop condition: didn't find divisors other than self and one
		else if (i > num - 1)
			return 1; 		
		
		// stop condition: return since found a divisor
		else if (num % i == 0)
			return 0; 		
		
		/* Continues recursion */
		return check_if_prime(num, i + 1); 
	}

	/*
	 * @param: int num - the number to check if prime
	 * @return: 0 or 1 - based on if primes in the list have been found
	 *  
	   * OVERVIEW: This return 1 if number is prime zero otherwise. It mainly is the handler for starting the later recursive function and then returning that function's value
	   *      
	    */
	public static int is_prime(int num) {
		
		 /* Initializes recursion */
		return check_if_prime(num, firstprime);
	}
}