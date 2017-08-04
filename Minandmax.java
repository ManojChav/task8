package com.bellinfo.task8;

import java.util.Map;
import java.util.TreeMap;

public class Minandmax {
    public static void main(String[] args) {
	final Map<String,String> trm = new TreeMap<String, String>();
	trm.put("1", "One");
    trm.put("2", "Two");
    trm.put("3", "Three");    
    trm.put("4", "Four");
    trm.put("5", "Five");

	
    System.out.println("Lowest key: " + ((TreeMap<String,String>) trm).firstKey());
    System.out.println("Highest key: " + ((TreeMap<String,String>) trm).lastKey());
  }
}