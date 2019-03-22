package de.uniks.tictactoe;

import java.util.ArrayList;

import de.uniks.tictactoe.model.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
	
	private static final String IDLE_BUTTON_STYLE = "-fx-background-color: #333333; -fx-text-fill: white; -fx-border-color: white; -fx-border-radius: 3";
    private static final String HOVERED_BUTTON_STYLE = "-fx-background-color: #555555; -fx-text-fill: white; -fx-border-color: white; -fx-border-radius: 3";
	
	public void initialize() {
		Player player = new Player();
		nameField.textProperty().addListener((observable, oldValue, newValue) -> {
			try {
				player.setName(newValue);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		startButton.setOnMouseEntered(e -> startButton.setStyle(HOVERED_BUTTON_STYLE));
		startButton.setOnMouseExited(e -> startButton.setStyle(IDLE_BUTTON_STYLE));
		startButton.setOnAction(e -> {
			
			Model.getInstance().setGamePlayer(player);
			Stage stage = Model.getInstance().getStage();
			
		});
		
		
	}
		
}
