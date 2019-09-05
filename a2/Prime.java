


public class Prime {
	// used globally in this class
	static int firstprime = 2;

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

	/*this return 1 if number is prime zero otherwise*/
	public static int is_prime(int num) {
		
		 /* Initializes recursion */
		return check_if_prime(num, firstprime);
	}
}