package Objects;

import logic.Game;


public final class Bomb extends Weapon{
	
	
	//CONSTRUCTOR
	
	public Bomb(int startX, int startY, Game game, boolean alien, boolean alive, boolean active) {
		super(startX, startY, game, alien, active, active);

	}

	public void damage(int damage) {
		
		
	}


	public String toString() {
		if(isActive()) {
			return ".";
		}
		return "";
	}

	public void computerAction() {
		if(this.getX() > 8 && this.getX() < 0) {
			setActive(false);
		}
		move('b');
		
	}

	public void move(char dir) {
		if(this.isActive()) {
			this.setY(this.getX() + 1);
		}
	}

	
	public String stringify() {
		return "B ;" + this.getX() + ";" + this.getY();
	}

}
