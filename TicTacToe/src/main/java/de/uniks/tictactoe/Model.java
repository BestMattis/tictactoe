package de.uniks.tictactoe;

import de.uniks.tictactoe.controller.GameController;
import de.uniks.tictactoe.model.Player;
import de.uniks.tictactoe.Model;
import de.uniks.tictactoe.model.Game;
import de.uniks.tictactoe.model.PlayingFieldBlock;
import javafx.stage.Stage;

public class Model {
	Stage stage;
	private static Model instance;
	private static Game game;
	private PlayingFieldBlock platformNew;
	private PlayingFieldBlock platformOld;
	
	private Model() {
	}
	public void setStage(Stage stage) {
	 this.stage = stage;
	}
	public Stage getStage() {
		return this.stage;
	}
	
	public static Model getInstance() {
		if(instance == null) {
			instance = new Model();
		}
		return instance;
	}
	public Game setGamePlayer(Player player) {
		GameController gc = new GameController();
		if(this.game == null) {
			this.game = gc.init(player);
		}
		return this.game;
	}
}
