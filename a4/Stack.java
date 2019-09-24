/**
  * Variant of Bloch's Stack example page 60, 3rd edition
  * Used in SWE/CS 332 to discuss mutability and AF/RI
  */

public class Stack {

   private Object[] elements;
   private int size = 0;


   public Stack() {
     this.elements = new Object[0];
   }

   public void push (Object e) {
     ensureCapacity();
     elements[size++] = e;
   }

   public Object pop () {
     if (size == 0) throw new IllegalStateException("Stack.pop");
     Object result = elements[--size];
     elements[size] = null;
     return result;
   }

   private void ensureCapacity() {
      if (elements.length == size) {
         Object oldElements[] = elements;
         elements = new Object[2*size + 1];
         System.arraycopy(oldElements, 0, elements, 0, size);
      }
   }
   
   public int getSize () {
	     return size;
	   }
   
   public boolean repOkay() {
	   //TODO: needs to be defined
	   
	   return true;
   }
   
   @Override 
   public String toString() {
	   //rep invariant
	   if (!repOkay()) {
		   throw new IllegalArgumentException("Stack has invalid contents!");
	   }
	   
	   if (this.elements.length == 0 || size == 0) {
		   return "{}";
	   }
	   
	   
	   
	   String getDeclaringClass = "";
	   	
		String newString = "{bottom";
		
		for (int i = 0; i < this.elements.length; i++) {
					
					newString += getStringCell(i);
					
		}
		
		

			return newString + "top}";
	   
   }
   
   public String getStringCell( int i) {
	   String objectType = "";
	   	String sCell="";
	 //check if current element in iteration is null, if so then treat it differently
		if (this.elements[i] == null) {
			objectType = "null";
		} else {
			objectType = this.elements[i].getClass().toString();
		}
		
		switch (objectType){
			case "class java.lang.Integer":
				sCell += "| "+this.elements[i]+" |";
				break;
			case "class java.lang.Character":
				sCell += "| \'"+this.elements[i]+"\' |";
				break;
			case "class java.lang.String":
				sCell += "| \""+this.elements[i]+"\" |";
				break;
			case "class java.lang.Double":
				sCell += "| "+this.elements[i]+" |";
				break;
			case "null":
					if ( i<= this.size-1 | size ==1)
						sCell += "| null |";
				
				break;
			default:
						
						sCell += "| Obj_"+(i+1)+" |";
				
				
		}//end switch
		return sCell;
   }
   
   public Object[] getStackAsArray() {
	   
	   Object []a = new Object[this.size];
	   System.arraycopy(elements, 0, a, 0, size+1);
	   return a;
			   
	   
   }

}
