package Objects;

import logic.Game;

public  abstract class AlienShip extends Ship{
	/*
	 * 
	 * 		Alien Mothership, the beggining of all aliens
	 * 
	 * */
	
	//CONSTRUCTOR
	
	public AlienShip(int startX, int startY, int hp, int points, Game game, boolean alien) {
		super(startX, startY, hp, points, game, alien);
	}
	
	public boolean haveLanded() {
		return y >= 0;
	}

	public boolean allDead() {
		return hp < 0;
	}
	
}
