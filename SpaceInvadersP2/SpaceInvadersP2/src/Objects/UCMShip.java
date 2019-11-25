package Objects;

import logic.Game;

public final class UCMShip extends Ship{
	//ATTRIBUTES
	private Laser laser;
	
	//CONSTRUCTOR
	public UCMShip(int startX, int startY, int hp, int points, Game game, boolean alien) {
		super(startX, startY, hp, points, game, alien);
		laser = new laser(this.x, this.y);
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

}
