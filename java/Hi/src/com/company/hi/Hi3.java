package com.company.hi;

public class Hi3 {
	
	public static String[] aryCountry = new String[]{"",""};

	public static void sayHello(String name){

		System.out.println("Hello" + name);

	}
	public static void sayHello(int name){

		System.out.println("Hello " + name);

	}
	public  static void whereWereYouBorn(String[] aryName){
		
		
		
		buildCountryName(aryName, 0);
		buildCountryName(aryName, 1);
		
		System.out.println(aryName[0] + " was born " + " in " + aryCountry[0]);
		System.out.println(aryName[1] + " was born " + " in " + aryCountry[1]);

	}
public static void buildCountryName(String[] aryName, int index){
		
		
		
		if  (aryName[index].equals("Fred")){
			aryCountry[index] = "IRAN";
		}else{
			aryCountry[index] = "US";
			
		}

	}	
	public static void main(String[] args) {
		
		Hi3.sayHello(" " + args[0] + " " + "and" + " " + args[1]);
		Hi3.sayHello(1 + 2 +  3);
		Hi3.whereWereYouBorn(args);
		
		
	}

}
