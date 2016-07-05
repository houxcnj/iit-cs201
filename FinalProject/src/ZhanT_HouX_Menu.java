import java.io.*;
import java.util.*;


/* This program gives the Menu class. Handle the inputs of user.
 * It includes the class method, readFile, getChoice and displayMenu methods.
 * CS201 Spring Project
 * Tonghe Zhan&Xiaocheng Hou
 */


public class ZhanT_HouX_Menu {
	
	private Scanner consIn; //ready for reading input file
	private ZhanT_HouX_StringArray menu; //our own string array
	final int SIZE = 300;

	//nondefault constructor
	public ZhanT_HouX_Menu(String file, int num)  {
		File inputFile = new File(file);
		try {
		consIn = new Scanner(inputFile);
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		menu = new ZhanT_HouX_StringArray(num);
		
	}
	
	//accessor
		public ZhanT_HouX_StringArray getZhanHouArray() {
			return menu;
		}

	//read file and store it in String array
	public void readFile(int sNum) {
		int i=0;
		while (i<sNum) {
			menu.add(consIn.nextLine());
			i++;
		}
		consIn.close();
	}
	
	//prompt user to make a choice
	public int getChoice() {
		Scanner choice = new Scanner(System.in);
		int input = 0;
		
		System.out.println("Please make your choice.");
		
		while (!choice.hasNextInt()) {
			String garbage = choice.nextLine();
			System.out.println("Please input an integer.");
		}
		input = choice.nextInt();
		return input;
	}
	
	//display the menu
	public void displayMenu() {
		for (int i=0; i<menu.getIndex(); i++)
			System.out.println(menu.getElement(i));
	}

}
