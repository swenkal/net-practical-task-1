package com.edunetcracker.lms.ksndr.pdsh.first;

public class MainQuadratic {

	public static void main(String[] args) {
		
		try {
			
			System.out.println("equation x^2 - 2x - 3"); 
			Quadratic quadratic1 = new Quadratic(1.0, -2.0, -3.0);
			quadratic1.getSolutions();
			
			System.out.println("equation x^2 - 7x");
			Quadratic quadratic2 = new Quadratic(1.0, -7.0);
			quadratic2.getSolutions();
			
			System.out.println("equation 5x^2 - 30"); 
			Quadratic quadratic3 = new Quadratic(5.0, 0, 30.0);
			quadratic3.getSolutions();
			
			System.out.println("equation 4x^2 - 9"); 
			Quadratic quadratic4 = new Quadratic(4.0, 0, -9.0);
			quadratic4.getSolutions();
			
			//incorrect value for quadratic equation
			System.out.println("equation 0x^2 - 1.1"); 
			Quadratic quadratic5 = new Quadratic(0, 1.1);
			quadratic5.getSolutions();
			
		} catch (IncorrectArgumentForQuadratic e) {
			
			e.printStackTrace();	
		}
	}
}
