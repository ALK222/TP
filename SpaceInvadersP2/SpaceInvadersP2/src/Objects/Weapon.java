package Objects;

import logic.Game;

public abstract class Weapon extends GameObject{
	
	//ATTRIBUTES
	
	private boolean active;
	
	//CONSTRUCTOR
	
	public Weapon(int startX, int startY, Game game, boolean alien , boolean alive) {
		super(startX, startY, game, alien , alive);
	}
	
	//SETTERS AND GETTERS
	
	public final int getDamage() {
		return this.getDamage();
	}
	
	public final boolean isActive() {
		return this.active;
	}
	
	
	public final void setActive(boolean active) {
		this.active = active;
	}
	
	//METHODS
	
	public abstract void damage(GameObject target);
	

}
