/**
 * @author jorge
 *
 */
public class NegativeIntSet extends IntSetGood {
	//this class stores only megative integers 
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
