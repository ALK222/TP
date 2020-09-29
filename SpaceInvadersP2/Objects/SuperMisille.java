package objects;

import logic.Game;

public class SuperMisille extends Weapon{

	public SuperMisille(int startX, int startY, Game game, boolean alien, boolean alive, boolean active) {
		super(startX, startY, game, alien, alive, active, 2);
	}

	
	public void computerAction() {
		move('b');
		
	}

	
	public void move(char dir) {
		this.setY(this.getY() + 1);
		
	}

	
	public String toString() {
		if(this.isActive()) {
			return "^";
		}
		return "";
	}

	
	public void damage(int damage) {
		
		this.setActive(false);
		this.setX(10);
		this.setY(10);
	}


	public String stringify() {
		if(isActive()) return "S " + this.getX() + ";" + this.getY();
		return "";
	}
	
	
}
