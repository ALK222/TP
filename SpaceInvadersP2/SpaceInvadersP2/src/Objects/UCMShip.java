package Objects;

import logic.Game;

public final class UCMShip extends Ship{
	//ATTRIBUTES
	private Laser laser;
	
	//CONSTRUCTOR
	public UCMShip(int startX, int startY, int hp, int points, Game game, boolean alien, boolean alive) {
		super(startX, startY, hp, points, game, alien, alive);
		laser = new Laser(this.x, this.y, game, false, false);
	}
	
	public String toString() {
		return "^_^";
	}
	
	public boolean isAlive() {
		return this.hp > 0;
	}

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	public void damage(GameObject target) {
		this.hp--;
		
	}

}
