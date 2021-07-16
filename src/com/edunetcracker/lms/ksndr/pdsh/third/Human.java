package com.edunetcracker.lms.ksndr.pdsh.third;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Human {
	
	private String firstName;
	private String lastName;
	private Calendar bDay;
	private Address address;
	
	public Human(String firstName, String lastName, Calendar bDay, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.bDay = bDay;
		this.address = address;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Calendar getbDay() {
		return bDay;
	}
	public void setbDay(Calendar bDay) {
		this.bDay = bDay;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address adress) {
		this.address = adress;
	}
	
	public static Human[] findByLastName(Human[] humans, String lastName) {
		
		int findCount = 0;
		
		for (int i = 0; i < humans.length; i++) {
			
			if(lastName == humans[i].getLastName()) {
				//move finded  human to begin array for continue copy
				Human temp = humans[i];
				humans[i] = humans[findCount];
				humans[findCount] = temp;
				findCount++;
			}
		}
		
		if (findCount == 0) {
			return null;
		}
		//array with only finded humans 
		Human[] findedHumans = new Human[findCount];
		System.arraycopy(humans, 0, findedHumans, 0, findCount);
		return findedHumans;
	}
	
	public static Human[] findByPostalCode(Human[] humans, int postalCode) {
		
		int findCount = 0;
		
		for (int i = 0; i < humans.length; i++) {
			
			if(postalCode == humans[i].getAddress().getPostalCode()) {
				Human temp = humans[i];
				humans[i] = humans[findCount];
				humans[findCount] = temp;
				findCount++;
			}
		}
		
		if (findCount == 0) {
			return null;
		}
		
		Human[] findedHumans = new Human[findCount];
		System.arraycopy(humans, 0, findedHumans, 0, findCount);
		return findedHumans;
	}
	
	//human date must be equal or greater for Calendar start, but equal or less for Calendar end
	public static Human[] findBirthDayBetween(Human[] humans, Calendar start, Calendar end) {
		int findCount = 0;
		
		for (int i = 0; i < humans.length; i++) {
			Calendar bDay = humans[i].getbDay();
			
			if(bDay.compareTo(start) >= 0 && bDay.compareTo(end) <= 0) {
				Human temp = humans[i];
				humans[i] = humans[findCount];
				humans[findCount] = temp;
				findCount++;
			}			
		}
		
		if (findCount == 0) {
			return null;
		}
		
		Human[] findedHumans = new Human[findCount];
		System.arraycopy(humans, 0, findedHumans, 0, findCount);
		return findedHumans;		
	}
	
	public static Human findOlder(Human[] humans) {
		
		Human older = humans[0];
		for (int i = 1; i < humans.length; i++) {
			
			Calendar curBDay = humans[i].getbDay();
			if (older.getbDay().compareTo(curBDay) > 0) {
				older = humans[i];
			}
		}
		return older;	
	}
	
	public static Human findYounger(Human[] humans) {
		Human younger = humans[0];
		for (int i = 1; i < humans.length; i++) {
			
			Calendar curBDay = humans[i].getbDay();
			if (younger.getbDay().compareTo(curBDay) < 0) {
				younger = humans[i];
			}
		}
		return younger;	
	}
	
	public static Human[] findByStreet(Human[] humans, String streetName) {
		int findCount = 0;
		
		for (int i = 0; i < humans.length; i++) {
			
			if(streetName == humans[i].getAddress().getStreet()) {
				Human temp = humans[i];
				humans[i] = humans[findCount];
				humans[findCount] = temp;
				findCount++;
			}
		}
		
		if (findCount == 0) {
			return null;
		}
		
		Human[] findedHumans = new Human[findCount];
		System.arraycopy(humans, 0, findedHumans, 0, findCount);
		return findedHumans;
	}
	
	public static void print(Human[] humans) {
		
		if (humans == null) {
			System.out.println("No humans for print!");
			return;
		}
		
		for (int i = 0; i < humans.length; i++) {
			System.out.print(humans[i].getFirstName() + " ");
			System.out.print(humans[i].getLastName() + " ");
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			System.out.print(sdf.format(humans[i].getbDay().getTime()) + " ");
			System.out.println(humans[i].getAddress().toString());
		}
	}
	
}