package model;

public class Game{
	
	private Die die;
	private Player player1;
	private Player player2;
	private Player current;
	public static final int maxscore = 100;
	
	public Game(String player1Name, String player2Name) {
		
		die = new Die(6,1);
		player1 = new Player(player1Name);
		player2 = new Player(player2Name);
		
		current = player1;
		
		
	}
	
	public Die getDie() {
		return die;
	}
	public Player getCurrent() {
		return current;
	}
	public Player getPlayer1() {
		return player1;
	}
	public Player getPlayer2() {
		return player2;
	}
	
	public boolean GameOver() {
		
		return current.getTotalScore() >= maxscore;
	}
	public boolean player1Turn() {
		return current == player1;
	}
	
	public void switchPlayer() {
		if(player1Turn()) {
			current = player2;
		}
		else {
			current = player1;
		}
		
	}
	public void roll() {
		die.roll();
		int t = die.getTop();
		current.updateTurn(t);
		/*if(t == 1) {
			current.resetTurnScore();
			switchPlayer();
			*/
		}
	
	public void hold() {
		current.saveScore();
		switchPlayer();
		die.setTop(0);
		
	}
	
	public static void main(String[] args) {
		Game game = new Game("", "");
		for( int i = 0 ; i < 10; i++) {
	
		game.roll();
		game.hold();
		System.out.println("Die Rolled " + game.getDie().getTop());
		System.out.println("Player 1 Turn: " + game.getPlayer1().getTurnScore());
		System.out.println("Player 1 Total: " + game.getPlayer1().getTotalScore());
		System.out.println("Player 2 Turn: " + game.getPlayer2().getTurnScore());
		System.out.println("Player 2 Total: " + game.getPlayer2().getTotalScore());
		}
		
	}
	
}
