/*
 * It is the class definition of the crime event list, it contains many different kinds of functions.
 * CS201 Spring
 * Tonghe Zhan&Xiaocheng Hou
 */
public class ZhanT_HouX_CrimeEventList {


	final int MAX_SIZE=1000;
	private ZhanT_HouX_CrimeEvent [] eventArray;
	private int index;
	private int pointer;
	//default constructor
	public ZhanT_HouX_CrimeEventList(){
		eventArray=new ZhanT_HouX_CrimeEvent [MAX_SIZE];
		index=0;
	}
	//nondefault constructor
	public ZhanT_HouX_CrimeEventList(int size){
		eventArray=new ZhanT_HouX_CrimeEvent [size];
	}
	
	//accessors
	public int getLength(){
		return eventArray.length;
	}
	
	public int getPointer(){
		return pointer;
	}
	
	public ZhanT_HouX_CrimeEvent [] getEventArray(){
		ZhanT_HouX_CrimeEvent [] strArray1=new ZhanT_HouX_CrimeEvent [index];
		for(int i=0;i<index;i++){
			strArray1[i]=eventArray[i];
		}
		return strArray1;
	}
	
	public int getIndex(){
		return index;
	}
	
	public ZhanT_HouX_CrimeEvent getElement(int i){
		return eventArray[i];
	}
	
	//mutators
	public void setEventArray(ZhanT_HouX_CrimeEvent [] anArray){
		for(int i=0;i<index;i++){
			eventArray[i]=anArray[i];
		}
	}
	
	public void setPointer(int pointer1){
		pointer=pointer1;
	}
	
	public void setIndex(int anIndex){
		index=anIndex;
	}
	
	public void setElement(ZhanT_HouX_CrimeEvent s, int pos){
		eventArray[pos]=s;
	}
	
	public boolean equals(ZhanT_HouX_CrimeEventList anArray){
		boolean a=true;
		int i=0;
		if(index==anArray.getIndex()){
		if(eventArray.length==anArray.getLength()){			
		while(a&&i<index){
			i++;
		if(eventArray[i]!=anArray.getElement(i)){
						a=false;
					}
				}
	    if(a==true){
	    	return true;
	    }
	    else return false;
		}
		else return false;
		}
		else return false;
		
	}
	
	//add method, add the method at the place of index
	public void add(ZhanT_HouX_CrimeEvent aStr){
		eventArray[index]=aStr;
	    index++;
	}
	
	//insert method, insert the obkect to a certain placce
	public void insert(ZhanT_HouX_CrimeEvent aStr, int pos){
		for(int i=index;i>pos;i--){
			eventArray[i]=eventArray[i-1];
		}
		eventArray[pos]=aStr;
		index++;
	}
	
	//inThere method, find that whether the object is in a certain array
	public int isThere(ZhanT_HouX_CrimeEvent aStr){
		int pos=0;
		while(aStr!=eventArray[pos]&&pos<index){
			pos++;
			}
		if(aStr==eventArray[pos]){
			return pos;
		}
		else return -1;
	}
	
	//delete method, delete a certain element in the array
	public void delete(ZhanT_HouX_CrimeEvent aStr){
		for(int i=isThere(aStr);i>isThere(aStr)&&i<index-1;i++){
			eventArray[i]=eventArray[i+1];
		}
		index--;
	}

	//delete the element in a certain place
	public void delete(int pos){
		for(int i=pos;i<index-1;i++){
			eventArray[i]=eventArray[i+1];
		}
		index--;
	}
	
	//find out whether the object is in the array or not
	public int isContained(ZhanT_HouX_CrimeEvent aStr){
		int pos=0;
		if(isThere(aStr)>0){
		while(!(eventArray[pos].equals(aStr))&&pos<index-1){
			pos++;
			}
		
			return pos;
		}
			return -1;
		
	}
	
	//delete the object that exist in the array
	public void deleteContains(ZhanT_HouX_CrimeEvent aStr){
		if(isContained(aStr)>0){
		for(int i=isContained(aStr);i<index-1;i++){
			eventArray[i]=eventArray[i+1];
		}
		index--;}
		
	}
	
	//to check the array is full or not
	public boolean isFull(){
		if(eventArray.length==index){
			return true;
		}
		else return false;
	}
	
	//to check the array is empty or not
	public boolean isEmpty(){
		if(index==0){
			return true;
		}
		else return false;
	}
	
