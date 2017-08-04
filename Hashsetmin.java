package com.bellinfo.task8;

import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Hashsetmin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Long> hashSet = new HashSet<Long>();
		Scanner s = new Scanner(System.in);
		System.out.println("\nEnter the numbers ");
		while(s.hasNextInt()){
		hashSet.add((long) s.nextInt());}
		
		Object obj = Collections.min(hashSet);
	    System.out.println("Minimum Element of HashSet is : " + obj);

		   
	}

}
