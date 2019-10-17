import java.util.HashMap;
import java.util.LinkedList;

/**
 * 
 */

/**
 * @author jorge
 *
 */
public class FwStack {

	private static final HashMap<Integer ,Object> bucket = new HashMap<Integer ,Object> ();

	//public class Stack {

	   private LinkedList<Object> refs;
	   int lastElemIndx;
	   
	   public int getSize() {
		   return refs.size();
		  
	   }


	   public FwStack() {
	     this.refs = new LinkedList<>();
	     
	   }

	   public void push (Object e) {
	     
		   int key = e.hashCode();
		   Object o = bucket.get(key);
		   if(o == null)
			   bucket.put(key, e);
		   refs.addLast(key);
		   
	   }

	   public Object pop () {
	     if (refs.size() == 0) throw new IllegalStateException("Stack.pop");
	     Object result = refs.getLast();
	     //elements[size] = null;
	     return result;
	   }
	   
}
