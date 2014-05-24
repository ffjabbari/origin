package com.company.hi;

public class Hi6 {

	public static String[][] aryNameCountryXref = new String[][]{
		{"Tom", "US"},
		{"Patrick", "IRELAND"}, 
		{"Fred", "IRAN"}, 
		{"Jack", "JackCountry"}, 
		{"Jill", "JillCountry"}, 
		{"John", "JohnCountgry"} 
		};
	
	public static void whereWereYouBorn(String[] aryName){
		
		String country = null;
		
		
		
		
		
		for  (int ix = 0; ix < aryName.length; ix++){
			
			country = findCountry(aryName[ix]);
			
			System.out.println(aryName[ix] + " was born " + " in " + country);
			
		}	
	}
	private static String findCountry(String name){
		
		String country = "???";
		
		for  (int iRow =0; iRow < aryNameCountryXref.length; iRow++){
			
			if  (aryNameCountryXref[iRow][0].equalsIgnoreCase(name)){
				
				country = aryNameCountryXref[iRow][1];
				
			}
		}	
		
		return country;
	}
		
	public static void main(String[] args) {
		Hi6.whereWereYouBorn(args);
		
	}

}

