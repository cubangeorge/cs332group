class Market {
   private Set<Item> wanted;    // items for which prices are of interest
   private Bag offers;    // offers to sell items at specific prices
   // Note:  Bag isn't a Java data type.  Here, the bag entries are pairs.

   public void offer (Item item, Money price)
      // Requires: item is an element of wanted
      // Effects:  add (item, price) to offers
   
   public Money buy(Item item)
      // Requires: item is an element of the domain of offers
      // Effects: choose and remove some (arbitrary) pair (item, price) from
      //          offers and return the chosen price
}

