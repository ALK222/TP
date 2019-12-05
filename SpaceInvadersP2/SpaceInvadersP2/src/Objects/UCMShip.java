package Objects;

import logic.Game;

public final class UCMShip extends Ship{
	//ATTRIBUTES
	private Laser laser;
	
	//CONSTRUCTOR
	public UCMShip(int startX, int startY, int hp, int points, Game game, boolean alien, boolean alive, Laser laser) {
		super(startX, startY, hp, points, game, alien, alive);
		this.laser = laser;
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
	}
	
	@Override
	public void move(char dir) {
		
	}
	
	public void move(int dir) {
		this.setY(this.getY() - dir);
	}
	
	public void damage(int damage) {
		this.setHp(this.getHp() - damage);
		
	}

	public Laser getLaser() {
		return this.laser;
	}

	public void shoot() {
		laser.setX(this.x);
		laser.setY(this.y);
		laser.setActive(true);
		laser.move('b');
	}
	
	public final String stringify() {
		return "P " + this.getX() + ";" + this.getY() + ";" + this.getHp() +";"
				+ points + game.shockWave() + ";" + game.getAmmo();
	}

	
}
