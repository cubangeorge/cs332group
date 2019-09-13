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
   
   public Stack(int size, Object[] elements) {
	   	this.size = size;
	     this.elements = elements;
	}
   
   //takes an object of a type and produces a new one
   //takes the old elements array and size of it to make a new array with the input parameter as the latest element. Then makes a new object based off of that.
   public Stack push(Object e) {
	   int newSize = elements.length + 1;
	   Object newishElements[] = new Object[newSize];
	   //System.arraycopy(elements, 0, newishElements, 0, newSize);
	   for (int i = 0; i < elements.length; i++) {
		   newishElements[i] = elements[i];
	   }
	   
	   newishElements[newSize-1] = e;
			   
	   Stack newerStack = new Stack(newSize, newishElements);
	     
	    return newerStack;
   }
   
   public Object pop() {

	   int i=0;
	   Object front_e[] = new Object[ elements.length ]; //make smaller stack array
	   
	   while ( i < elements.length) {
		   
		   	front_e[i] = elements[i]; //copy all elemnts minus the last one
		   	i++;
	   }
	   
	   Object o = elements [i]; //copy last element to return  
	    elements = front_e; 
	    return o;
   }	
   
   
   	public Object[] getElements() {
   		return this.elements;
   	}

	public String toString() {
	 String newString = "";
	 for (int i = 0; i < this.elements.length; i++) {
		   newString += this.elements[i];
	 }
	 
	 return newString;
	}
}
//jaja
