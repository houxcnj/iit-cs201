/* This program gives the array encapsulation.
 * It includes accessors, mutators, toString, equals, add and many other methods.
 * CS201 Spring project
 * Tonghe Zhan&Xiaocheng Hou
 */


public class ZhanT_HouX_StringArray {
	
	final int MAX_SIZE = 300; //declare a constant
	private String[] strArray; //declare a array
	private int index; //declare a variable

	//default constructor
	public ZhanT_HouX_StringArray() {
		strArray = new String[MAX_SIZE];
		index = 0;
	}
	
	//nondefault constructor
	public ZhanT_HouX_StringArray(int size) {
		strArray = new String[size];
		index = 0;
	}
	
	//accessors
	public int getLength() {
		return strArray.length;
	}
	
	public String[] getArray() {
		String[] copyArray = new String[index];
		for (int i=0; i<index; i++) {
			copyArray[i] = strArray[i];
		}
		return copyArray;
	}
	
	//mutators
	public void setArray(String[] anArray) {
		for (int i=0; i<index; i++) 
			strArray[i] = anArray[i];
	}
	
	//get thr length of the array with elements
	public int getIndex() {
		return index;
	}
	
	//mutators
	public void setIndex(int anIndex) {
		index = anIndex;
	}
	
	//accessor
	public String getElement(int pos) {
		return strArray[pos];
	}
	
	//mutator
	public void setElement(String aString, int pos) {
		strArray[pos] = aString;
	}
	
	//toString
	public String toString() {
		String aStr = "";
		for (int i=0; i<index; i++) 
			aStr = aStr + strArray[i] + " ";
		return aStr;
	}
	
	//equal method
	public boolean equals(ZhanT_HouX_StringArray anArray) {
		boolean done = true;
		int i=0;
		if (anArray.getIndex()!= index)
			return false;
		else if (anArray.getLength()!= strArray.length) 
			return false;
		else {
			while (done && i<index) {
				if (!anArray.getElement(i).equals(strArray[i]))
					done = false;
				i++;
			}
			return done;
		}
		
	}
	
	//add a string to string array at the end of the array
	public void add(String aStr) {
		strArray[index] = aStr;
		index++;
	}
	
	//insert a string to the string array at the certain position
	public void insert(String aStr, int pos) {
		for (int i=index; i>pos; i--) {
			strArray[i] = strArray[i-1];
		}
		strArray[pos] = aStr;
		index++;
	}
	
	//judge if the string is in the string array 
	public int isThere(String aStr) {
		int i=0;
		while (!strArray[i].equals(aStr) && i<index) {
			i++;
		}
		if (i<index)
			return i;
		else 
			return -1;
	}
	
	//delete the string from the string array
	public void delete(String aStr)  {
		int i= this.isThere(aStr);
		if (i == -1)
			System.out.println("Sorry, the String you want to delete cannot be found.");
		else {
			while (i<index-1) {
				strArray[i] = strArray[i+1];
				i++;
			}
			index--;
		}
	}
	
	//delete the string at the certain position
	public void delete(int pos) {
		for (int i=pos; i<index-1; i++) 
			strArray[i] = strArray[i+1];
		index--;
	}
	
	//judge if the string is a part of the string in the string array
	public int isContained(String aStr) {
		int i=0;
		String[] anArray = new String[4];
		boolean done = false;
		while (!done && i<index) {
			anArray = strArray[i].split(",");
			int j=0;
			while (!done && j<4) {
				if (anArray[j].equals(aStr))
					done = true;
				j++;
			}
			i++;
		}
		if (done)
			return i-1;
		else
			return -1;
	}
	
	//delete the string from the string array's element
	public void deleteContains(String aStr) {
		int i =this.isContained(aStr);
		if (i == -1)
			System.out.println("Sorry, the String you want to delete cannot be found.");
		else {
			while (i<index-1) {
				strArray[i] = strArray[i+1];
				i++;
			}
			index--;
		}
	}

}
