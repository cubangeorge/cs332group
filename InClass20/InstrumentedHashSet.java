import java.util.Collection;
import java.util.HashSet;

// Broken:  Inheritance violates encapsulation!
// Approach is not general; 1) limited to specific class, 2) only works for mutable types
public class InstrumentedHashSet<E> extends HashSet<E>{ 
   private int addCount = 0;	
   public InstrumentedHashSet() {}

   @Override public boolean add(E e){ 
      addCount++; 
      System.out.println("IH.add() ran once!!!");
      return super.add(e); 
   }
   @Override public boolean addAll(Collection<? extends E> c){ 
       // What to do with addCount?
       return super.addAll(c); 
   }
   public int getAddCount(){ return addCount; }
}