package Objects;

import interfaces.IExecuteRandomActions;
import logic.Game;

public final class Ovni extends Ship{
	/*
	 * 
	 *   You shoot me, you get power
	 * 
	 * */
	
	//ATTRIBUTES
	
	
	//CONSTRUCTOR 
	public Ovni(int startX, int startY, int hp, int points, Game game, boolean alien, boolean stillAlive) {
		super(startX, startY, hp, points, game, alien, stillAlive);
	}
	

	public void computerAction() {
		if(this.isAlive()) {
			move();
		}
		if(IExecuteRandomActions.canGenerateRandomOvni(game)) {
			this.setAlien(true);
		}
	}

	public void move() {
		this.setY(getY() + 1);
		
	}

	public String toString() {
		return "O[" + this.getHp() + "]";
	}

	public void damage(GameObject target) {
		this.setAlive(false);
		game.enableShockWave();
		
	}
}
