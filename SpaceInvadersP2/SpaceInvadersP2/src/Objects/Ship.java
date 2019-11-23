package Objects;

import logic.Game;

/* Class "Ship":
 * 
 *      Defines common methods for all types of ships
 * 
 * */


public abstract class Ship extends GameObject {
	//ATTRIBUTES
	protected int hp;
	protected int points;
	protected boolean alien;
	
	//CONSTRUCTOR
	public Ship(int startX, int startY, int hp, int points, Game game, boolean alien) {
		super(startX, startY, game);
		this.hp = hp;
		this.points = points;
		this.alien = alien;
	}
	
	//SETTERS AND GETTERS
	public void setHp(int health) {
		this.hp = health;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}
	
	public int getHp() {
		return this.hp;
	}
	
	public int getPoints() {
		return this.points;
	}
	
	//I don't belong in area 51, or do I?
	public boolean isAlien() {
		return this.alien;
	}
}
