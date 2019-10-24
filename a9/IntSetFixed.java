import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IntSetFixed implements Cloneable {  
   private List<Integer> els;
   public IntSetFixed () { els = new ArrayList<Integer>(); }
   //...
   @Override 
   public boolean equals(Object obj) {  // Standard recipe
      if (!(obj instanceof IntSetFixed)) return false;

      IntSetFixed s = (IntSetFixed) obj;
      return compare_size_and_elements(s);
   }


   // adding a private constructor
   private IntSetFixed (List<Integer> list) { els = list; }

   @Override 
   public IntSetFixed clone() { 
      return new IntSetFixed ( new ArrayList<Integer>(els));
   }
   
   private boolean compare_size_and_elements(IntSetFixed s) {
	   
	   //check the size
	   if (s.els.size() != this.els.size())
		   	return false;
	   //now proceed to check for the presence of each element in the target object
	   Iterator<Integer> litr = s.els.listIterator(s.els.size());
	
	   
	   while (litr.hasNext()) {
		   int t = litr.next();
		   boolean found = false;
		   for (int i : this.els) {  
			   if (t == i) {found = true; break; } 
		   }//end for
		   //if not found @ this point return false since its not present
		   if (found ==false)   return false;	   
		}//end while
	   //from here down the entire list was search and 
	   //the method should have returned false if any element was absent 
	   //or if the sizes were different.
	   //so at this point in execution both sizes are equal 
	   //and each element is present which means the sets are equal
	   return true ;
   }
   
// @Override 
// public int hashCode() { 
//    // see below 
// }

}
