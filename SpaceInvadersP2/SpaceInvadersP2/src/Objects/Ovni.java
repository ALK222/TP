package Objects;

import logic.Game;

public final class Ovni extends Ship{
	/*
	 * 
	 *   You shoot me, you get power
	 * 
	 * */
	
	//ATTRIBUTES
	
	private boolean stillAlive;
	
	//CONSTRUCTOR 
	public Ovni(int startX, int startY, int hp, int points, Game game, boolean alien, boolean stillAlive) {
		super(startX, startY, hp, points, game, alien);
		this.stillAlive = stillAlive;
	}
	
	//SETTER AND GETTER
	
	public void setStillAlive(boolean live) {
		this.stillAlive = live;
	}
	
	public boolean getStillAlive() {
		return this.stillAlive;
	}
}
