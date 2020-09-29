package lists;



import objects.RegularShip;

public class ListRegularAliens {
	//Atributos
		private RegularShip[] RegularList;
		private final int xStart= 1;
		private final int yStart = 6;
		private int size;
		private final int points = 5;
		
		//Constructor
		
		public ListRegularAliens(int numNavesC) {
			this.RegularList = new RegularShip[numNavesC];
			int j = 0;
			for (int i = 0; i < numNavesC; i++) {
				if (i<4) {
					RegularList[i] = new RegularShip(xStart,yStart - i, points);
				}
				if (i>=4) {
					RegularList[i] = new RegularShip(xStart + 1, yStart - j, points);
					j++;
				}
			}
			this.setSize(numNavesC);
			
		}
		
		//Metodos
		
		public int getPoints() {
			return points;
		}

		public int getSize() {
			return size;
		}

		public void setSize(int size) {
			this.size = size;
		}

		
	
		//Localizador de naves
		public int isIn(int i, int j) {
			boolean comprobante = false;
			int n = 0;
			while((!comprobante) && (n < this.getSize())) {
				if((this.RegularList[n].getX() == i) && (this.RegularList[n].getY() == j)){
					comprobante = true;
				}
				n++;
			}
			if(!comprobante) {
				return -1;
			}
			else {
				return n - 1;
			}
		}
		
		//vida a string de la nave n
		public int hpToString(int n) {
			return RegularList[n].getHp();
		}
		
		//Daño a la nave n
		public boolean damage(int n) {
			RegularList[n].setHp(RegularList[n].getHp() - 1);
			if(RegularList[n].getHp() <= 0) {
				return true;
			}
			return false;
		}
		
		//Getter de la primera X del array
		public int getFirstX() {
			return RegularList[0].getY();
		}
		//getter de la ultima X del array
		public int getLastX() {
			return RegularList[this.getSize() - 1].getY();
		}
		//getter de la primera Y del array
		public int getFirstY() {
			return RegularList[0].getX();
		}
		//getter de la ultima Y del array
		public int getLastY() {
			return RegularList[this.getSize() - 1].getX();
		}
		//movimienton de las naves
		public void move(char dir) {
			switch (dir) {
			case 'b': for(int i = 0; i < this.getSize(); i++) {
				RegularList[i].setX(RegularList[i].getX() + 1);
			}
				break;
			case 'i': for(int i = 0; i < this.getSize(); i++) {
				RegularList[i].setY(RegularList[i].getY() - 1);
			}
				break;
			case 'd': for(int i = 0; i < this.getSize(); i++) {
				RegularList[i].setY(RegularList[i].getY() + 1);
			}
				break;
			}
		}
		//borrado de la nave n
		public void deleteNave(int n) {
			if(this.getSize() > 1) {
				for(int i = n; i < this.getSize() - 1; i++) {
					RegularList[i] = RegularList[i + 1];
				}
			}
			this.setSize(this.getSize() - 1);
		}
		//localizador de una nave en X
		public boolean isInX(int x) {
			for (int i = 0; i < this.getSize(); i++) {
				if(RegularList[i].getY() == x) {
					return true;
				}
			}
			return false;
		}
}