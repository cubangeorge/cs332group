/*
 * 
 * This program is a rewrite of the Stack class to make it immutable
 * @author Jorge L Martinez & Valeria Green
 * 
 */

//import java.util.*;


public class Stack {

   private Object[] elements;
//   private final int size = 0; @Hi Vale: this size should change the original example had a final initial default value which is ok but not changing would be a problem
   private int size = 0;


   public Stack() {
     this.elements = new Object[0];
   }
   
   public Stack(int size) {
	     this.elements = new Object[size];
	}
   
   public Stack(Object[] elements) {
	     this.elements = elements;
	}
   
   
   public Stack push (Object e) {
	   Object[] newElements = this.elements.clone();
	   
	   return new Stack(newElements);
   }


	public String toString() {
	 String newString = "";
	 for (int i = 0; i < this.elements.length; i++) {
		   newString += this.elements[i];
	 }
	 
	 return newString;
	}

}
