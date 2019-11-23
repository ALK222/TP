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
	public RegularShip(int startX, int startY, int hp, int points, Game game, boolean alien, boolean explosive) {
		super(startX, startY, hp, points, game, alien);
		this.explosive = explosive;
	}
	
	//SETTERS AND GETTERS
	 public void setExplosive(boolean explosive) {
		 this.explosive = explosive;
	 }
	 
	 public boolean isExplosive() {
		 return this.explosive;
	 }

	public void computerAction() {
		// TODO Auto-generated method stub
		
	}


	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
}
