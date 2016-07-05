import java.util.*;
import java.io.*;
/*The application can read the file which is the crimes information in Chicago. So our 
program is an application that can access the crime data which contains the case number, 
the date, the criminal type, and whether the criminal got arrested or not. And we think it 
is better for the police station to use it. Because they can update the crime data if necessary,
if there are new cases happen, they can add it into the dataset, if there are anything wrong with 
the records, they can delete them. They also can use this application to manage their records, and
display it out in the way they want, like search a specific case in the past, or display all the cases that 
happened in a specific day, or display all the cases that happened in a specific criminal type. What is more,
the application also can show the severity of each kind of crime. And if you have a right input, it can 
calculate the arrest rate for one day, or one case or one criminal type. It is really a powerful crime 
information management application.
CS201 Spring Project
Tonghe Zhan&Xiaocheng Hou
*/

public class ZhanT_HouX_CrimeApp {

	public static void main(String[] args) {
		//initiate an object list
		System.out.println("This is our program of Crime Information Managment Application");
		System.out.println();
		ZhanT_HouX_CrimeEventList list = new ZhanT_HouX_CrimeEventList();
		
		//initiate a menu of all items in the file
		System.out.println("This is our data");
		ZhanT_HouX_Menu typeMenu = new ZhanT_HouX_Menu("ZhanT_HouX_data.csv",52);
		typeMenu.readFile(52);
		typeMenu.displayMenu();
		
		//use the array list to store the information to the object list
		String[] strArr = new String[4];
		for (int i=0; i<typeMenu.getZhanHouArray().getIndex(); i++) {
		 strArr = typeMenu.getZhanHouArray().getElement(i).split(","); //store the element after split by ","
		 ZhanT_HouX_CrimeEvent event = new ZhanT_HouX_CrimeEvent(); //initiate a new event object
		 event.setCaseNumber(strArr[0]); 
		 event.setDate(strArr[1]);
		 boolean a = true; //declare a variable to transfer string to boolean
		 if (strArr[3].equalsIgnoreCase("true")) {
			 a = true;
			 event.setArrest(a);
		 }
		 else {
			 a = false;
			 event.setArrest(a);
		 }
		 ZhanT_HouX_CrimeType type1 = new ZhanT_HouX_CrimeType(); //initiate the type object
		 ZhanT_HouX_CrimeWithWeapon type2 =new ZhanT_HouX_CrimeWithWeapon(); //initiate a crime type with weapon object
		 String[] t = new String[3]; //declare a string array to store the type string and split by "-"
		 if (strArr[2].contains("WEAPON") || strArr[2].contains("HANDGUN")) { 
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
		
		//display the menu
		ZhanT_HouX_Menu mainMenu = new ZhanT_HouX_Menu("ZhanT_HouX_menu.txt",4);
		mainMenu.readFile(4);
		
		boolean done = false;
		while (!done) {
			System.out.println();
		    System.out.println("Please choose how to display the data: ");
			mainMenu.displayMenu();
			int choice = mainMenu.getChoice();
			if (choice == -1) {
				done =true;
				System.out.println("Thank you!");
			}
			else 
				ZhanT_HouX_CrimeApp.job(choice, list);
			    
			}
		

	}
	
	//After user choose the number, the application will follow the user's choice to execute different method 
	public static void job(int aChoice, ZhanT_HouX_CrimeEventList anArr) {
		switch (aChoice) {
		case 1: 
			ZhanT_HouX_CrimeApp.displaybyType(anArr);
			break;
		case 2:
			ZhanT_HouX_CrimeApp.displaybyDay(anArr);
			break;
		case 3:
			ZhanT_HouX_CrimeApp.displayArrestRatio(anArr);
			break;
		}
	}
	
	//display diferent criminal types, and show the polymorphism
	public static void displaybyType (ZhanT_HouX_CrimeEventList anArr) {
		ZhanT_HouX_Menu typeMenu = new ZhanT_HouX_Menu("ZhanT_HouX_type.txt",6);
		typeMenu.readFile(6);
		typeMenu.displayMenu();
		int choice = typeMenu.getChoice();
		
		if (choice == 1) {
			for (int i=0; i<anArr.getIndex(); i++) {
				if (anArr.getElement(i).getCrimeType().getCrimeType().equalsIgnoreCase("battery"))
					System.out.println(anArr.getElement(i)+", Rating is:" +anArr.getElement(i).getCrimeType().rate());
			}
		}
			
		if (choice == 2) {
			for (int i=0; i<anArr.getIndex(); i++) {
				if (anArr.getElement(i).getCrimeType().getCrimeType().equalsIgnoreCase("robbery"))
					System.out.println(anArr.getElement(i)+", Rating is:" +anArr.getElement(i).getCrimeType().rate());
			}
		}
		
		if (choice == 3) {
			for (int i=0; i<anArr.getIndex(); i++) {
				if (anArr.getElement(i).getCrimeType().getCrimeType().equalsIgnoreCase("narcotics"))
					System.out.println(anArr.getElement(i)+", Rating is:" +anArr.getElement(i).getCrimeType().rate());
			}
		}
		
		if (choice == 4) {
			for (int i=0; i<anArr.getIndex(); i++) {
				if (anArr.getElement(i).getCrimeType().getCrimeType().equalsIgnoreCase("theft"))
					System.out.println(anArr.getElement(i)+", Rating is:" +anArr.getElement(i).getCrimeType().rate());
			}
		}
		
		if (choice == 5) {
			for (int i=0; i<anArr.getIndex(); i++) {
				if (anArr.getElement(i).getCrimeType().getCrimeType().equalsIgnoreCase("weapons violation"))
					System.out.println(anArr.getElement(i)+", Rating is:" +anArr.getElement(i).getCrimeType().rate());
			}
		}
		
		if (choice == 6) {
			for (int i=0; i<anArr.getIndex(); i++) {
				if (anArr.getElement(i).getCrimeType().getCrimeType().equalsIgnoreCase("criminal damage"))
					System.out.println(anArr.getElement(i)+", Rating is:" +anArr.getElement(i).getCrimeType().rate());
			}
		}
		
		
	}
	
	//display the crime records by date
	public static void displaybyDay(ZhanT_HouX_CrimeEventList anArr) {
		System.out.println("Please input a day you want to check.(The format is MM/DD/YYYY)");
		System.out.println("(Now our dataset is support the search from 02/15/2014~02/17/2014)");
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		
		if (input.equals("02/17/2014"))
			for (int i=0; i<anArr.getIndex(); i++) {
				if (anArr.getElement(i).getDate().equals("02/17/2014"))
					System.out.println(anArr.getElement(i)+", Rating is:" +anArr.getElement(i).getCrimeType().rate());
			}
		else if (input.equals("02/16/2014"))
			for (int i=0; i<anArr.getIndex(); i++) {
				if (anArr.getElement(i).getDate().equals("02/16/2014"))
					System.out.println(anArr.getElement(i)+", Rating is:" +anArr.getElement(i).getCrimeType().rate());
			}
		else if (input.equals("02/15/2014"))
			for (int i=0; i<anArr.getIndex(); i++) {
				if (anArr.getElement(i).getDate().equals("02/15/2014"))
					System.out.println(anArr.getElement(i)+", Rating is:" +anArr.getElement(i).getCrimeType().rate());
			}
		else 
			System.out.println("The date your input is not in the range of our data, please do it again");
	}
	
	//display the arrest rate after user having the right input
	public static void displayArrestRatio (ZhanT_HouX_CrimeEventList anArr) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Please input the key word which you want to know the arrest ratio of it. Just follow the input format of those data, such as the case number, the date and the criminal type");
		System.out.println("PS: If you get a NaN, it shows that the data is not exist or you have something wrong with your input. Please do it again.");
		
		String input = in.nextLine();
		
		System.out.println(anArr.calcArrest(input));
		
		
		
	}
	

}
