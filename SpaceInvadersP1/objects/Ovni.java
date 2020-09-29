package objects;

public class Ovni {
	
	private int hp;
	private int points;
	private int x;
	private int y;
	private boolean exists;
	
	public Ovni () {
		this.hp = 1;
		this.points = 25;
		this.x = 0;
		this.y = 8;
		this.exists = false;
	}
	
	public Ovni (int life, int p) {
		this.hp = life;
		this.points = p;
	}

	// Getters
	
	public int getHp() {
		return hp;
	}

	public int getPoints() {
		return points;
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
	
	public void setHp(int hp) {
		this.hp = hp;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public boolean estado() {
		return this.isExists();
	}

	public void setExists(boolean exists) {
		this.exists = exists;
	}
	
	//Localizador del ovni
	public boolean isIn(int i, int j) {
		if(this.getX() == i && this.getY() == j) {
			return true;
		}
		return false;
	}
	 
	
}
