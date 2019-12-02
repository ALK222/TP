package Objects;

import logic.Game;

public class Laser extends Weapon{

	public Laser(int startX, int startY, Game game, boolean alien, boolean alive) {
		super(startX, startY, game, alien, alive);
	}

	public void damage(GameObject target) {
		if(target.isAlien()) {
			target.damage(this);
			this.alive = false;
		}
	}

	public void move() {
		this.setY(getX() - 1);
		
	}

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "oo";
	}
	
}