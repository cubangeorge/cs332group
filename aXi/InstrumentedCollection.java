/**
 * @author G 01066284 Valeria L Green (VG)
 * @author G 00402127 Jorge L Martinez (JM) 
 * @author G 01082586 Blake Khan (BK)
 */

import java.util.Collection;

// Implementation details in underlying set are encapsulated again
public class InstrumentedCollection<E> extends ForwardingCollection<E> {

	// Fields --------------------------------------------------
	
   private int addCount = 0;

   // Constructors ----------------------------------------------
   
   public InstrumentedCollection(Collection<E> s) {
      super(s);
   }
   
   // Methods ------------------------------------------------------

   /**
    * Adds a new object to the collection after incrementing a counter
    *
    * @param E The object to add
    * @return boolean Returns whether the addition was successful
    */
   @Override
   public boolean add(E e) {
      addCount++;
      return super.add(e);
   }

   /**
    *  Adds all of the input collection into the main collection after incrementing a counter by how many things were added
    *
    * @param E The collection to add
    * @return boolean Returns whether the addition was successful
    */
   @Override
   public boolean addAll(Collection<? extends E> c) {
      addCount += c.size();
      return super.addAll(c);
   }

   /**
    * Returns the amount of items added
    *
    * @return int The number that was added
    */
   public int getAddCount() {
      return addCount;
   }
}