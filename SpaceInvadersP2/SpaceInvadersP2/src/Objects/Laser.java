package Objects;

import logic.Game;

public class Laser extends Weapon{

	public Laser(int startX, int startY, Game game, boolean alien, boolean alive, boolean active) {
		super(startX, startY, game, alien, alive, active, 1);
	}


	public void move(char dir) {
		this.setX(getX() - 1);
		
	}

	
	public void computerAction() {
		move('b');
		if(x < 0) {
			this.setActive(false);
		}
		
		
	}

	
	public String toString() {
		if(isActive()) {
			return "oo";
		}
		return "";
	}


	
	public void damage(int damage) {
		this.setActive(false);
		this.setX(10);
		this.setY(10);
		
	}

	public String stringify() {
		if(this.isActive()) {
			return "M " + this.getX() + ";" + this.getY();
		}
		return "";
	}
	


	





	
}