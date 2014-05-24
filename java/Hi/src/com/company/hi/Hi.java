package com.company.hi;

public class Hi {

	public static void sayHello(String name){

		System.out.println("Hello" + name);

	}
	public static void sayHello(int name){

		System.out.println("Hello " + name);

	}
	public static void whereWereYouBorn(String[] aryName){
		
		String country1 = null;
		String country2 = null;
		
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
		System.out.println(aryName[0] + " was born " + " in " + country1);
		System.out.println(aryName[1] + " was born " + " in " + country2);

	}
		
	public static void main(String[] args) {
		
		Hi.sayHello(" " + args[0] + " " + "and" + " " + args[1]);
		Hi.sayHello(1 + 2 +  3);
		Hi.whereWereYouBorn(args);
		
		
	}

}
