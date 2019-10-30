package objects;

public class DestroyerShip {
	
	private int hp;
	private int points; //puntos que da al ser destruida. el daño que hace su disparo esta en la clase bomb
	private int x;
	private int y;
	private Bomb misil;
	
	public DestroyerShip(int x, int y, int puntos) {
		this.hp = 1;
		this.points = puntos;
		this.x = x;
		this.y = y;
		this.misil = new Bomb();
	}
	
	
	public Bomb getMisil() {
		return misil;
	}


	public void setMisil(Bomb misil) {
		this.misil = misil;
	}


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
	//disparo del misil
	public boolean shoot() {
		if(!misil.isExists()) {
			this.misil.setX(this.getX());
			this.misil.setY(this.getY());
			this.misil.setExists(true);
			return true;
		}
		return false;
	}
	
}
