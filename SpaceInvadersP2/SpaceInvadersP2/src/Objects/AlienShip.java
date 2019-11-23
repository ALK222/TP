package Objects;

import logic.Game;

public class AlienShip extends Ship{
	/*
	 * 
	 * 		Alien Mothership, the beggining of all aliens
	 * 
	 * */
	
	//CONSTRUCTOR
	
	public AlienShip(int startX, int startY, int hp, int points, Game game, boolean alien) {
		super(startX, startY, hp, points, game, alien);
	}
	
}
