package com.company.hi;

public class HI4 {

	public static void sayHello(String name){

		System.out.println("Hello" + name);

	}
	public static void sayHello(int name){

		System.out.println("Hello " + name);

	}
	public static void whereWereYouBorn(String[] aryName){
		
		String country1 = null;
		String country2 = null;
		String country3 = null;
		
		if  (aryName[0].equals("Fred")){
			country1 = "IRAN";
		}else{
			country1 = "US";
			
		}
		if  (aryName[1].equals("Fred")){
			country2 = "IRAN";
		}else{
			country2 = "US";
			
		}
		if  (aryName[2].equals("Fred")){
			country3 = "IRAN";
		}else{
			country3 = "IRELAND";
			
		}
		
		System.out.println(aryName[0] + " was born " + " in " + country1);
		System.out.println(aryName[1] + " was born " + " in " + country2);
		System.out.println(aryName[2] + " was born " + " in " + country3);
		
	}
		
	public static void main(String[] args) {
		
		HI4.sayHello(" " + args[0] + " " + "and" + " " + args[1] + " " + "and" + " " + args[2]);
		HI4.sayHello(1 + 2 +  3);
		HI4.whereWereYouBorn(args);
		
		
	}

}
