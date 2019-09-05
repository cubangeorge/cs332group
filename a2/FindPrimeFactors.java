import java.util.List;
/*
 * 
 * This program looks for the first index where there's a prime factor of the number in the first list.
 * @author Jorge L Martinez & Valeria Green
 * @version 2.0
 * 
 */

public class FindPrimeFactors {

	/*
	 * @param: list a - The list with the bigger numbers that is to be factored into
	 * @param: list b - The list with the smaller numbers which is checked for the first instance of a prime factor
	 * 
	 * @return: int i - index of the first occurence of a prime factor
	 * 
	 * @throws: NullPointerException if either list a or list b are null
	 * @throws: IllegalArgumentException if no prime factor has been found or if the type parameter is wrong
	 * @throws: IndexOutOfBoundsException if the list size is 0 or the sizes between the two lists vary
	 * 
	 * OVERVIEW: This looks at the index of both lists at the same time to find if the value at the lower list is a prime factor of the number at the same index of the upper list. In a while loop, it checks to see if both numbers at the same index has a factor in the other and then checks to see if that smaller number is a prime number.
	 * 
	 	* REQUIRES: a not null; b not null;
	   * There is some index i where b[i] is both prime and a factor of a[i];
	   * The type parameter of the list is of type Integer.
	   * 
	   *           
	   * EFFECTS: return the least index at which b[i] is a prime factor of a[i] E.g. findPrimeFactor ([12, 25, 18, 8], [6, 2, 3, 2]) = 2 (Note: 6 is a factor of 12, but is not prime, and 2 is prime, but is not a factor of 25.  However, 3 is a prime factor of 18. Hence, index "2" is the correct answer.  index "3" is not a possible answer, because the third index is not the least index with the desired property.) Also note that a[] and b[] need not be of the same length.
	    * 
	    */
	public static int findPrimeFactor (List<Integer> a, List<Integer> b) {
		
		if (a == null || b == null) {
			throw new NullPointerException("The lists are null");
		}
		
		int i =0;
		int size_a = a.size();
		int size_b = b.size();
		
		if (size_a == 0 || size_b == 0 || size_a != size_b) {
			throw new IndexOutOfBoundsException("List is empty");
		}
		
		while ((i < size_a  && i < size_b)) {
			
			if (!integerToBoolean(Factor.is_factor(a.get(i), b.get(i))) && integerToBoolean(Prime.is_prime(b.get(i)))) {
					return i;	
			}
			i++;		
		} //end while loop
		//if it gets here no prime factors were found	
		throw new IllegalArgumentException("No found primeFactor");
	}
	

	/*
	 * @param: int i - the number that is checked to see if 0
	 * @return: true or false - returns a true or false based on if the param is zero
	 * 
	 * @throws: IllegalArgumentException if the param is not an integer or if the param is null
	   * 
	   * OVERVIEW: This determines whether the received number is 0 or not
	   * 
	   * REQUIRES: The parameter be an integer and not null
	   * 
	   *           
	   * EFFECTS: Returns true or false depending on if the received int is non zero
	    * 
	    */
	public static boolean integerToBoolean(int i) {
		//returns true when i is anything except zero
		if (i == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	
	
}
