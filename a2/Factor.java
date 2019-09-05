
public class Factor {
	/*
	 * this method HAS REVERSE LOGIC!!!!!
	 * it will return 0 if b is a factor of a, or return 1 otherwise 
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
