import java.io.*;
/*
 * As same as CrimeApp class, the class store the file to an object array. After that, it test some other class 
 * based on the test plan. 
 * CS201 Spring project
 * Tonghe Zhan&Xiaocheng Hou
 */
public class ZhanT_HouX_TestApp {

	public static void main(String[] args) {
		System.out.println("This is our test application class!");
		System.out.println();
		System.out.println("This is our data");
		//initiate an object list
		ZhanT_HouX_CrimeEventList list = new ZhanT_HouX_CrimeEventList();
		
		//initiate a menu of all items in the file
		ZhanT_HouX_Menu typeMenu = new ZhanT_HouX_Menu("ZhanT_HouX_data.csv",52);
		typeMenu.readFile(52);
		typeMenu.displayMenu(); 
		
		//use the array list to store the information to the object list, it is same as the crimeApp class
		String[] strArr = new String[4];
		for (int i=0; i<typeMenu.getZhanHouArray().getIndex(); i++) {
		 strArr = typeMenu.getZhanHouArray().getElement(i).split(",");
		 ZhanT_HouX_CrimeEvent event = new ZhanT_HouX_CrimeEvent();
		 event.setCaseNumber(strArr[0]);
		 event.setDate(strArr[1]);
		 boolean a = true;
		 if (strArr[3].equalsIgnoreCase("true")) {
			 a = true;
			 event.setArrest(a);
		 }
		 else {
			 a = false;
			 event.setArrest(a);
		 }
		 ZhanT_HouX_CrimeType type1 = new ZhanT_HouX_CrimeType();
		 ZhanT_HouX_CrimeWithWeapon type2 =new ZhanT_HouX_CrimeWithWeapon();
		 String[] t = new String[3];
		 if (strArr[2].contains("WEAPONS") || strArr[2].contains("HANDGUN")) { 
			 t = strArr[2].split("-");
			 type2.setCrimeType(t[0]);
			 type2.setCrimeWithWeapon(t[1]);
			 event.setCrimeType(type2);
		 }
		 else {
			 type1.setCrimeType(strArr[2]);
			 event.setCrimeType(type1);
			 }
		list.setIndex(i+1);
		list.setElement(event, i);
		
		}
		
		//output the file with the type rating
		FileWriter fileOut = null;
		BufferedWriter output = null;
		
		try{
		 fileOut = new FileWriter("ZhanT_HouX_output.txt");		//open file for output
		 output = new BufferedWriter(fileOut);
		 int i=0;
			while (i<list.getIndex()) {
			output.write(list.getElement(i)+"\t" + "Rating is: " + list.getElement(i).getCrimeType().rate());
			output.newLine();
			i++;
			}
			output.close();
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		
		System.out.println();
		
		//test the sort
		System.out.println("Our data sort by date");
		list.selectSort();
		for (int i=0; i<list.getIndex(); i++){
			System.out.println(list.getElement(i));}
		    System.out.println();
		
		//test the add and delete
		ZhanT_HouX_CrimeEvent anEvent = new ZhanT_HouX_CrimeEvent();
		anEvent = list.getElement(0);
		
		
		   //delete the first object
		System.out.println("After deleted the first object.");
		list.delete(0);
		for (int i=0; i<list.getIndex(); i++){
			System.out.println(list.getElement(i));}
		System.out.println();
		
		  //add the anEvent to the end
		System.out.println("After added the object to the end.");
		list.add(anEvent);
		for (int i=0; i<list.getIndex(); i++){
			System.out.println(list.getElement(i));}
		System.out.println();
		
		
		  //delete the anEvent
		System.out.println("After deleted the specified object.");
		list.delete(anEvent);
		for (int i=0; i<list.getIndex(); i++){
			System.out.println(list.getElement(i));}
		System.out.println();
		
		//test the polymorphism
		System.out.println("Test the polymorphism");
		System.out.println(list.getElement(2)+"\t" + "Rating is: " + list.getElement(2).getCrimeType().rate());
		System.out.println(list.getElement(5)+"\t" + "Rating is: " + list.getElement(5).getCrimeType().rate());

	}

}
