/**
  * Variant of Bloch's Stack example page 60, 3rd edition
  * Used in SWE/CS 332 to discuss mutability and AF/RI
  */

import java.util.*;

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
	   
	   
	   String objectType = "";
	   String getDeclaringClass = "";
	   	
		String newString = "{bottom";
		
		
		for (int i = 0; i < this.elements.length; i++) {
			
			//check is current element in iteration is null, if so then treat it differently
			if (this.elements[i] == null) {
				objectType = "null";
			} else {
				objectType = this.elements[i].getClass().toString();
			}
			
			switch (objectType){
				case "class java.lang.Integer":
					newString += "| "+this.elements[i]+" |";
					break;
				case "class java.lang.Character":
					newString += "| \'"+this.elements[i]+"\' |";
					break;
				case "class java.lang.String":
					newString += "| \""+this.elements[i]+"\" |";
					break;
				case "class java.lang.Double":
					newString += "| "+this.elements[i]+" |";
					break;
				case "null":
						if ( i<= this.size-1 | size ==1)
							newString += "| null |";
					
					break;
				default:
					
					//if the client defined class has a toString method defined then it won't throw 
					//the NoSuchMethodException. If they have it defined then it'll just get the name 
					//of that class and it's toString
					try {
					
						if (this.elements[i].getClass().getMethod("toString").getDeclaringClass() == Object.class) {
							
							newString += "| Obj_"+(i+1)+" |";
						}
						else {//handles the user defined Objects 
							newString += "| " + getDeclaringClass + " " + this.elements[i].toString() + " |";
						}
						
					} catch (NoSuchMethodException e) {
						
						newString += " Obj_"+(i+1)+" ";
					}
					
			}//end switch
			
		}

			return newString + "top}";
	   
   }

}
