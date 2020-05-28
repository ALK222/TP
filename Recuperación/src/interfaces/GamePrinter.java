package interfaces;

import logic.Game;

public interface GamePrinter {
	public String toString(Game game);

	public void encodeGame(Game game);
}