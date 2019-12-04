package Objects;

import logic.Game;

public class SuperMisille extends Weapon{

	public SuperMisille(int startX, int startY, Game game, boolean alien, boolean alive) {
		super(startX, startY, game, alien, alive);
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
		
		
	}


	public String stringify() {
		if(isActive()) return "S " + this.getX() + ";" + this.getY();
		return "";
	}
	
}
