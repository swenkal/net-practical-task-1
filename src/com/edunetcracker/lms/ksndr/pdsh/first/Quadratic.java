package com.edunetcracker.lms.ksndr.pdsh.first;

public class Quadratic {
	
	//equation coefficient's
	private double a; //coef at x^2
	private double b; //coef at x
	private double c; //free coef
	
	public Quadratic() {
		this.a = 1;
		this.b = 0;
		this.c = 0;
	}
	
	//coef at x^2 must not equal to zero
	public Quadratic(double a) throws IncorrectArgumentForQuadratic {
		if (a == 0) {
			throw new IncorrectArgumentForQuadratic("Coefficient at x^2 must not equal to zero");
		}
		this.a = a;
		this.b = 0;
		this.c = 0;
	}
	
	//Overload constructor for initializing 2 coef's
	public Quadratic(double a, double b) throws IncorrectArgumentForQuadratic {
		this(a);
		this.b = b;
	}
	
	//Overload constructor for initializing 3 coef's
	public Quadratic(double a, double b, double c) throws IncorrectArgumentForQuadratic {
		this(a, b);
		this.c = c;
	}
	
	public void getSolutions() {
		
		DiscriminantCalculator dCalculator = this.new DiscriminantCalculator();
		double discriminant = dCalculator.calculateDiscriminant();
		double firstRoot;
		double secondRoot;
		
		if (discriminant < 0) {
			System.out.println("Quadratic equation has NO solutions.");
			return;
		}
		
		if (discriminant == 0) {
			firstRoot = calculateFirstRoot(discriminant);
			System.out.println("Quadratic equation has one solution. x1 = " + firstRoot);
			return;
		}
		
		firstRoot = calculateFirstRoot(discriminant);
		secondRoot = calculateSecondRoot(discriminant);
		System.out.println("Quadratic equation has two solutions. x1 = " + firstRoot + " x2 = " + secondRoot);
		
	}	
	
	private double calculateFirstRoot(double discriminant) {
		
		return ((-b) + Math.sqrt(discriminant)) / (2 * a);
				
	}
	
	private double calculateSecondRoot(double discriminant) {
		
		return ((-b) - Math.sqrt(discriminant)) / (2 * a);
		
	}
	
	class DiscriminantCalculator {
		
		public double calculateDiscriminant() {
			return Math.pow(b, 2) - 4 * a * c;
		}	
	} 	
}
