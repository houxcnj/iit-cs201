/*
 * This class define the criminal type, and will divide them into different level to represent the severity. For the theft, the severity is
 * minor, but for the weapon violation, the severity is serious. And the severity of the rest of criminal types are all medium.
 * CS201 Spring Project
 * Tonghe Zhan&Xiaocheng Hou
 */

public class ZhanT_HouX_CrimeType {

	private String crimeType;
	
	//default constructor
public ZhanT_HouX_CrimeType(){
	crimeType="theft";
}

//nondefault constructor
public ZhanT_HouX_CrimeType(String crimeType1){
	crimeType=crimeType1;
}

//accessors
public String getCrimeType(){
	return crimeType;
}

//mutators
public void setCrimeType(String crimeType2){
	crimeType=crimeType2;
}

//toString method
public String toString(){
	return "The criminal type: "+crimeType;
}

//equals method
public boolean equals(ZhanT_HouX_CrimeType theCrime){
	if(theCrime.equals(crimeType)){
		return true;
	}
	else return false;
}

//compareTo method
public int compareTo(ZhanT_HouX_CrimeType theCrime){
	if(crimeType.compareTo(theCrime.getCrimeType())>0){
		return 1;
	}
	else if(crimeType.compareTo(theCrime.getCrimeType())==0){
		return 0;
	}
	else 
		return -1;
}

//overridden method, show the severity of different types of crimes.
public String rate() {
	if (crimeType.equalsIgnoreCase("robbery") || crimeType.equalsIgnoreCase("battery") || crimeType.equalsIgnoreCase("narcotics") || crimeType.equalsIgnoreCase("criminal damage"))
		return "medium";
	else if (crimeType.equalsIgnoreCase("theft"))
		return "minor";
	else
		return "serious";
}

}