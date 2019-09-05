


public class Prime {
	static int firstprime = 2; // used globally in this class

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
		
		if (num < firstprime)
			return 0; 		// stop condition: return a zero since is less than smallest prime

		else if (i > num - 1)
			return 1; 		// stop condition: didn't find divisors other than self and one
		
		else if (num % i == 0)
			return 0; 		// stop condition: return since found a divisor
		

		
		return check_if_prime(num, i + 1); /* Continues recursion */
	}


	/*
	 * @param: int num - the number to check if prime
	 * @return: 0 or 1 - based on if primes in the list have been found
	 *  
	   * OVERVIEW: This return 1 if number is prime zero otherwise. It mainly is the handler for starting the later recursive function and then returning that function's value
	   *      
	    */
	public static int is_prime(int num) {
		/*this return 1 if number is prime zero otherwise*/
		
		return check_if_prime(num, firstprime); /* Initializes recursion */
	}
}