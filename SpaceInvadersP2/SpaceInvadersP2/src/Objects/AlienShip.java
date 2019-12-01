package Objects;

import logic.Game;

public  abstract class AlienShip extends EnemyShip{
	/*
	 * 
	 * 		Alien Mothership, the beggining of all aliens
	 * 
	 * */
	
	//CONSTRUCTOR
	
	public AlienShip(int startX, int startY, int hp, int points, Game game, boolean alien, boolean alive) {
		super(startX, startY, hp, points, game, alien, alive);
	}
	
	public final boolean haveLanded() {
		return y >= 0;
	}

	public final boolean allDead() {
		return hp < 0;
	}
	
	public final void move() {
		boolean bajar = false;
		if(game.getLastDir() != 'b') {
			if(this.y >= 8 || this.y <= 0) {
				this.x++;
				game.setLastDir('b');
				bajar = true;
				game.setLine(game.getLine() + 1);
			}
		}
		if (!bajar) {
			if(game.getLine() % 2 == 0) {
				this.y--;
				game.setLastDir('i');
			}
			else {
				++this.y;
				game.setLastDir('d');
			}
		}
	}
	
}
