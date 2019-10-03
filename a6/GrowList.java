import java.util.*;
//  GrowList is a mutable list that only gets longer.
/**
 * 
 *  @author G 01066284 Valeria L Green (VG)
 *	@author G 00402127 Jorge L Martinez (JM) 
 *	@author G 01082586 Blake Khan (BK)jorge
 *  @param <E>
 */
public class GrowList <E> {

  private Map<Integer,E> values;

  public GrowList() { values = new HashMap<Integer,E>();}
 
  // add to the end of the list
  public void add(E o) {
     values.put(size(), o);
  }

  // number of values in list
  public int size() { return values.size(); }

  // get ith value in list
  public E get(int i) { 
     if (! inRange(i)) throw new IndexOutOfBoundsException("GrowList.get");
     return values.get(i);
  }

  // update ith value in list;  return previous value 
  public E set(int i, E o) {
     if (! inRange(i)) throw new IndexOutOfBoundsException("GrowList.set");
     return values.put(i, o);
  }
  
  // private helper method
  private boolean inRange(int i) { return (i >= 0) && (i < size()); }

  public String toString() {
      if (size() == 0) return "[]";
      String result = "[";
      for (int i = 0; i < size()-1; i++) {
          result += values.get(i) + ",";
      }
      return result + values.get(size() - 1) + "]";
  }

  public static void main(String[] args) {
     GrowList<String> list = new GrowList<String>();

     System.out.println("list is:" + list);
     list.add("cat");
     System.out.println("list is:" + list);
     list.add("dog");
     System.out.println("list is:" + list);
     list.set(1,"bat");
     System.out.println("list is:" + list);

  }
}
