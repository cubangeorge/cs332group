package a1_PrimeFactor;

public class Prime {
	static int firstprime = 2; // used globally in this class

	public static int get_if_prime(int num, int i) {
		
		if (num < firstprime)
			return 0; 		// stop condition: return a zero since is less than smallest prime

		else if (i > num - 1)
			return 1; 		// stop condition: didn't find divisors other than self and one
		
		else if (num % i == 0)
			return 0; 		// stop condition: return since found a divisor
		

		
		return get_if_prime(num, i + 1); /* Continues recursion */
	}

	public static int is_prime(int num) {
		return get_if_prime(num, firstprime); /* Initializes recursion */
	}
}