import java.util.List;

public class FindPrimeFactors {

	// Requires: a not null; b not null;
	   //           there is some index i where b[i] is 
	   //           both prime and a factor of a[i]
	   //           
	   // Effects: return the least index
	   //          at which b[i] is a prime factor of a[i]
	   // E.g. findPrimeFactor ([12, 25, 18, 8], [6, 2, 3, 2]) = 2
	   // (Note: 6 is a factor of 12, but is not prime,
	   //  and 2 is prime, but is not a factor of 25.  However,
	   //  3 is a prime factor of 18. Hence, index "2" is the correct
	   //  answer.  index "3" is not a possible answer, because the
	   //  third index is not the least index with the desired property.)
	   // Also note that a[] and b[] need not be of the same length.
	public static int findPrimeFactor (List<Integer> a, List<Integer> b) {

		int i =0;
		int size_a = a.size();
		int size_b = b.size();
		/* @TODO: validate empty list here
		*
		*
		*/
		while ((i < size_a  && i < size_b)) {
			
			if (!integerToBoolean(Factor.is_factor(a.get(i), b.get(i))) && integerToBoolean(Prime.is_prime(b.get(i)))) {
					return i;	
			}
			i++;		
		} //end while loop
		//if it gets here no prime factors were found	
		return -1;
	}
	
	public static boolean integerToBoolean(int i) {
		//returns true when i is anything except zero
		if (i == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	
	
}