package com.edunetcracker.lms.ksndr.pdsh.second;

public class Craps {
	
	private int round = 1;
	private int winCondition = 7;
	private Player[] players;
	private Cube[] cubes;
	
	//initializing when we only know 
	//the numbers N and K (as in task condition)
	public Craps(int playersCount, int cubesCount) {
		
		players = new Player[playersCount];
		
		//first player in start always you
		players[0] = new Player("Host(you)"); 
		
		for (int i = 1; i < playersCount - 1; i++) {
			players[i] = new Player("Player" + (i+1));
		}
		//last player in the start always Computer
		players[playersCount - 1] = new Player("Computer");
		
		cubes = new Cube[cubesCount];
		for (int i = 0; i < cubesCount; i++) {
			cubes[i] = new Cube();
		}
	}
	
	public void startGame() {
		
		hello();
		
		while (checkAllGameWinner() == -1) {
			playRound();
		}
	}
	
	//before playing first round 
	public void hello() {
		
		System.out.println("*****WELCOME TO THE CRAPS*****");
		System.out.println("Today we play: ");
		System.out.println("\t- with " + cubes.length + " cubes!");
		System.out.println("\t- with " + players.length + " players!");
		
		System.out.println("Players: ");
		for (int i = 0; i < players.length - 1; i++) {
			System.out.print(players[i].getName() + ", ");
		}
		
		System.out.println(players[players.length - 1].getName() );
		System.out.println("*****WE READY TO START*****");
	}
	
	public int checkAllGameWinner() {
		
		//first player is the last round winner
		if (round < winCondition || players[0].getWins() < winCondition) {
			return -1;
		}
		
		//all game winner could be only player, who win last round
		System.out.println();
		System.out.println("*****WE GET GAME WINNER*****");
		System.out.println("Player \"" + players[0].getName() + 
							"\" is the all game winner!");
		System.out.println("*****CONGRATULATIONS*****");
		return 0;
	}
	
	//each player castCubes. get position of round winner in array "players"
	// 
	public void playRound() {
		
		System.out.println();
		System.out.println("***** ROUND " + round + " *****");
		for (int i = 0; i < players.length; i++) {
			setTotalPointsForPlayer(players[i]);
		}
		
		replaceRoundWinner(getRoundWinnerPosition());
		round++;
	}
	
	//cast K cubes, calculate totalPoints and assign to current Player
	private void setTotalPointsForPlayer(Player p) {
		
		int totalPoints = 0;
		for (int i = 0; i < cubes.length; i++) {
			totalPoints += cubes[i].castCube();
		}
		
		p.setCurrentPoints(totalPoints);
		
		System.out.println(p.getName() + " cast\t" + totalPoints + " pts");
	}
	
	//get max points for players in the round
	//assumption (when points are equal): round winner becomes
	//the first player who score the max points in the round
	private int getRoundWinnerPosition() {
		int winnerPosition = 0;
		int winnerPoints = players[0].getCurrentPoints();
		
		for (int i = 1; i < players.length; i++) {
			int playerPoints = players[i].getCurrentPoints();
			
			if (playerPoints > winnerPoints) {
				winnerPoints = playerPoints;
				winnerPosition = i;
			}
		}
		
		Player winner = players[winnerPosition];
		winner.setWins(winner.getWins() +1);
		System.out.println("Round winner is \"" + winner.getName() + "\"");
		
		return winnerPosition;
	}
	
	//round winner should always be in the first place 
	private void replaceRoundWinner(int winnerPosition) {
		Player temp = players[winnerPosition];
		players[winnerPosition] = players[0];
		players[0] = temp;
	}
	
}
