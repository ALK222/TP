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
	
	public final boolean haveLanded() {
		return y >= 0;
	}

	public final boolean allDead() {
		return hp < 0;
	}
	
	public final void move() {
		
	}
	
}
