package Objects;

import logic.Game;

public final class Bomb extends Weapon{
	
	//CONSTRUCTOR
	
	public Bomb(int startX, int startY, Game game, int damage, boolean active) {
		super(startX, startY, game, damage, active);
	}

	public void damage(GameObject target) {
		if(!target.isAlien()) {
			//inflict damage
		}
		
	}

	public void move() {
		if(this.isActive()) {
			this.setY(this.getY() + 1);
		}
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
