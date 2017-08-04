package com.bellinfo.task8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Reversearraylist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>();
		Scanner s = new Scanner(System.in);
		System.out.println("\nEnter the array of numbers ");
		while(s.hasNextInt()){
		list.add(s.nextInt());}
		
		System.out.println("the given array list is : " +list);
	    Collections.reverse(list);
	    System.out.println("reversed array list is : " +list);
	 
	
	}

}
