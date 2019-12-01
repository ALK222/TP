package Objects;

import logic.Game;

public class Laser extends Weapon{

	public Laser(int startX, int startY, Game game, boolean alien, boolean alive) {
		super(startX, startY, game, alien, alive);
	}


	public void move() {
		this.setY(getX() - 1);
		
	}

	
	public void computerAction() {
		move();
	}

	
	public String toString() {
		return "oo";
	}


	@Override
	public void damage(GameObject target) {
		// TODO Auto-generated method stub
		
	}

	





	
}