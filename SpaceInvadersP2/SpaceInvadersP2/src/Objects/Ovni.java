package Objects;

import interfaces.IExecuteRandomActions;
import logic.Game;

public final class Ovni extends EnemyShip{
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
			move('b');
		}
		if(IExecuteRandomActions.canGenerateRandomOvni(game)  && !this.isAlive()) {
			this.x = 0;
			this.y = 8;
			this.setAlive(true);
		}
	}

	public void move(char dir) {
		this.setY(getY() - 1);
		
	}

	public String toString() {
		if(isAlive()) {
			return "O[" + this.getHp() + "]";
		}
		return "";
	}

	public void damage(int damage) {
		if(isAlive()) {
			this.setAlive(false);
			game.enableShockWave();
			game.receivePoints(points);
		}
		
	}
	
	
	public final String stringify() {
		if (isAlive()) return "O " + this.getX() + ";" + this.getY() + ";" + this.isAlive();
		return "";
	}
}
