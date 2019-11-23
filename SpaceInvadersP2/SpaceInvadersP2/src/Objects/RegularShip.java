package Objects;

public class RegularShip extends Ship{
	//ATRIBUTES
	
	private boolean explosive;
	
	//CONSTRUCTOR
	public RegularShip(int startX, int startY, int hp, int points, Game game, boolean alien, boolean explosive) {
		this.explosive = explosive;
		super(startX, startY, hp, points, game, alien);
	}
	
	//SETTERS AND GETTERS
	 public void setExplosive(int explosive) {
		 this.explosive = explosive;
	 }
	 
	 public boolean isExplosive() {
		 return this.explosive;
	 }
}
