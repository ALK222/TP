package Objects;

import logic.Game;


public final class Bomb extends Weapon{
	
	//ATTRIBUTES
	
	private int damage;
	private boolean active;
	
	//CONSTRUCTOR
	
	public Bomb(int startX, int startY, Game game, int damage, boolean active) {
		super(startX, startY, game, damage, active);
		this.damage = damage;
		this.active = active;
	}

	public void damage(GameObject target) {
		if(!target.isAlien()) {
			target.damage();
		}
		
	}

	public void move() {
		if(this.isActive()) {
			this.setY(this.getY() + 1);
		}
		
	}

	@Override
	public String toString() {
		return "บบ";
	}

}
