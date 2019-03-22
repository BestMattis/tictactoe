package de.uniks.tictactoe.controller;

import de.uniks.tictactoe.Model;
import de.uniks.tictactoe.StartScreenController;
import de.uniks.tictactoe.model.Player;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TicTacToeMain extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		
		FXMLLoader fxmlLoader = new FXMLLoader(StartScreenController.class.getResource("startScreen.fxml"));
		try {
			Parent parent = fxmlLoader.load();
			Scene scene = new Scene(parent,500,500);
			stage.setScene(scene);
			stage.setTitle("TicTacToe");
			Model.getInstance().setStage(stage);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
