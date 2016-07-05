/*
 * The class defines those crimes with weapons, and it is the child class of the Zhan_Hou_CrimeType. When criminal has armed weapons,
 * the rate of this crime type will improve a level, if it is just a "medium" severity in the beginning classification, after armed weapons, it will be a "serious"
 * CS201 Spring Project
 * Tonghe Zhan&Xiaocheng Hou
 */
public class ZhanT_HouX_CrimeWithWeapon extends ZhanT_HouX_CrimeType {

	private String crimeWithWeapon;// declare a variable to describe the crime type with weapon
	
	//default constructor
		public ZhanT_HouX_CrimeWithWeapon(){
			super();
			crimeWithWeapon="handgun";
		}
		
		//nondefault constructor
		public ZhanT_HouX_CrimeWithWeapon(String crimeWithWeapon1){
			super();
			crimeWithWeapon=crimeWithWeapon1;
		}
		
		//accessor
		public String getCrimeWithWeapon(){
			return crimeWithWeapon;
		}
		
		//mutator
		public void setCrimeWithWeapon(String crimeWithWeapon2){
			crimeWithWeapon=crimeWithWeapon2;
		}
		
		//toString method
		public String toString(){
			return super.toString()+", The crime type with weapons: "+crimeWithWeapon;
		}
		
		//equals method
		public boolean equals(ZhanT_HouX_CrimeWithWeapon weapon ){
			if(super.equals(weapon)&&crimeWithWeapon.equals(weapon.getCrimeWithWeapon())){
				return true;
			}
			else return false;
		}
		
		//compareTo method
		public int compareTo(ZhanT_HouX_CrimeWithWeapon weapon){
			if(crimeWithWeapon.compareTo(weapon.getCrimeWithWeapon())>0){
				return 1;
			}
			else if(crimeWithWeapon.compareTo(weapon.getCrimeWithWeapon())==0){
				return 0;
			}
			else return -1;
		}
		
		//overridden method, define the severity of those crimes with weapons
		public String rate() {
			if (crimeWithWeapon.equalsIgnoreCase("handgun")) 
				return "felony";
			else if (super.rate().equals("serious"))
				return "felony";
			else if (super.rate().equals("medium"))
				return "serious";
			else 
				return "medimum";
		}
	}