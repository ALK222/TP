package Objects;

import logic.Game;

public class DestroyerShip extends Ship{
	//ATTRIBUTES
	private Laser laser;
	
	//CONSTRUCTOR
	public DestroyerShip(int startX, int startY, int hp, int points, Game game, boolean alien){
		this.misil = new Bomb();
		super(startX, startY, hp, points, game, alien);
	}
	
}
