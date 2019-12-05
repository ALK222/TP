package Objects;

import logic.Game;
import interfaces.IExecuteRandomActions;

public final class RegularShip extends AlienShip{
	
	/* Class "RegularShip":
	 * 
	 * 		Just your regular alien ship, but with an explosive temperament
	 * 
	 * */
	
	
	//ATRIBUTES
	
	private boolean explosive;
	
	//CONSTRUCTOR
	public RegularShip(int startX, int startY, int hp, int points, Game game, boolean alien, boolean alive, boolean explosive) {
		super(startX, startY, hp, points, game, alien, alive);
		this.explosive = explosive;
	}
	
	//SETTERS AND GETTERS
	 public void setExplosive(boolean explosive) {
		 this.explosive = explosive;
	 }
	 
	 public boolean isExplosive() {
		 return this.explosive;  //Allahu Akbar
	 }

	public void computerAction() {
		if(IExecuteRandomActions.canTurnExplosive(game)) {
			this.setExplosive(true);
		}
		
	}


	public String toString() {
		if(!isAlive()) {
			return "";
		}
		if(isExplosive()) {
			return "E[" + this.getHp() + "]";
		}
		return "R[" + this.getHp() +"]";
	}
	public final String stringify() {
		if(!isAlive()) {
			return "";
		}
		if(isExplosive()) {
			return "E " + this.getX() + ";" + this.getY() + ";" + this.getHp() +";"
					+ game.getCurrentCycle() % game.getLevel().getNumCyclesToMoveOneCell();
		}
		return "R " + this.getX() + ";" + this.getY() + ";" + this.getHp() +";"
		+ game.getCurrentCycle() % game.getLevel().getNumCyclesToMoveOneCell();
	}

	public void damage(int damage) {
		this.setHp(this.getHp() - damage);
		if(this.hp <= 0) {
			if(isExplosive()) {
				System.out.print("Explosion!");
				game.explosion(this.x, this.y);
			}
			this.setAlive(false);
			game.receivePoints(points);
		}
		
		
	}

}
