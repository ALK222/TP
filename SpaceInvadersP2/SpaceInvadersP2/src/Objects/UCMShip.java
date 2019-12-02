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
		if(isAlive()) {
			return "^_^";
		}
		return "!xx!";
	}
	
	public boolean isAlive() {
		return this.hp > 0;
	}

	public void computerAction() {
		this.getLaser().computerAction();
		
	}

	@Override
	public void move(char dir) {
		// TODO Auto-generated method stub
		
	}

	public void damage(GameObject target) {
		this.hp--;
		
	}

	public Laser getLaser() {
		return this.laser;
	}

	public void shoot() {
		laser.setX(this.x);
		laser.setY(this.y);
		laser.setActive(true);
		
	}

}
