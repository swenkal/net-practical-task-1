package com.edunetcracker.lms.ksndr.pdsh.second;

public class Cube {
	
	private int points;
	
	public Cube() {
		points = castCube();
	}

	public int castCube() {
		//in cube 6 value so range 1 to 6
		points = 1 + (int) (Math.random() * 6);
		return points;
	}
	
	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	
}
