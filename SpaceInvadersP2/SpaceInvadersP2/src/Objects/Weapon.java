package Objects;

import logic.Game;

public abstract class Weapon extends GameObject{
	
	//ATTRIBUTES
	
	private int damage;
	private boolean active;
	
	//CONSTRUCTOR
	
	public Weapon(int startX, int startY, Game game, int damage, boolean active) {
		super(startX, startY, game, active);
		this.damage = damage;
		this.active = active;
	}
	
	//SETTERS AND GETTERS
	
	public final int getDamage() {
		return this.getDamage();
	}
	
	public final boolean isActive() {
		return this.active;
	}
	
	public final void setDamage(int damage) {
		this.damage = damage;
	}
	
	public final void setActive(boolean active) {
		this.active = active;
	}
	
	//METHODS
	
	public abstract void damage(GameObject target);
	
	public abstract void move();

}
