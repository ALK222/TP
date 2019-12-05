package Objects;

import interfaces.IExecuteRandomActions;
import logic.Game;

public final class DestroyerShip extends AlienShip{
	//ATTRIBUTES
	private Bomb bomb;
	
	//CONSTRUCTOR
	public DestroyerShip(int startX, int startY, int hp, int points, Game game, boolean alien, boolean alive, Bomb bomb){
		super(startX, startY, hp, points, game, alien, alive);
		this.bomb = bomb;
	}
	public final Bomb getLaser() {
		return this.bomb;
	}

	
	public void computerAction() {
		if(IExecuteRandomActions.canGenerateRandomBomb(game)){
			this.shoot();
		}		
	}
	
	public String toString() {
		if(!isAlive()) {
			return "";
		}
		return "D[" + this.getHp() + "]";
	}
	
	public void damage(int damage) {
		this.setHp(getHp() - damage);
		if(this.hp <= 0) {
			this.setAlive(false);
			this.getLaser().setAlive(false);
			game.receivePoints(points);
		}
		
	}
	
	public void shoot() {
		if(!this.getLaser().isActive()) {
			this.getLaser().setActive(true);
			this.getLaser().setX(this.getX());
			this.getLaser().setY(this.getY());
		}

	}

	
	public String stringify() {
		if(!isAlive()) {
			return "";
		}
		return "D " + this.getX() + ";" + this.getY() + ";" + this.getHp() +";"
				+ game.getCurrentCycle() % game.getLevel().getNumCyclesToMoveOneCell();
	}

	
	
	
}
