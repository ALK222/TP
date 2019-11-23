package Objects;

import logic.Game;

public abstract class Weapon extends GameObject{

	
	//ATTRIBUTES
	public Weapon(int startX, int startY, Game game) {
		super(startX, startY, game);
	}
	
	//METHODS
	
	public abstract void damage();
	public abstract void move();

}
