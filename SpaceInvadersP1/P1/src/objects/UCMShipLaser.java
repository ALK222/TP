
package objects;
import lists.*;

public class UCMShipLaser {
	private int damage;
	private int x;
	private int y;
	private boolean exists;
	
	public UCMShipLaser(int x, int y) {
		this.x = x;
		this.y = y;
		this.exists = false;
		this.damage = 1;
	}
	
	// Getters
	
	public int getDamage() {
		return damage;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public boolean isExists() {
		return exists;
	}
	
	// Setters
	
	public void setDamage(int damage) {
		this.damage = damage;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setExists(boolean exists) {
		this.exists = exists;
	}
	
	public void updateShoot() {
		this.setX(this.getX() - 1);
	}
	
	//localizador del laser
	public boolean isIn(int i, int j) {
		if(this.isExists()) {
			if(this.getX() == i && this.getY() == j) {
				return true;
			}
		}
		return false;
	}
	
}
