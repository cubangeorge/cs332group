
public class Factor {
	public static int is_factor(int a, int b){
		//this method HAS REVERSE LOGIC!!!!!
		//it will return 0 if b is a factor of a, or return 1 otherwise 
		
		if (a<0) //flip a's sign if negative
			a=a*-1;
		if (b==0) {// this covers my zero edge cases since 0*0 = 0
			
			if (a==0) return 0;
			else return 1;
		} 
		
		if (b>a) return 1 ; // edge case where b is a greater number
		if (b<0 && (a*a<b*b)) return 1; //case (4, -12) b is neg and abs(b)>abs(a)
		return a%b;
				
	}//end is_factor

}
