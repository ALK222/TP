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
		super(startX, startY, hp, points, game, alien, stillAlive);
		this.stillAlive = stillAlive;
	}
	
	//SETTER AND GETTER
	
	public void setStillAlive(boolean live) {
		this.stillAlive = live;
	}
	
	public boolean getStillAlive() {
		return this.stillAlive;
	}

	@Override
	public void computerAction() {
		move();
		
	}

	@Override
	public void move() {
		this.setY(getY() + 1);
		
	}

	@Override
	public String toString() {
		return "O[" + this.getHp() + "]";
	}

	@Override
	public void damage(GameObject target) {
		this.stillAlive = false;
		
	}
}
