import java.util.ArrayList;
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
	   
	   
	   return  ;
   }
   
// @Override 
// public int hashCode() { 
//    // see below 
// }

}
