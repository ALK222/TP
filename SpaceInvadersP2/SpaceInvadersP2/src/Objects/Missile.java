package Objects;

import logic.Game;

public final class Missile extends Weapon{

	public Missile(int startX, int startY, Game game, int damage, boolean active) {
		super(startX, startY, game, damage, active);
	}

	public void damage(GameObject target) {
		if(target.isAlien()) {
			//inflict damage
		}
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
