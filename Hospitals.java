package com.bellinfo.task8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Hospitals {

	public static void main(String[] args) {

		Doctor d1 = new Doctor(1, "Prem", "Eyes");
		Doctor d2 = new Doctor(2, "Rajeev", "Liver");
		Doctor d3 = new Doctor(3, "Hem", "Skin");

		Address a1 = new Address("13621 legacy circle", "Apt C", "Herndon","VA", 20171);
		Address a2 = new Address("1460 Bell Pepper ct", "Apt 201", "Fairborn","OH", 45332);
		Address a3 = new Address("1555, Calder ct", "Apt A", "Dayton", "OH",45324);

		Hospital h1 = new Hospital("Netra Medical Home", d1, a1);
		Hospital h2 = new Hospital("Indu Soin Hospital", d2, a2);
		Hospital h3 = new Hospital("Dayton Skin Care Hospital", d3, a3);

		ArrayList<Hospital> ary = new ArrayList<>();
		ary.add(h1);
		ary.add(h2);
		ary.add(h3);

		List<Hospital> hospital1 = new ArrayList<>();
		List<Hospital> hospital2 = new ArrayList<>();
		List<Hospital> hospital3 = new ArrayList<>();

		hospital1.add(h1);
		hospital2.add(h2);
		hospital3.add(h3);

		HashMap<String, List<Hospital>> hm = new HashMap<>();
		hm.put(h1.hospitalName, hospital1);
		hm.put(h2.hospitalName, hospital2);
		hm.put(h3.hospitalName, hospital3);

		ary = filterDuplicateHospital(ary, hm);

		GetDoctorDetailsByHospital(hm);

		NearestHospital(ary);

		NearestHospitalByIllness(ary);

		NearestHospitalBySpecialization(ary);
	}

	public static ArrayList filterDuplicateHospital(ArrayList<Hospital> ary,HashMap<String, List<Hospital>> hm) {
		Scanner s = new Scanner(System.in);
		System.out.println("Available hospitals with doctors are");
		for (Hospital h : ary)
			System.out.println(h);

		System.out.println("enter the same hospital name and adresses");
		System.out.println("Enter Hospital Name:");
		String name = s.nextLine();
		System.out.println("Enter Hospital address1:");
		String address1 = s.nextLine();
		System.out.println("Enter Hospital address2:");
		String address2 = s.nextLine();
		System.out.println("Enter Hospital city:");
		String city = s.nextLine();
		System.out.println("Enter Hospital state:");
		String state = s.nextLine();
		System.out.println("Enter 5 digit zipcode:");
		int zip = s.nextInt();
		
		Address ad = new Address(address1, address2, city, state, zip);
		Doctor dr = new Doctor();
		Hospital h = new Hospital(name, dr, ad);
		if (ary.contains(h))
			System.out.println("Yes, the hospital is already present");
		else {
			System.out.println("No, we dont have that hospital inlist, Please enter the doctor details");
			System.out.println("Enter Doctor id:");
			int id = s.nextInt();
			s.nextLine();
			System.out.println("Enter Doctor name");
			String dname = s.nextLine();
			System.out.println("Enter Doctors Specialization");
			String spec = s.nextLine();
			dr = new Doctor(id, dname, spec);
			h = new Hospital(name, dr, ad);
			for (Map.Entry m : hm.entrySet()) {
				if (name.equalsIgnoreCase((String) m.getKey())) {
					ArrayList<Hospital> arry = (ArrayList<Hospital>) m.getValue();
					arry.add(h);
					hm.put(h.hospitalName,arry);
				}
			}
			ary.add(h);
		}

		return ary;
	}

	public static void GetDoctorDetailsByHospital(
			HashMap<String, List<Hospital>> hm) {
		System.out.println("Enter hospital name to get the doctor details ");
		Scanner s = new Scanner(System.in);
		String hname = s.nextLine();
		List<Hospital> b = hm.get(hname);
		if (b != null)
			for (Hospital h : b) {
				System.out.println("Doctor details: ");
				System.out.println("Name: " + h.doc.name);
				System.out.println("Specialization: "+ h.doc.specialization);
				System.out.println("Id: " + h.doc.docId + "\n");

			}
	}

	public static void NearestHospital(ArrayList<Hospital> ary) {
		System.out.println("\n get the nearest hospital\n");
		System.out.println("Enter zip code to get the nearest hospital");
		Scanner s = new Scanner(System.in);
		int zip = s.nextInt();
		int near = Integer.MAX_VALUE;
		Hospital hnear = new Hospital();
		if (Integer.toString(zip).length() != 5)
			System.out.println("Please enter 5 digits zipcode");
		else {
			for (Hospital h :ary) {
				if ((Math.abs(zip - h.hospitalAddress.zipCode)) < near) {
					near = Math.abs(zip - h.hospitalAddress.zipCode);
					hnear = h;
				}
			}
			System.out.println("Nearest hospital is " + (hnear));
		}
	}

	public static void NearestHospitalByIllness(ArrayList<Hospital> ary) {
		System.out.println("\n Enter your illness and zipcode to find the nearest hospital \n");
		System.out.println("Enter zipcode: ");
		Scanner s = new Scanner(System.in);
		int zip = s.nextInt();
		int near = Integer.MAX_VALUE;
		System.out.println("Enter illness");
		String illness = s.next();
		Hospital hnear = null;
		for (Hospital h : ary) {
			if (h.doc.specialization.equalsIgnoreCase(illness)) {
				if ((Math.abs(zip - h.hospitalAddress.zipCode)) < near) {
					near = Math.abs(zip - h.hospitalAddress.zipCode);
					hnear = h;
				}
			}
		}
		System.out.println(hnear);
	}

	public static void NearestHospitalBySpecialization(ArrayList<Hospital> ary) {
		System.out.println("\n Enter specialization to getndoctors with that specialization\n");
		Scanner s = new Scanner(System.in);
		String special = s.next();
		boolean b = true;
		for (Hospital h : ary) {
			if (h.doc.specialization.equalsIgnoreCase(special)) {
				b = false;
				System.out.println("Hospital: " + h.hospitalName + " has doctor " + h.doc.name+ " with your desired specialization  at " + h.hospitalAddress);
			}
		}
		if (b)
			System.out.println("No hospitals found with your required specifications");
	}

}

