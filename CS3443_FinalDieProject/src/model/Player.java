package model;

public class Player {
	
	private String name;
	private int turnscore;
	private int totalscore;
	
	public Player(String name) {
		
		this.name = name;
		turnscore = 0;
		totalscore = 0;
	}
	
	public String getName() {
		return name;
	}
	
	public int getTotalScore() {
		return totalscore;
	}
	
	public int getTurnScore() {
		
		return turnscore;
	}
	
	public void resetTurnScore() {
		turnscore = 0;
	}
	public void updateTurn(int roll) {
		turnscore += roll;
	}
	
	public void saveScore() {
		totalscore += turnscore;
		resetTurnScore();
		
	}
	
	public static void main(String[] args) {
		
		Die die = new Die(6, 1);
		Player player = new Player("Adrian");
		System.out.println("Turn score " + player.getTurnScore());
		System.out.println("Turn score " + player.getTotalScore());
		System.out.println("Rolling");
		for(int i = 0; i < 10; i++) {
			die.roll();
			player.updateTurn(die.getTop());
			System.out.println("Turn score " + player.getTurnScore());
			System.out.println("Turn score " + player.getTotalScore());
			
		}
		player.saveScore();
		System.out.println("Saving");
		System.out.println("Turn score " + player.getTurnScore());
		System.out.println("Turn score " + player.getTotalScore());
	}

}
