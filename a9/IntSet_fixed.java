public class IntSet implements Cloneable {  
   private List<Integer> els;
   public IntSet () { els = new ArrayList<Integer>(); }
   ...
   @Override 
   public boolean equals(Object obj) {  // Standard recipe
      if (!(obj instanceof IntSet)) return false;

      IntSet s = (IntSet) obj;
      return ???
   }

   @Override 
   public int hashCode() { 
      // see below 
   }

   // adding a private constructor
   private IntSet (List<Integer> list) { els = list; }

   @Override 
   public IntSet clone() { 
      return new IntSet ( new ArrayList<Integer>(els));
   }
}
