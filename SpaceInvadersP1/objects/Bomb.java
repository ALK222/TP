
package objects;

public class Bomb {
	private int x;
	private int y;
	private boolean exists;
	
	public Bomb() {
		this.exists = false;
	}
	
	//Getters
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	

	public boolean isExists() {
		return this.exists;
	}

	public void setExists(boolean e) {
		this.exists = e;
	}
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public boolean isIn(int i, int j) {
		if(this.getX() == i && this.getY() == j) {
			return true;
		}
		return false;
	}
	//movimiento de las bombas
	public void updateShoot() {
		this.setX(this.getX() + 1);
		if(this.getX()  >= 8) {
			this.setExists(false);
		}
	}
	//daño de la bomba
	public boolean inflictDamage(UCMShip navi) {
		if(navi.isIn(this.getX(), this.getY())) {
			return true;
		}
		return false;
	}
}

