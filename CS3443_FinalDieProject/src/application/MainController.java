package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Stage;
import model.Game;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;

public class MainController<VBOX> {
	
	Game dice;
	@FXML
	private AnchorPane mainPane;
	@FXML
	GridPane grid1 = new GridPane();
	
	@FXML
	GridPane grid2 = new GridPane();
	
	@FXML
	ImageView dieImage;
	
	@FXML
	Button rollButton;
	
	@FXML
	Button holdButton;
	
	@FXML
	TextField player1turn;
	
	@FXML
	TextField player2turn;
	
	@FXML
	TextField player1total;
	
	@FXML
	TextField player2total;
	
	@FXML
	VBOX player1box;
	
	@FXML
	VBOX player2box;
	
	@FXML
	Label title;
	
	private Spin clock;
	
	private class Spin extends AnimationTimer{

		private long FRAME_PER_SEC = 50L;
		private long INTERVAL = 1000000000L / FRAME_PER_SEC;
		private int MAX_SPIN = 10;
		private long last = 0;
		
		
		@Override
		public void handle(long n) {
			if(n - last > INTERVAL) {
				int r = 2 + (int)(Math.random()*5);
				setdieImage(r);
				last = n;
				int count = 0;
				count++;
				if(count > MAX_SPIN) {
					clock.stop();
					roll();
					count = 0;
				}
			}
			
		}
		
	}

	@FXML
	public void initialize() {
		clock = new Spin();
		dice = new Game("Player 1", "Player 2");
		setdieImage(dice.getDie().getTop());
		
		rollButton.setOnAction(event -> roll());
		holdButton.setOnAction(event -> hold());
		
		update();
	}
	
	public void update() {
		
		player1turn.setText("" + dice.getPlayer1().getTurnScore());
		player1total.setText("" + dice.getPlayer1().getTotalScore());
		player2turn.setText("" + dice.getPlayer2().getTurnScore());
		player2total.setText("" + dice.getPlayer2().getTotalScore());
		
		if(dice.player1Turn()) {
		 ((Region) player1box).setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
		 ((Region) player2box).setBackground(null);
		 
		}
		else {
		((Region) player2box).setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
	    ((Region) player1box).setBackground(null);
		}
		
		if(dice.GameOver()) {
			title.setText("Game Over! " + dice.getCurrent().getName()+ " is the Winner!");
			
		}
		
	}

	public void setdieImage(int top) {

		
		File f = new File("./Images/Dice0.png");
		dieImage.setImage(new Image(f.toURI().toString()));
		
		
	}
	
	
	public void spinAnim() {
		clock.start();
		}
	private void roll() {
		
		dice.roll();
		update();
	}
	private void hold() {
		dice.hold();
		update();
	}
	
	

}
