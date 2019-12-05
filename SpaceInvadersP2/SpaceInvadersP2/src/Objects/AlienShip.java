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

}
