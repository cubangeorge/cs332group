import java.util.ArrayList;
import java.util.List;

public class IntSet implements Cloneable {  
	private List<Integer> els;
	   
	   
	   public IntSet () { 
		   els = new ArrayList<Integer>(); 
	   }
	   @Override 
	   public IntSet clone() { 
	      return new IntSet ( new ArrayList<Integer>(els));
	   }
	   
	   @Override 
	   public boolean equals(Object obj) {  // Standard recipe
	      if (!(obj instanceof IntSet)) return false;

	      IntSet s = (IntSet) obj;
	      return compare_size_and_elements(s);
	   }

	   private IntSet (List<Integer> list) { els = list; }
	   
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
	   
	   
	   
	   @Override 
	   public String toString() {
		   return this.els.toString();
	   }
	   
	       
	   //does the comparison for the equals method
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
