package Objects;

import logic.Game;

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

	 @Override
	public void computerAction() {
		move();
		if(isExplosive()) {
			game.explosion(this.x, this.y);
		}
		
	}


	public String toString() {
		return "R[" + this.getHp() +"]";
	}

	@Override
	public void damage(GameObject target) {
		this.hp--;
		
	}
}
