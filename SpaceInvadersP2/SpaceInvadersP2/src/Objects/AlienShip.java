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
		if(this.getY() == 0 || this.getY() == 8) {
			this.setX(this.getX() - 1);
		}
		if(this.getX() % 2 == 0) {
			this.setY(getY() + 1);
		}
		else {
			this.setY(getY() - 1);
		}
	}
	
}