	//to clear all the elements in the array
	public void clear(){
		for(int i=0;i<eventArray.length;i++){
			eventArray[i]=null;
		}
		index=0;
	}
	
	//to make the length of the array equals to index
	public void trim(){
		if(eventArray.length>index){
			ZhanT_HouX_CrimeEvent [] aZTobj=new ZhanT_HouX_CrimeEvent[index];
			for(int i=0;i<index;i++){
				aZTobj[i]=eventArray[i];
			}
			eventArray=aZTobj;
		}
	}
	
	//to extent the capacity of the array
	public void moreCapacity(int more){
		ZhanT_HouX_CrimeEvent [] bZTobj=new ZhanT_HouX_CrimeEvent[eventArray.length*more];
		for(int i=0;i<index;i++){
			bZTobj[i]=eventArray[i];
		}
		eventArray=bZTobj;
	}
	
	//reset the pointer
	public void reset(){
		pointer=0;
	}
	
	//check the next slot has an element or not
	public boolean hasNext(){
		if(eventArray[pointer]!=null){
			return true;
		}
		else return false;
	}
	
	//get the element at the position of pointer
	public ZhanT_HouX_CrimeEvent getNext(){
		return eventArray[pointer++];
		
	}
	
	//toString method
	public String toString(){
		String s1="";
		for(int i=0;i<index;i++){
			s1=s1+eventArray[i]+"\t";
		}
		return "The array: "+s1;
	}
	
	//sequential search method
		public int sequentialSearch(ZhanT_HouX_CrimeEvent anEvent) {
			int found = -1;
			int i = 0;
			while (found == -1 && i< this.getIndex()) {
				if (anEvent.equals(this.getElement(i)))
					found = i;
				i++;
			}
			return found;
		}
		//recursive sequential search method
		public int sequentialSearch(ZhanT_HouX_CrimeEvent anEvent,int i) {
			int found = -1;
			while (found == -1 && i< this.getIndex()) {
				if (anEvent.equals(this.getElement(i)))
					found = i;
				else
					sequentialSearch(anEvent, i+1);
			}
			return found;
		}
		
		//swap method
		public void swap(int i, int j) {
			ZhanT_HouX_CrimeEvent temp = new ZhanT_HouX_CrimeEvent();
			 temp = this.getElement(i);
			 this.setElement(this.getElement(j), i);
			 this.setElement(temp, j);
			 
		}
		
		//selection sort method
		public void selectSort() {
			for (int i=0; i<this.getIndex()-1; i++) {
				ZhanT_HouX_CrimeEvent anEvent = this.getElement(i);
				int min = i;
				for (int j=i+1; j<this.getIndex(); j++) {
					if (anEvent.compareTo(this.getElement(j))>0) {
						anEvent = this.getElement(j);
						min = j;
					}
				}
				this.swap(i, min);
				
			}
			
		}
		
		//binary search method
		public int binarySearch(ZhanT_HouX_CrimeEvent anEvent) {
			int first = 0;
			int last = this.getIndex()-1;
			int middle = (first+last)/2;			
			int found = -1;
			while (first <= last && found == -1) {
				if (anEvent.compareTo(this.getElement(middle))==0)
					found = middle;
				else if (anEvent.compareTo(this.getElement(middle))<0) {
					last = middle-1;
					middle = (first+last)/2;
				}
				else {
					first = middle+1;
					middle = (first+last)/2;
				}
			}
			return found;
		}
			
		//recursive binary search method
		public int binarySearch(int first, int last, ZhanT_HouX_CrimeEvent anEvent) {
			int middle = (first+last)/2;
			int found = -1;
			while (first <= last && found == -1) {
				if (anEvent.compareTo(this.getElement(middle))==0)
					found = middle;
				else if (anEvent.compareTo(this.getElement(middle))<0)
					binarySearch(first, middle-1,anEvent);
				else 
					binarySearch(first+1, last,anEvent);
			}
			return found;
		}
		
		//calculate the ratio of arrest 
		public double calcArrest(String aStr) {
			double count = 0;
			double good = 0;
			for (int i=0; i<this.getIndex(); i++)
			if (eventArray[i].isContained(aStr)!=-1) {
				count++;
				if (eventArray[i].getArrest())
					good++;
			}
			double ratio = good/count;
			return ratio;
		}

}



