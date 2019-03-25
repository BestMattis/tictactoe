package de.uniks.tictactoe;

import java.util.ArrayList;

import de.uniks.tictactoe.model.Player;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StartScreenController {

	@FXML
	AnchorPane bg;
	@FXML
	VBox mainStack;
	@FXML
	Label topLabel;
	@FXML
	TextField nameField;
	@FXML
	VBox buttonStack;
	@FXML
	Button startButton;
	@FXML
	RadioButton symbolButton1;
	@FXML
	RadioButton symbolButton2;
	
	private static final String IDLE_BUTTON_STYLE = "-fx-background-color: #333333; -fx-text-fill: white; -fx-border-color: white; -fx-border-radius: 3";
    private static final String HOVERED_BUTTON_STYLE = "-fx-background-color: #555555; -fx-text-fill: white; -fx-border-color: white; -fx-border-radius: 3";
    
	public void initialize() {
		Player player = new Player();
		Player player2 = new Player().setName("NPC");
		nameField.textProperty().addListener((observable, oldValue, newValue) -> {
			try {
				player.setName(newValue);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		ToggleGroup group = new ToggleGroup();
		symbolButton1.setToggleGroup(group);
		symbolButton1.setSelected(true);
		symbolButton2.setToggleGroup(group);
		
		startButton.setOnMouseEntered(e -> startButton.setStyle(HOVERED_BUTTON_STYLE));
		startButton.setOnMouseExited(e -> startButton.setStyle(IDLE_BUTTON_STYLE));
		startButton.setOnAction(e -> {
			
			if (group.getSelectedToggle() == symbolButton1) {
				player.setSymbol("X");
				player2.setSymbol("O");
			} else if(group.getSelectedToggle() == symbolButton2) {
				player.setSymbol("O");
				player2.setSymbol("X");
			}
			Model.getInstance().setGamePlayer(player,player2);
			Stage stage = Model.getInstance().getStage();
			
			FXMLLoader fxmlLoader = new FXMLLoader(StartedGameController.class.getResource("startedGame.fxml"));
			try {
				Parent parent = fxmlLoader.load();
				Scene scene = new Scene(parent,600,600);
				stage.setScene(scene);
				stage.setTitle("TicTacToe");
				Model.getInstance().setStage(stage);
				stage.show();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			
		});
		
		
	}
		
}
