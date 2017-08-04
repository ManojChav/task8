package com.bellinfo.task8;

import java.util.HashMap;

public class Checkvalueexistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, String> hashmap = new HashMap<Integer, String>();
		 
	    hashmap.put(10,"Chaitanya");
	    hashmap.put(20,"Sruthi");
	    hashmap.put(30,"Avinash");
	    hashmap.put(40,"Vatsalya");
	    hashmap.put(50,"Raed");
	    hashmap.put(60,"Adi");
	    hashmap.put(70,"Riyadh");
	    hashmap.put(80,"Catherine");
	    hashmap.put(90,"Hassan");
	    
	 
	    boolean flag = hashmap.containsValue("Raed");
	    System.out.println("String Raed exists in HashMap? : " + flag);
	
	    boolean flag1 = hashmap.containsValue("Manoj");
	    System.out.println("String Manoj exists in HashMap? : " + flag1);
	    
	    boolean flag2 = hashmap.containsValue("Hassan");
	    System.out.println("String Hassan exists in HashMap? : " + flag2);
	
	
	}

}
