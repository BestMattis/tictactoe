

import org.fulib.Fulib;
import org.fulib.builder.ClassBuilder;
import org.fulib.builder.ClassModelBuilder;
import org.fulib.classmodel.ClassModel;
import org.junit.*;

public class GenModelTest {
	@Test
	public void testModel() {
		ClassModelBuilder mb = Fulib.classModelBuilder("de.uniks.tictactoe.model");
		ClassBuilder game = mb.buildClass("Game").buildAttribute("name", ClassModelBuilder.STRING);
		ClassBuilder player = mb.buildClass("Player").buildAttribute("name", ClassModelBuilder.STRING)
				.buildAttribute("symbol", ClassModelBuilder.STRING);
		ClassBuilder playingFieldBlock = mb.buildClass("PlayingFieldBlock").buildAttribute("owned", ClassModelBuilder.BOOLEAN)
				.buildAttribute("xPos", ClassModelBuilder.DOUBLE).buildAttribute("YPos", ClassModelBuilder.DOUBLE);
		ClassBuilder symbol = mb.buildClass("Symbol");
		
		game.buildAssociation(player, "players", ClassModelBuilder.MANY, "game", ClassModelBuilder.ONE);
		game.buildAssociation(player, "winner", ClassModelBuilder.ONE, "gameWon", ClassModelBuilder.ONE);
		game.buildAssociation(player, "currentPlayer", ClassModelBuilder.ONE, "currentGame", ClassModelBuilder.ONE);

		game.buildAssociation(playingFieldBlock, "playingFieldBlocks", ClassModelBuilder.MANY, "game", ClassModelBuilder.ONE);

		player.buildAssociation(symbol, "symbols", ClassModelBuilder.MANY, "player", ClassModelBuilder.ONE);

		player.buildAssociation(playingFieldBlock, "playingFieldBlocks", ClassModelBuilder.MANY, "player", ClassModelBuilder.ONE);

		playingFieldBlock.buildAssociation(playingFieldBlock, "neightbors", ClassModelBuilder.MANY, "neightbors", ClassModelBuilder.MANY);

		playingFieldBlock.buildAssociation(symbol, "symbol", ClassModelBuilder.ONE, "playingFieldBlock", ClassModelBuilder.ONE);

		ClassModel model = mb.getClassModel();
		Fulib.generator().generate(model);
	}
}
