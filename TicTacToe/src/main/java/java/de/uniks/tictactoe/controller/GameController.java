package de.uniks.tictactoe.controller;

//import de.uniks.NonPlayerCharacter;
import de.uniks.tictactoe.model.Game;
import de.uniks.tictactoe.model.Player;
import de.uniks.tictactoe.model.PlayingFieldBlock;

public class GameController {
	Player NPC = new Player();
	int[][] possiblePos = {{0,0},{175,0},{350,0},{525,0},
						   {-30,120},{145,120},{320,120},{495,120},
						   {0,240},{175,240},{350,240},{525,240},
						   {-30,360},{145,360},{320,360},{495,360},
						   {0,480},{175,480},{350,480},{525,480}};
	//static ArrayList<NonPlayerCharacter> npcList = new ArrayList<NonPlayerCharacter>();
	public Game init(Player ... player) {
		Game game = new Game().withPlayers(player);
		game.withPlayers(NPC);
		game.setCurrentPlayer(player[0]);
		PlayingFieldBlock p1 = new PlayingFieldBlock();
		PlayingFieldBlock p2 = new PlayingFieldBlock();
		PlayingFieldBlock p3 = new PlayingFieldBlock();
		PlayingFieldBlock p4 = new PlayingFieldBlock();
		PlayingFieldBlock p5 = new PlayingFieldBlock();
		PlayingFieldBlock p6 = new PlayingFieldBlock();
		
		return game;
	}
}
