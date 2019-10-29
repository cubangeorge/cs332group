/**
 * @author G 01066284 Valeria L Green (VG)
 * @author G 00402127 Jorge L Martinez (JM) 
 * @author G 01082586 Blake Khan (BK)
 **/
public class NegativeIntSet extends IntSetFixed {
	//this class stores only negative integers 
	// if given a positive number it will add 
	//its negative 
	public NegativeIntSet() {
		super();	//make an empty intSetGood list
	}
		
	//adds negative numbers to the list
	public int add(int i) {
		
		return(i > 0)?super.add(i*-1):super.add(i);
		
	}

}
