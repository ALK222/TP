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
		//Primero comprobamos la vida, luego movemos la nave y luego disparamos si es posible
		if(this.getHp() > 1) {
			//delete
		}
		
		move();
		if(IExecuteRandomActions.canGenerateRandomBomb(game)){
			this.shoot();
		}
		
	}
	
	public String toString() {
		return "D[" + this.getHp() + "]";
	}
	
	public void damage(GameObject target) {
		this.setHp(getHp() - 1);
		
	}
	
	public void shoot() {
		this.getLaser().setActive(true);
		this.getLaser().setX(this.getX());
		this.getLaser().setY(this.getY());
	}
	
	
	
}
