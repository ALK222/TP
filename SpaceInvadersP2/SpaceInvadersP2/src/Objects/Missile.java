package Objects;

import logic.Game;

public final class Missile extends Weapon{

	public Missile(int startX, int startY, Game game, boolean alien, boolean active) {
		super(startX, startY, game, alien, active);
	}

	public void damage(GameObject target) {
		if(target.isAlien()) {
			target.damage(this);
			this.setActive(false);
		}
	}


	public void move() {
		this.setY(getX() - 1);
		
	}

	public void computerAction() {
		if(this.getX() < 0) {
			this.setActive(false);
		}
		
		if(isActive()) {
			move();
		}
		
	}


	public String toString() {
		return ".";
	}

}
