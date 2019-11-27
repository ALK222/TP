package Objects;

import logic.Game;


public final class Bomb extends Weapon{
	
	
	//CONSTRUCTOR
	
	public Bomb(int startX, int startY, Game game, boolean alien, boolean active) {
		super(startX, startY, game, alien, active);

	}

	public void damage(GameObject target) {
		if(!target.isAlien()) {
			target.damage(this);
		}
		
	}

	public void move() {
		if(this.isActive()) {
			this.setY(this.getX() + 1);
		}
		
	}

	public String toString() {
		return ".";
	}

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		
	}

}
