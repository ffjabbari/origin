package com.company.hi;

public class Hi5 {

	
	public static void whereWereYouBorn(String[] aryName){
		
		String country = null;
		
		for  (int ix = 0; ix < aryName.length; ix++){
			if  (aryName[ix].equalsIgnoreCase("Fred")){
				country = "IRAN";
			}
			else if  (aryName[ix].equalsIgnoreCase("Tom")){
				country = "US";
			}
			else if  (aryName[ix].equalsIgnoreCase("Patrick")){
				country = "IRELAND";
			}
			else {
				country = "I don't know!!!";
			}
			
			System.out.println(aryName[ix] + " was born " + " in " + country);
		}	
	}
		
	public static void main(String[] args) {
		Hi5.whereWereYouBorn(args);
		
	}

}
