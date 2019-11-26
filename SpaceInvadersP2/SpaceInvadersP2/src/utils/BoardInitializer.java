package utils;

import Objects.*;
import logic.Game;

public class BoardInitializer {
	
	private Level level;
	private GameObjectBoard board;
	private Game game;
	
	public  GameObjectBoard initialize(Game game, Level level) {
		this.level = level;
		this.game = game;
		board = new GameObjectBoard(Game.DIM_X, Game.DIM_Y);
		
		initializeOvni();
		initializeRegularAliens();
		initializeDestroyerAliens();
		return board;
	}
	
	private void initializeOvni () {
		board.add(new Ovni(0, 0, 1, 10, game, true, false));
	}

	private void initializeRegularAliens () {
		int x = 1;
		int y = 6;
		for(int i = 0; i < this.level.getNumRowsOfRegularAliens(); i++) {
			for(int j = 0; j < level.getNumRegularAliensPerRow(); j++) {
				board.add(new RegularShip(x + j, y - i, 1, 5, game, true, false));
			}
		}
	}
	
	private void initializeDestroyerAliens() {
		int x = 1;
		int y = 6;
		for(int i = 0; i < this.level.getNumDestroyerAliens(); i++) {
			for(int j = 0; j < this.level.getNumDestroyerAliensPerRow(); j++) {
				board.add(new DestroyerShip(x, y + 2, 2, 10, game, true));
			}
		}
	}
}
