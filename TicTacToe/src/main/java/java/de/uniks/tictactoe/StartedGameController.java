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

public class StartedGameController {
	
	@FXML
	Button p1;
	@FXML
	Button p2;
	@FXML
	Button p3;
	@FXML
	Button p4;
	@FXML
	Button p5;
	@FXML
	Button p6;
	@FXML
	Button p7;
	@FXML
	Button p8;
	@FXML
	Button p9;
	private static final String IDLE_BUTTON_STYLE = "-fx-background-color: #333333; -fx-text-fill: white; -fx-border-color: white; -fx-border-radius: 3";
    private static final String HOVERED_BUTTON_STYLE = "-fx-background-color: #555555; -fx-text-fill: white; -fx-border-color: white; -fx-border-radius: 3";
    
	ArrayList<Button> buttons = new ArrayList<Button>();
	public void initialize() {
		buttons.add(p1);buttons.add(p2);buttons.add(p3);buttons.add(p4);buttons.add(p5);
		buttons.add(p6);buttons.add(p7);buttons.add(p8);buttons.add(p9);
		for(Button b : buttons) {
			b.setOnMouseEntered(e -> b.setStyle(HOVERED_BUTTON_STYLE));
			b.setOnMouseExited(e -> b.setStyle(IDLE_BUTTON_STYLE));
			b.setOnAction(e -> {
				
			b.setText(Model.getInstance().getGame().getCurrentPlayer().getSymbol());
			if(Model.getInstance().getGame().getPlayers().get(0) != Model.getInstance().getGame().getCurrentPlayer()) {
				Model.getInstance().getGame().setCurrentPlayer(Model.getInstance().getGame().getPlayers().get(0));
			} else {
				Model.getInstance().getGame().setCurrentPlayer(Model.getInstance().getGame().getPlayers().get(1));
			}
			
			});
		}
	}
}
