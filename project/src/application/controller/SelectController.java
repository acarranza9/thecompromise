package application.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import application.model.Person;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class SelectController {

	private ArrayList<Person> personList;
	
    @FXML
    private AnchorPane mainPane;

    @FXML
    void onClickTicTaToe(MouseEvent event) {

    	try {
        	URL url = new File("src/application/view/TicTacToe.fxml").toURI().toURL();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(url);
            AnchorPane newPane = (AnchorPane)loader.load();
            Scene scene = new Scene(newPane);

            TicTacToeController controller = loader.getController();
            controller.initializeData(personList);
            
            Stage currWindow = (Stage) ((Node)event.getSource()).getScene().getWindow();
            //currWindow.hide();
            
            Stage window = new Stage();
            window.initModality(Modality.APPLICATION_MODAL);
            window.setScene(scene);
            window.showAndWait();
            
        } catch (IOException e) {
        	
        	e.printStackTrace();
        }
    	
    }

    @FXML
    void onClickDice(MouseEvent event) {

    	try {
        	URL url = new File("src/application/view/Dice.fxml").toURI().toURL();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(url);
            AnchorPane newPane = (AnchorPane)loader.load();
            Scene scene = new Scene(newPane);

            DiceController controller = loader.getController();
            controller.initializeData(personList);
            
            Stage currWindow = (Stage) ((Node)event.getSource()).getScene().getWindow();
            //currWindow.hide();
            
            Stage window = new Stage();
            window.initModality(Modality.APPLICATION_MODAL);
            window.setScene(scene);
            window.showAndWait();
            
        } catch (IOException e) {
        	
        	e.printStackTrace();
        }
    }

    @FXML
    void onClickConnect(MouseEvent event) {

    }

    @FXML
    void onClickGuessing(MouseEvent event) {

    }
    
    public void initializeData(ArrayList<Person> personList) {
    	
    	this.personList = personList;
    }
}
