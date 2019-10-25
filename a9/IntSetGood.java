import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IntSetGood implements Cloneable {  
   private List<Integer> els;
   
   
   public IntSetGood () { 
	   els = new ArrayList<Integer>(); 
   }
   
   //...
   @Override 
   public boolean equals(Object obj) {  // Standard recipe
      if (!(obj instanceof IntSetGood)) return false;

      IntSetGood s = (IntSetGood) obj;
      return compare_size_and_elements(s);
   }

   private IntSetGood (List<Integer> list) { els = list; }
   
   //adds to the list 
   public int add(int e) {
	   
	   //ensures no duplicates
	   if (!this.els.contains(e)) {
		   this.els.add(e);
	   }
	   
	   return e;
   }
   
   //sets the index to the value 
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
   public IntSetGood clone() throws CloneNotSupportedException {
	   
	  //do a super.clone
	  //make deep copies
	   IntSetGood cloned = (IntSetGood) super.clone();
	   //make deep copies
	   cloned.els = new ArrayList<Integer>(cloned.els); 
	   
	  return cloned;
   }
   
   @Override 
   public String toString() {
	   return this.els.toString();
   }
   
       
   //does the comparison for the equals method
   private boolean compare_size_and_elements(IntSetGood s) {
	   
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
   
// @Override 
// public int hashCode() { 
//    // see below 
// }

}
