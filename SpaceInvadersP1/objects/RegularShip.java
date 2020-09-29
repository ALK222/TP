package objects;

public class RegularShip {
	
	//Atributos
	
	private int hp;
	private int points;
	private int x;
	private int y;
	
	//Constructor
	
	public RegularShip(int startX, int startY, int puntos) {
		this.hp = 2;
		this.points = puntos;
		this.x = startX;
		this.y = startY;
	}
	
	//Metodos
	
	public int getPoints(){
		return points;
	}

	public int getHp() {
		return hp;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
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
	
	
}
