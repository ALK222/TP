package lists;
import objects.*;

public class ListBomb {
	private Bomb[] bombList;
	
	//Constructor
	 public ListBomb(ListDestroyerAliens listD, int numNavesD) {
		 bombList = new Bomb[numNavesD];
		 for(int i = 0; i < numNavesD ; i++) {
			 bombList[i] = listD.getBomb(i);
		 }
	 }
	 public int getLength() {
			return this.bombList.length;
		}
	 
	 //metodos
	 
	 public void updateList() {
		 for(int i = 0; i < bombList.length; i++) {
			 if(bombList[i].isExists()) {
				bombList[i].updateShoot();
			 }
		 }
	 }
	 
	 //Daño de la lista
	 public boolean listDamage(UCMShip navi) {
		 for(int i = 0; i < this.bombList.length; i++) {
			 if(bombList[i].inflictDamage(navi) && this.bombList[i].isExists()) {
				 bombList[i].setExists(false);
				 return true;
			 }
		 }
		 return false;
	 }
	 
	 //Localizador de las bombas
	 public int isIn(int i, int j) {
			boolean comprobante = false;
			int n = 0;
			while((!comprobante) && (n < this.getLength())) {
				if((this.bombList[n].getX() == i) && (this.bombList[n].getY() == j) && bombList[n].isExists()){
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
	 
	 //Set false para la bomba n
	 public void setExist(int i, int j) {
		int  n = this.isIn(i, j);
		if(n != -1 && n < this.getLength()) {
			bombList[n].setExists(false);
		}
	 }

}