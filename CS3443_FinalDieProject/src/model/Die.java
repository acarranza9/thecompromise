package model;

public class Die {

	//Data Fields
	private int sides;
	private int top;
	
	public Die(int sides, int top){
		
		this.sides = sides;
		this.top = top;
	}
	
	public Die() {
		sides = 6;
		top = 0;
	}
	
	public int getTop() {
	
		return top;
	}
	public void setTop(int top) {
		
	if(top >= 0 && top <= sides) {
		this.top = top;
		
	}	
}
	public void roll() {
		top = 1 +(int)(Math.random() * sides);
		
	}
	public static void main (String[] args) {
		
		Die die = new Die(6, 0);
		
		System.out.println(die.getTop());
		
		for(int i = 0; i < 10; i++) {
			
		die.roll();
		System.out.println(i + ": " + die.getTop());
		}
	}
}

