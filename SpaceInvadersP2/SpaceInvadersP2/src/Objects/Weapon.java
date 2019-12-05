package Objects;

import logic.Game;

public abstract class Weapon extends GameObject{
	
	//ATTRIBUTES
	
	private boolean active;
	private int damage;
	
	//CONSTRUCTOR
	
	public Weapon(int startX, int startY, Game game, boolean alien , boolean alive, boolean active, int damage) {
		super(startX, startY, game, alien , alive);
		this.active = active;
		this.damage = damage;
	}
	
	//SETTERS AND GETTERS
	
	public final int getDamage() {
		return this.damage;
	}
	
	public final boolean isActive() {
		return this.active;
	}
	
	
	public final void setActive(boolean active) {
		this.active = active;
	}
	
	//METHODS
	

	public boolean performAttack(GameObject other) {
		if(other.isAlien() != this.isAlien()) {
			this.damage(this.getDamage());
			other.damage(this.getDamage());
			return true;
		}
		return false;
	}
	
	


}
