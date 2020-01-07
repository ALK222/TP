package utils;

import interfaces.GamePrinter;
import logic.Game;

public class Stringifier implements GamePrinter {

    final String space = " ";
    
    private String board = "";

	public Stringifier(Game game) {
		encodeGame(game);
	}

	public void encodeGame(Game game) {
		for (int i = 0; i < Game.DIM_X; i++) {
			for (int j = 0; j < Game.DIM_Y; j++) {
                board += game.stringify(i, j);
			}
		}
	}

	public String toString(Game game) {

		String stringify = "— Space Invaders v2.0 —";
		stringify += "\n" + "Seed: " + game.getSeed();
		stringify += "\n \n";
		stringify += "C: ";
		stringify += game.getCurrentCycle();
		stringify += "\nL: ";
		stringify += game.getLevel().toString();
		stringify += "\n";
		stringify += board;
		return stringify;
	}

}
