package Objects;

import logic.Game;

public final class Missile extends Weapon{

	public Missile(int startX, int startY, Game game, boolean alien, boolean active) {
		super(startX, startY, game, alien, active);
	}

	public void damage(int damage) {
		
	}


	public void move(char dir) {
		this.setY(getX() - 1);
		
	}

	public void computerAction() {
		if(this.getX() < 0) {
			this.setActive(false);
		}
		
		if(isActive()) {
			move('b');
		}
		
	}


	public String toString() {
		return ".";
	}

	
	public final String stringify() {
		return "B" + this.getX() + ";" +  this.getY();
	}

}
