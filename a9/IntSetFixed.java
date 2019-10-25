import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IntSetFixed implements Cloneable {  
   private List<Integer> els;
   
   
   public IntSetFixed () { 
	   els = new ArrayList<Integer>(); 
   }
   
   //...
   @Override 
   public boolean equals(Object obj) {  // Standard recipe
      if (!(obj instanceof IntSetFixed)) return false;

      IntSetFixed s = (IntSetFixed) obj;
      return compare_size_and_elements(s);
   }


   // adding a private constructor
   private IntSetFixed (List<Integer> list) { els = list; }
   
   //adds to the list 
   public int add(int e) {
	   
	   //ensures no duplicates
	   if (!els.contains(e)) {
		   els.add(e);
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
   public IntSetFixed clone() throws CloneNotSupportedException {
	   
	  //do a super.clone
	  //iterate through clone and update references to new instances
	  //make it point to the integers of that structure

	   IntSetFixed cloned = (IntSetFixed) super.clone();
	   cloned.els = new ArrayList<Integer>(); 
	   
	   //inside for loop, initialize each element in clone using a integer constructor which will create an object based off an integer
	   for (Integer i: this.els) {
		   Integer newItem = i.intValue();
		   cloned.add(newItem);
	   }
	   
	
	   return cloned;

   }
   
//   //return the size of els
//   public int size() {
//	   return els.size();
//   }
   
   @Override 
   public String toString() {
	   return this.els.toString();
   }
   
       
   //does the comparison for the equals method
   private boolean compare_size_and_elements(IntSetFixed s) {
	   
	   //check the size
	   if (s.els.size() != this.els.size())
		   	return false;
	   //now proceed to check for the presence of each element in the target object
	  // Iterator<Integer> litr = s.els.listIterator(s.size());
	   
	   //check its not empty
	   //if (!litr.hasNext()) return false;
	   
	   for (Integer i : s.els) {
		   if(!this.els.contains(i))
			   return false;
	   }
	   return true;
//	   while (litr.hasNext()) {
//		   int t = litr.next();
//		   boolean found = false;
//		   for (int i : this.els) {  
//			   if (t == i) {found = true; break; } 
//		   }//end for
//		   //if not found @ this point return false since its not present
//		   if (found ==false)   return false;	   
//		}//end while
//	   //from here down the entire list was search and 
//	   //the method should have returned false if any element was absent 
//	   //or if the sizes were different.
//	   //so at this point in execution both sizes are equal 
//	   //and each element is present which means the sets are equal
//	   return true ;
   }
   
// @Override 
// public int hashCode() { 
//    // see below 
// }

}
