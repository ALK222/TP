package lists;

import logic.Level;
import objects.*;

public class ListDestroyerAliens {
	
	private DestroyerShip[] DestroyerList;
	private int num_dest;
	private final int xStart = 3;
	private final int yStart = 5;
	private int size;
	private final int points = 10;
	private Bomb misil;
	private UCMShip navi;
	//constructor
	public ListDestroyerAliens(int numNavesD, int numNavesC) {	
		this.num_dest = numNavesD;
		this.DestroyerList = new DestroyerShip[numNavesD];
		for (int i=0; i<numNavesD; i++) {
			if(numNavesC <= 4) {
				if (numNavesD <= 2) {
					DestroyerList[i] = new DestroyerShip(xStart - 1,yStart-i, points);
				}
				if (numNavesD >= 4) {
						
						DestroyerList[i] = new DestroyerShip(xStart - 1, yStart + 1 - i, points);
				}
			}
			else {
				if (numNavesD <= 2) {
					DestroyerList[i] = new DestroyerShip(xStart,yStart-i, points);
				}
				if (numNavesD >= 4) {
						
						DestroyerList[i] = new DestroyerShip(xStart, yStart + 1 - i, points);
				}
			}
			
		}
		this.setSize(numNavesD);
		
	}
	
	//Getters y Setters
	
	public int getPoints() {
		return points;
	}

	public DestroyerShip[] getDestroyerList() {
		return DestroyerList;
	}

	public void setDestroyerList(DestroyerShip[] destroyerList) {
		DestroyerList = destroyerList;
	}

	public int getNum_dest() {
		return num_dest;
	}

	public void setNum_dest(int num_dest) {
		this.num_dest = num_dest;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getxStart() {
		return xStart;
	}

	public int getyStart() {
		return yStart;
	}	
	
	//metodos
	
	//movimiento de las naves
	public void move(char dir) {
		switch (dir) {
		case 'b': for(int i = 0; i < this.getSize(); i++) {
			DestroyerList[i].setX(DestroyerList[i].getX() + 1);
		}
			break;
		case 'i': for(int i = 0; i <  this.getSize(); i++) {
			DestroyerList[i].setY(DestroyerList[i].getY() - 1);
		}
			break;
		case 'd': for(int i = 0; i <  this.getSize(); i++) {
			DestroyerList[i].setY(DestroyerList[i].getY() + 1);
		}
			break;
		}
	}
	
	//Localizador de las naves
	public int isIn(int i, int j) {
		boolean comprobante = false;
		int n = 0;
		while((!comprobante) && (n < this.getSize())) {
			if((this.DestroyerList[n].getX()== i) && (this.DestroyerList[n].getY() == j)){
				comprobante = true;
			}
			else {
				n++;
			}
		}
		if(!comprobante) {
			return -1;
		}
		else {
			return n;
		}
	}
	
	//Devuelve la vida de la nave n
	public int hpToString(int n) {
		return DestroyerList[n].getHp();
	}
	
	
	//inflinge daño a la nave n
	public boolean damage(int n) {		
		DestroyerList[n].setHp(DestroyerList[n].getHp() - 1);
		if(DestroyerList[n].getHp() <= 0) {
			return true;
		}
		return false;
	}
	// getter de la bomba de la nave n
	public Bomb getBomb(int n) {
		return DestroyerList[n].getMisil();
	}
	//get Y de la posicion de las naves
	public int getY() {
		return DestroyerList[0].getX();
	}
	//borrado de naves
	public void deleteNave(int n) {
		if(this.getSize() > 1) {
			for(int i = n; i < this.getSize() - 1; i++) {
				DestroyerList[i] = DestroyerList[i + 1];
			}
		}
		this.setSize(getSize() - 1); 
		
	}
	
	//disparo
	public void shoot(int n) {
		if(!DestroyerList[n].getMisil().isExists()) {
			DestroyerList[n].getMisil().setExists(true);
			DestroyerList[n].getMisil().setX(DestroyerList[n].getX());
			DestroyerList[n].getMisil().setY(DestroyerList[n].getY());
		}
	}
}