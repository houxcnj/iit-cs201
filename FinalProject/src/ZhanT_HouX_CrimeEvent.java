/*
 * This class is a class definition for those crime events, we have four variables in this class, and the caseNumber represents that 
 * the identification number of each case. The date shows the case happened in which date, the crimeType represents that the case is in which type.
 * The arrest can show whether the criminal has been arrested or not.
 * CS201 Spring
 * Tonghe Zhan&Xiaocheng Hou
 */
public class ZhanT_HouX_CrimeEvent {

	private String caseNumber;
	private String date;
	private boolean arrest;
	private ZhanT_HouX_CrimeType crimeType;
	
	//default constructor
	public ZhanT_HouX_CrimeEvent(){
		caseNumber="HX123456";
		date="01/01/01";
		arrest=false;
		crimeType = new ZhanT_HouX_CrimeType();
	}
	
	//nondefault constructor
	public ZhanT_HouX_CrimeEvent(String caseNumber1, String date1, boolean arrest1, String crimeType1){
		caseNumber=caseNumber1;
		date=date1;
		arrest=arrest1;
		crimeType= new ZhanT_HouX_CrimeType(crimeType1);
	}
	
	//accessors
	public String getCaseNumber(){
		return caseNumber;
	}
	
	public String getDate(){
		return date;
	}
	
	public boolean getArrest(){
		return arrest;
	}
	
	public ZhanT_HouX_CrimeType getCrimeType(){
		return crimeType;
	}
	
	//mutators
	public void setCaseNumber(String caseNumber2){
		caseNumber=caseNumber2;
	}
	
	public void setDate(String date2){
		date=date2;
	}
	
	public void setArrest(boolean arrest2){
		arrest=arrest2;
	}
	
	public void setCrimeType(ZhanT_HouX_CrimeType crimeType2){
		crimeType = crimeType2;
	}
	
	//toString method
	public String toString(){
		return "The information of the crime event: "+caseNumber+", Date is:" +date+", Arrest?"+arrest+", "+crimeType;
	}
	
	//equals method
	public boolean equals(ZhanT_HouX_CrimeEvent cE ){
		if(caseNumber.equals(cE.getCaseNumber())&&date.equals(cE.getDate())&&crimeType.equals(cE.getCrimeType())){
			return true;
		}
		else return false;
	}
	
	//compareTo method
	public int compareTo(ZhanT_HouX_CrimeEvent anEvent) {
		if (date.compareTo(anEvent.getDate())<0)
			return -1;
		else if (date.compareTo(anEvent.getDate())==0)
			return 0;
		else
			return 1;
	}
	
	//isContained method
	public int isContained(String aStr) {
		if (aStr.equalsIgnoreCase(caseNumber))
			return 1;
		else if (aStr.equalsIgnoreCase(date))
			return 1;
		else if (aStr.equalsIgnoreCase(this.getCrimeType().getCrimeType()))
			return 1;
		else
			return -1;
	}
}
