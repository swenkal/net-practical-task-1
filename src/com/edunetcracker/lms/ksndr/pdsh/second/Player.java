package com.edunetcracker.lms.ksndr.pdsh.second;

public class Player {
	
	private String name;
	private int currentPoints = 0;
	private int wins = 0;
	
	public Player(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCurrentPoints() {
		return currentPoints;
	}

	public void setCurrentPoints(int currentPoints) {
		this.currentPoints = currentPoints;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}
	
	
}