class Hospital {
	String hospitalName;
	Doctor doc;
	Address hospitalAddress;

	public Hospital(String hospitalName, Doctor doc, Address hospitalAddress) {
		super();
		this.hospitalName = hospitalName;
		this.doc = doc;
		this.hospitalAddress = hospitalAddress;
	}

	public Hospital() {
		}

	@Override
	public String toString() {
		return "\n hospitalName=" + hospitalName + ",\n " + doc
				+ ",\n hospitalAddress=" + hospitalAddress ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((hospitalAddress == null) ? 0 : hospitalAddress.hashCode());
		result = prime * result
				+ ((hospitalName == null) ? 0 : hospitalName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hospital other = (Hospital) obj;
		if (hospitalAddress == null) {
			if (other.hospitalAddress != null)
				return false;
		} else if (!hospitalAddress.equals(other.hospitalAddress))
			return false;
		if (hospitalName == null) {
			if (other.hospitalName != null)
				return false;
		} else if (!hospitalName.equals(other.hospitalName))
			return false;
		return true;
	}

}

class Doctor {
	int docId;
	String name;
	String specialization;

	public Doctor() {

	}

	public Doctor(int docId, String name, String specialization) {
		super();
		this.docId = docId;
		this.name = name;
		this.specialization = specialization;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + docId;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((specialization == null) ? 0 : specialization.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Doctor other = (Doctor) obj;
		if (docId != other.docId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (specialization == null) {
			if (other.specialization != null)
				return false;
		} else if (!specialization.equals(other.specialization))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "id =" + docId + ",\n name=" + name
				+ ",\n specialization=" + specialization ;
	}

}

class Address {
	String address1;
	String address2;
	String city;
	String state;
	int zipCode;

	public Address(String address1, String address2, String city, String state,
			int zipCode) {
		super();
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((address1 == null) ? 0 : address1.hashCode());
		result = prime * result
				+ ((address2 == null) ? 0 : address2.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + zipCode;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (address1 == null) {
			if (other.address1 != null)
				return false;
		} else if (!address1.equals(other.address1))
			return false;
		if (address2 == null) {
			if (other.address2 != null)
				return false;
		} else if (!address2.equals(other.address2))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (zipCode != other.zipCode)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return " \n "+ address1 + ",\n address2=" + address2+ ",\n city=" + city + ", \n state=" + state + ",\n zipCode="+ zipCode ;
	}

}
