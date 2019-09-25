/**
  * Variant of Bloch's Stack example page 60, 3rd edition
  * Used in SWE/CS 332 to discuss mutability and AF/RI
  * @author Jorge, Valeria, Blake
  */

public class Stack {
	
	//Fields ---------------------------------------------

	public Object[] elements; // Public only for fault junit test
	public int size = 0; // Public only for fault junit test

	//Constructors -----------------------------------------
	
	public Stack() {
		this.elements = new Object[0];
	}

	//Methods -----------------------------------------
	
	
	public void push(Object e) {
		ensureCapacity();
		elements[size++] = e;
	}

	public Object pop() {
		if (size == 0) throw new IllegalStateException("Stack.pop");
		Object result = elements[--size];
		elements[size] = null;
		return result;
	}

	private void ensureCapacity() {
		if (elements.length == size) {
			Object oldElements[] = elements;
			elements = new Object[2 * size + 1];
			System.arraycopy(oldElements, 0, elements, 0, size);
		}
	}

	public int getSize() {
		return size;
	}

	public boolean repOK() {
		// Verify that size is more than the elements length.
		if (size > elements.length) {
			return false;
		}

		// Verify that all elements past size are null.
		for (int i = size; i < elements.length; i++) {
			if (elements[i] != null) {
				return false;
			}
		}

		return true;
	}

	@Override
	public String toString() {
		//rep invariant
		if (!repOK()) {
			throw new IllegalArgumentException("Stack has invalid contents!");
		}

		if (this.elements.length == 0 || size == 0) {
			return "{}";
		}

		String newString = "{bottom";

		for (int i = 0; i < this.elements.length; i++) {
			newString += getStringCell(i);
		}

		return newString + "top}";
	}

	/**
	 * @param: Integer The index at which the abstract data type is to be found
	 * 
	 * @return: String returns a string representation of the abstract data type
	 * 
	 * OVERVIEW: This returns an abstract representation of an abstract data type in the array at the specified index
	 *                    
	 * 
	 */
	public String getStringCell(int i) {
		String objectType;
		String sCell = "";

		//check if current element in iteration is null, if so then treat it differently
		if (this.elements[i] == null) {
			objectType = "null";
		} else {
			//gets the class name of data type
			objectType = this.elements[i].getClass().toString();
		}

		//uses the retrieved class name from earlier to determine which part of the switch case to go to
		switch (objectType) {
			case "class java.lang.Integer":
			case "class java.lang.Double":
				sCell += "| " + this.elements[i] + " |";
				break;
			case "class java.lang.Character":
				sCell += "| \'" + this.elements[i] + "\' |";
				break;
			case "class java.lang.String":
				sCell += "| \"" + this.elements[i] + "\" |";
				break;
			case "null":
				if (i <= this.size - 1 | size == 1)
					sCell += "| null |";
				break;
			default:
				sCell += "| Obj_" + (i + 1) + " |";
				break;
		}//end switch
		return sCell;
	}

	public Object[] getStackAsArray() {
		Object[] a = new Object[this.size];
		System.arraycopy(elements, 0, a, 0, size + 1);
		return a;
	}
}
