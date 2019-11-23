package interfaces;

import logic.Game;

public interface GamePrinter {
	String toString(Game game);
	public GamePrinter parse(String name);
	public String helpText();
}
