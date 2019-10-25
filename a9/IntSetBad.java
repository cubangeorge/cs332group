import java.util.ArrayList;
import java.util.List;

public class IntSetBad implements Cloneable {  
   private List<Integer> els;
   public IntSetBad () { els = new ArrayList<Integer>(); }
   //...
//   @Override 
//   public boolean equals(Object obj) {  // Standard recipe
//      if (!(obj instanceof IntSet)) return false;
//
//      IntSet s = (IntSet) obj;
//      return ???
//   }

//   @Override 
//   public int hashCode() { 
//      // see below 
//   }

   // adding a private constructor
   private IntSetBad (List<Integer> list) { els = list; }

   @Override 
   public IntSetBad clone() { 
      return new IntSetBad ( new ArrayList<Integer>(els));
   }
}
