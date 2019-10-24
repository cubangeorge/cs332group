import java.util.ArrayList;
import java.util.List;

public class IntSet implements Cloneable {  
   private List<Integer> els;
   public IntSet () { els = new ArrayList<Integer>(); }
   //...
   @Override 
   public boolean equals(Object obj) {  // Standard recipe
      if (!(obj instanceof IntSet)) return false;

      IntSet s = (IntSet) obj;
      return compare_size_and_elements(s);
   }


   // adding a private constructor
   private IntSet (List<Integer> list) { els = list; }

   @Override 
   public IntSet clone() { 
      return new IntSet ( new ArrayList<Integer>(els));
   }
   
   private boolean compare_size_and_elements(IntSet s) {
	   
	   //check the size
	   if (s.els.size() != this.els.size())
		   	return false;
	   
	   
	   return true ;
   }
   
// @Override 
// public int hashCode() { 
//    // see below 
// }

}
