import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * @author G 01066284 Valeria L Green (VG)
 * @author G 00402127 Jorge L Martinez (JM) 
 * @author G 01082586 Blake Khan (BK)
 **/
public class IntSetFixed implements Cloneable {  

	// Fields -------------------------------------
	
   private List<Integer> els;
   
   // Constructors -------------------------------------
   
   /**
    * Constructs a new ArrayList for the object
    *
    */
   public IntSetFixed () { 
	   els = new ArrayList<Integer>(); 
   }
   
   // Methods ------------------------------------------------------
   
   /**
    * Determines the equality of two objects by calling another method to do an in depth analysis of equality of the objects inside.
    *
    * @param obj the object to compare
    * @return boolean whether equality is found or not between the two objects
    */
   @Override 
   public boolean equals(Object obj) {  // Standard recipe
      if (!(obj instanceof IntSetFixed)) return false;

      IntSetFixed s = (IntSetFixed) obj;
      return compare_size_and_elements(s);
   }

   private IntSetFixed (List<Integer> list) { els = list; }
   
   /**
    * Adds a new integer to the list of the current object
    *
    * @param e The integer to add to the list
    * @return int The integer that was added to the list successfully
    */
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
    * Clones the IntSetFixed object and does a deep copy of it's list of Integer objects.
    *
    * @return IntSetFixed The successfully cloned object
    * @throws CloneNotSupportedException if object isn't allowed to be cloned
    */
   @Override 
   public IntSetFixed clone() throws CloneNotSupportedException {
	   
	  //do a super.clone
	  //make deep copies
	   IntSetFixed cloned = (IntSetFixed) super.clone();
	   //make deep copies
	   cloned.els = new ArrayList<Integer>(cloned.els); 
	   
	  return cloned;
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
   private boolean compare_size_and_elements(IntSetFixed s) {
	   
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
