package Objects;

import interfaces.IAttack;
import interfaces.IExecuteRandomActions;
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

	
	public void computerAction() {
		if(IExecuteRandomActions.canGenerateRandomBomb(game)){
			this.shoot();
		}
		if(this.getLaser().isActive()) {
			this.getLaser().computerAction();
		}
		
	}
	
	public String toString() {
		return "D[" + this.getHp() + "]";
	}
	
	public void damage(GameObject target) {
		this.setHp(getHp() - 1);
		if(this.hp >= 0) {
			this.setAlive(false);
		}
		
	}
	
	public void shoot() {
		this.getLaser().setActive(true);
		this.getLaser().setX(this.getX());
		this.getLaser().setY(this.getY());
	}

	
	
	
}
