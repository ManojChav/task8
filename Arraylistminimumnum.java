package com.bellinfo.task8;

import java.util.ArrayList;
import java.util.Scanner;

public class Arraylistminimumnum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>();
		Scanner s = new Scanner(System.in);
		System.out.println("\nEnter the array of numbers ");
		while(s.hasNextInt()){
		list.add(s.nextInt());}
		
		int min = list.get(0);	
		for(int i = 0; i < list.size(); i++) {
		    int number = list.get(i);
		    if(number < min) min = number;
		
		}
		System.out.println("\nMinimum Number is: " +min);
		
}
}