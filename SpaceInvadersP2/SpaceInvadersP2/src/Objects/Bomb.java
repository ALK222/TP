package Objects;

import logic.Game;

public class Bomb extends Weapon{
	
	//ATTRIBUTES
	
	private int damage;
	
	//CONSTRUCTOR
	public Bomb(int startX, int startY, Game game, int damage) {
		super(startX, startY, game);
		this.setDamage(damage);		
	}

	public void damage() {
		
	}

	@Override
	public void move() {
		this.setY(getY() + 1);
		
	}

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "บบ";
	}

	@Override
	protected boolean isAlien() {
		return true;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

}
