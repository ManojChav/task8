package com.bellinfo.task8;

import java.util.HashMap;
import java.util.Map;

public class Keyexistancecheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Integer> cars = new HashMap<>();
        cars.put("honda", 1);
        cars.put("buick", 2);
        cars.put("ferrari", 3);
        cars.put("hyundai", null);

        System.out.println("1.does key 'buick' exists?");
        if (cars.containsKey("buick")) {
            System.out.println("yes! - " + cars.get("buick"));
        } 
        else {
             System.out.println("no!");
        }

        System.out.println("\n2. does key 'hyundai' exists?");
        if (cars.containsKey("hyundai")) {
            System.out.println("yes! - " + cars.get("hyundai"));
        } else {
            System.out.println("no!");
        }
        System.out.println("\n3. does key 'toyota' exists?");
        if (cars.containsKey("toyota")) {
            System.out.println("yes! - " + cars.get("toyota"));
        } else {
            System.out.println("no!");
        }

	}

}
