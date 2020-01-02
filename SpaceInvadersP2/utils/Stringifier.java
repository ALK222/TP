package utils;

import interfaces.GamePrinter;
import logic.Game;

public class Stringifier implements GamePrinter {

	final String space = " ";

	public Stringifier(Game game) {
		encodeGame(game);
	}

	private String encodeGame(Game game) {
		String board = "";
		for (int i = 0; i < Game.DIM_X; i++) {
			for (int j = 0; j < Game.DIM_Y; j++) {
				board += game.stringify(i, j);
			}
		}
		return board;
	}

	public Stringifier() {

	}

	@Override
	public String toString(Game game) {

		String stringify = "— Space Invaders v2.0 —";
		stringify += "\n \n";
		stringify += "C: ";
		stringify += game.getCurrentCycle();
		stringify += "\nL: ";
		stringify += game.getLevel().toString();
		stringify += "\n";
		stringify += encodeGame(game);
		return stringify;
	}

	@Override
	public GamePrinter parse(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String helpText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setGame(Game game) {
		// TODO Auto-generated method stub

	}

}
