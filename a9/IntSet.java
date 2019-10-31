import java.util.ArrayList;
import java.util.List;
/**
 * @author G 01066284 Valeria L Green (VG)
 * @author G 00402127 Jorge L Martinez (JM) 
 * @author G 01082586 Blake Khan (BK)
 **/
public class IntSet implements Cloneable {  
	// Fields --------------------------------
	private List<Integer> els;
	   
	  // Constructors --------------------------
	
	   public IntSet () { 
		   els = new ArrayList<Integer>(); 
	   }
	   
	   // Methods ------------------------------
	   
	   /**
	    * Clones the object by calling the constructor and feeding it the current object's list
	    *
	    * @return IntSet The clone that was created
	    */
	   @Override 
	   public IntSet clone() { 
	      return new IntSet ( new ArrayList<Integer>(els));
	   }
	   
	   /**
	    * Determines the equality of the two objects by calling another method to inspect each element
	    *
	    * @param obj The object to compare against
	    * @return boolean Whether the two objects are found to be equal
	    */
	   @Override 
	   public boolean equals(Object obj) {  // Standard recipe
	      if (!(obj instanceof IntSet)) return false;

	      IntSet s = (IntSet) obj;
	      return compare_size_and_elements(s);
	   }

	   private IntSet (List<Integer> list) { els = list; }
	   
	   /**
	    * Adds an integer to the list given it doesn't already contain that integer
	    *
	    * @param e The integer to add to the list
	    * @return int The integer that was added to the list
	    */
	   //adds to the list 
	   public int add(int e) {
		   
		   //ensures no duplicates
		   if (!this.els.contains(e)) {
			   this.els.add(e);
		   }
		   
		   return e;
	   }
	   
	   
	   /**
	    * Sets an item in the list to a specific index
	    *
	    * @param i The key to set an element to
	    * @param v The value for the index
	    * 
	    */
	   public void set(int i, int v) {
		   
		   if (!els.contains(v)) {	   els.set(i, v);}
	   }
	   
	   
	   /**
	    * Returns the string representation of the object's list contents by calling the super class
	    *
	    * @return String The string representation of the object
	    * 
	    */
	   @Override 
	   public String toString() {
		   return this.els.toString();
	   }
	   
	   /**
	    * Does the comparison for the equals method. It inspects each element in the object's list.
	    *
	    * @param s The IntSetFixed object sent in to compare it's contents with
	    * @return boolean Whether or not all the contents in one list are contained in the other
	    * 
	    */  
	   private boolean compare_size_and_elements(IntSet s) {
		   
		   //check the size
		   if (s.els.size() != this.els.size())
			   	return false;
		   //now proceed to check for the presence of each element in the target object
		   
		   for (Integer i : s.els) {
			   if(!this.els.contains(i))
				   return false;
		   }
		   return true;
	   }

   
}
