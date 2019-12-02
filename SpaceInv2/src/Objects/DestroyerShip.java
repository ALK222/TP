package Objects;

import logic.Game;

public final class DestroyerShip extends AlienShip{
	//ATTRIBUTES
	private Bomb bomb;
	
	//CONSTRUCTOR
	public DestroyerShip(int startX, int startY, int hp, int points, Game game, boolean alien, boolean alive){
		super(startX, startY, hp, points, game, alien, alive);
		this.bomb = new Bomb(x, y, game, true, false);
	}
	public final Bomb getLaser() {
		return this.bomb;
	}
	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		
	}
	
	public String toString() {
		return "D[" + this.getHp() + "]";
	}
	
	public void damage(GameObject target) {
		this.setHp(getHp() - 1);
		
	}
	
	
	
}
