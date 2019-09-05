
public class Factor {

	/*
	 * @param: int a - the bigger number to find if b is a factor of
	 * @param: int b - the smaller number to see if it is a factor of a
	 * 
	 * @return: it will return 0 if b is a factor of a, or return 1 otherwise 
	 * 
	 * 
	 * OVERVIEW: It uses a series of conditions to handle edge cases before determining if b divides into a with or without a remainder. If so, then it's a factor. This method HAS REVERSE LOGIC!!!!!
	 * 
	   *            
	    * 
	    */
	public static int is_factor(int a, int b){
		
		//flip a's sign if negative
		if (a < 0) { 
			a = (a*-1);
		}
		
		// this covers my zero edge cases since 0*0  = 0
		if (b == 0) {
			if (a == 0) { 
				return 0; 
			} else { 
				return 1;
			}	
		} 
		
		
		
		// edge case where b is a greater number
		if (b > a) { 
			return 1; 
		} 
		//case (4, -12) b is neg and abs(b)>abs(a)
		if ( b < 0 && ( (a * a) < (b * b) ) ) {
			return 1; 
		}
		
		return (a % b);
				
	}//end is_factor

}
