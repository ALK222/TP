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
		board.add(new Ovni(0, 8, 1, 25, game, true, false));
	}

	private void initializeRegularAliens () {
		int x = 1;
		int y = 6;
		for(int i = 0; i < this.level.getNumRowsOfRegularAliens(); ++i) {
			for(int j = 0; j < level.getNumRegularAliensPerRow(); ++j) {
				board.add(new RegularShip(x + i, y - j, 1, 5, game, true, true, false));
			}
		}
	}
	
	private void initializeDestroyerAliens() {
		int x = 2;
		int y = 5;
		if(level.getNumRegularAliens() > 4) {
			++y;
		}
		if(level.getNumRegularAliens() > 8) {
			++x;
		}
		if(level.getNumDestroyerAliens() > 2) {
			++x;
		}
		
		for(int i = 0; i < level.getNumDestroyerAliens(); i++) {
			board.add(new DestroyerShip(x, y - i, 2, 10, game, true, true));
		}
	}
}
