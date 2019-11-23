package Objects;

import logic.Game;

public final class DestroyerShip extends Ship{
	//ATTRIBUTES
	private Bomb laser;
	
	//CONSTRUCTOR
	public DestroyerShip(int startX, int startY, int hp, int points, Game game, boolean alien){
		this.misil = new Bomb();
		super(startX, startY, hp, points, game, alien);
	}
	public Bomb getLaser() {
		return this.laser;
	}
	
	
}
