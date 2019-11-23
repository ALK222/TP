package Objects;

public class AlienShip extends Ship{
	/*
	 * 
	 * 		Alien Mothership, the beggining of all aliens
	 * 
	 * */
	
	//CONSTRUCTOR
	
	public AlienShip(int startX, int startY, int hp, int points, Game game, boolean alien) {
		super(startX, startY, hp, points, game, alien);
	}
	
	public void movement() {
		boolean bajar = false;
		if(this.x % 2 != 0) {
			if(this.y != 8 || this.y != 0) {
				bajar = true;
				this.setX(this.getX() - 1);
			}
		}
		if (!bajar) {
			if(regularList.getFirstY() % 2 != 0) {
				this.regularList.move('i');
				this.destroyerList.move('i');
				this.setLastDir('i');
			}
			else {
				this.regularList.move('d');
				this.destroyerList.move('d');
				this.setLastDir('d');
			}
		}	
	}
}
