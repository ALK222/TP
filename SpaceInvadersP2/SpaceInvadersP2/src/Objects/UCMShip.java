package Objects;

import logic.Game;

public class UCMShip extends Ship{
	//ATTRIBUTES
	private Laser laser;
	private int points; //Points of the player
	public UCMShip(int startX, int startY, int hp, int points, Game game, boolean alien, int points) {
		super(startX, startY, hp, points, game, alien);
		this.points = points;
		laser = new laser(this.x, this.y);
	}
	
	public String toString() {
		return null;
	}

}
