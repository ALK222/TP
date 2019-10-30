package objects;

public class UCMShip {
	private int hp;
	private int points; //puntos que tiene el jugador
	private int x;
	private int y;
	private UCMShipLaser laser;
	
	public UCMShip() {
		this.hp = 3;
		this.points = 0;
		this.x = 7;
		this.y = 4;
	}
	
	public UCMShip (int hp, int p, int x, int y) {
		this.hp = hp;
		this.points = p;
		this.x = x;
		this.y = y;
		this.setLaser(new UCMShipLaser(this.getX(), this.getY()));
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
	
	public UCMShipLaser getLaser() {
		return laser;
	}

	public void setLaser(UCMShipLaser laser) {
		this.laser = laser;
	}

	//movimiento de la nave
	public boolean move(String direction, String square) {
		switch(direction.charAt(0)) {
		case 'l': if(square.equals("1")) {
			if(this.getY() - 1 < 0) { //si no es posible mover la nave, el movimiento es false
				return false;
			}
			else {
				this.setY(this.getY() - 1);
				return true;
			}
		}
		else if(square.equals("2")) {
			if(this.getY() - 2 < 0) {//si no es posible mover la nave, el movimiento es false
				return false;
			}
			else {
				this.setY(this.getY() - 2);
				return true;
			}
		}
		else {
			return false;
		}
		case 'r':if(square.equals("1")) {
			if(this.getY() + 1 > 9) {//si no es posible mover la nave, el movimiento es false
				return false;
			}
			else {
				this.setY(this.getY() + 1);
				return true;
			}
		}
		else if(square.equals("2")) {
			if(this.getY() + 2 > 9) {//si no es posible mover la nave, el movimiento es false
				return false;
			}
			else {
				this.setY(this.getY() + 2);
				return true;
			}
		}
		else {
			return false; //si no se detecta un numero correcto, el movimiento es false
		}
	}
	return false; //si no se detecta una direccion correcta, el movimiento es false
	}
	//disparo del laser
	public boolean shoot(int i, int j) {
		if(!laser.isExists()) {
			this.laser.setX(this.getX());
			this.laser.setY(this.getY());
			this.laser.setExists(true);
			return true;
		}
		return false;
	}
	
	//localizador de la nave
	public boolean isIn(int i, int j) {
		if(this.getX() == i && this.getY() == j) {
			return true;
		}
		return false;
	}
	//Daño a la nave
	public void damage() {
		this.setHp(getHp() - 1);
	}
}
