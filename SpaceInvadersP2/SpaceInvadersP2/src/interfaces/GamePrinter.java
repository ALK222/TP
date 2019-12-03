package interfaces;

import logic.Game;

public interface GamePrinter {
	public String toString(Game game);
	public GamePrinter parse(String name);
	public String helpText();
	public void setGame(Game game);
}
