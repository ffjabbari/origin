package com.company.hi;

public class Hi2 {

	public static void sayHello(String name){

		System.out.println("Hello" + name);

	}
	public static void sayHello(int name){

		System.out.println("Hello " + name);

	}
	public static void whereWereYouBorn(String[] aryName){
		
		String[] aryCountry = new String[]{"",""};
		
		
		if  (aryName[0].equals("Fred")){
			aryCountry[0] = "IRAN";
		}else{
			aryCountry[0] = "US";
			
		}
		if  (aryName[1].equals("Fred")){
			aryCountry[1] = "IRAN";
		}else{
			aryCountry[1] = "US";
			
		}
		System.out.println(aryName[0] + " was born " + " in " + aryCountry[0]);
		System.out.println(aryName[1] + " was born " + " in " + aryCountry[1]);

	}
		
	public static void main(String[] args) {
		
		Hi2.sayHello(" " + args[0] + " " + "and" + " " + args[1]);
		Hi2.sayHello(1 + 2 +  3);
		Hi2.whereWereYouBorn(args);
		
		
	}

}
