package com.edunetcracker.lms.ksndr.pdsh.third;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class HumanAddressMain {

	public static void main(String[] args) {
		
		Address moscow = new Address("Russia", "Moscow", "st. Red Square 1", 123456);
		Address tula = new Address("Russia", "Tula", "st. Sovetskaya 5", 654321);
		Address minsk = new Address("Belarus", "Minsk", "st. Pobedi 7", 432156);
		
		Calendar birthDay1 = new GregorianCalendar(1995, 0, 1);
		Calendar birthDay2 = new GregorianCalendar(1977, 3, 4);
		Calendar birthDay3 = new GregorianCalendar(1979, 9, 28);
		Calendar birthDay4 = new GregorianCalendar(1982, 7, 14);
		
		Human alex = new Human("Alex", "Ivanov", birthDay1, minsk);
		Human lexo = new Human("Lexo", "Petrov", birthDay2, tula);
		Human kris = new Human("Kris", "Smirnova", birthDay3, minsk);
		Human olya = new Human("Olya", "Smirnova", birthDay4, moscow);
		
		Human[] humans = {alex, lexo, kris, olya};
		System.out.println("Initialized Human array:");
		Human.print(humans);
		System.out.println();
		
		
		System.out.println("***findByLastName***");
		Human[] findedByLastName = Human.findByLastName(humans, "Kurtov");
		Human.print(findedByLastName);
		
		findedByLastName = Human.findByLastName(humans, "Smirnova");
		Human.print(findedByLastName);
		System.out.println("******************");
				
		System.out.println("***findByPostalCode***");
		Human[] findedByPostalCode = Human.findByPostalCode(humans, 0);
		Human.print(findedByPostalCode);
	
		findedByPostalCode = Human.findByPostalCode(humans, 123456);
		Human.print(findedByPostalCode);
		System.out.println("******************");
		
		System.out.println("***findBirthDayBetween***");
		Calendar birthDay5 = new GregorianCalendar(1977, 3, 5);
		Calendar today = new GregorianCalendar();
		Human[] findedByCalendarRange = Human.findBirthDayBetween(humans, birthDay5, today);
		Human.print(findedByCalendarRange);
		System.out.println("******************");
		
		System.out.println("***findOlder***");
		Human older = Human.findOlder(humans);
		System.out.println("Older human is: " + older.getFirstName() + " " + older.getLastName());
		System.out.println("******************");
		
		System.out.println("***findYounger***");
		Human younger = Human.findYounger(humans);
		System.out.println("Younger human is: " + younger.getFirstName() + " " + younger.getLastName());
		System.out.println("******************");
		
		System.out.println("***findByStreet***");
		Human[] findedByStreet = Human.findByStreet(humans, "st. Pobedi 7");
		Human.print(findedByStreet);
		System.out.println("******************");
	}

}
