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


	public String toString() {
		return ".";
	}

	public void computerAction() {
		if(this.getX() > 8) {
			setActive(false);
		}
		move('b');
		
	}

	public void move(char dir) {
		if(this.isActive()) {
			this.setY(this.getX() + 1);
		}
	}

}
