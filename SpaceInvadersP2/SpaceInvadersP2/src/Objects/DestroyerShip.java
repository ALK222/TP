package Objects;

import logic.Game;

public final class DestroyerShip extends AlienShip{
	//ATTRIBUTES
	private Bomb bomb;
	
	//CONSTRUCTOR
	public DestroyerShip(int startX, int startY, int hp, int points, Game game, boolean alien){
		super(startX, startY, hp, points, game, alien);
		this.bomb = new Bomb(x, y, game, 1, alien);
	}
	public final Bomb getLaser() {
		return this.bomb;
	}
	
	
	
}
