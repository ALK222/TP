package Objects;

import logic.Game;

public class Laser extends Weapon{

	public Laser(int startX, int startY, Game game, boolean alien, boolean alive) {
		super(startX, startY, game, alien, alive);
	}


	public void move(char dir) {
		this.setX(getX() - 1);
		
	}

	
	public void computerAction() {
		move('b');
		if(0 < x && x < 8) {
			game.enableMissile();
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
		
	}

	public String stringify() {
		if(this.isActive()) {
			return "M " + this.getX() + ";" + this.getY();
		}
		return "";
	}


	





	
}