package logic;
import lists.ListBomb;
import lists.ListDestroyerAliens;
import lists.ListRegularAliens;
import logic.Level;
import objects.Bomb;
import objects.DestroyerShip;
import objects.Ovni;
import objects.RegularShip;
import objects.UCMShip;
import objects.UCMShipLaser;
import utils.GamePrinter;
import java.util.Random;
public class Game {
	//Atributos
	
		private int cycles;
		private int points;
		private boolean shockWave;
		private Level difficulty;
		private ListBomb bombList;
		private ListDestroyerAliens destroyerList;
		private ListRegularAliens regularList;
		private Bomb bomba;
		private DestroyerShip destructora;
		private Ovni ovni;
		private RegularShip regular;
		private UCMShip navi;
		private UCMShipLaser ucmlaser;
		private GamePrinter printer;
		private boolean win;
		private boolean lose;
		private char lastDir;
		private Random rand;
		private String seed;
		private GamePrinter g;
		//Constructor
		
		public Game(String L, String seed) {
			Level level;
			if(L.equals("EASY")) {
				level = Level.EASY;
			}
			else if(L.equals("HARD")){
				level = Level.HARD;
			}
			else if(L.equals("INSANE")) {
				level = Level.INSANE;
			}
			else {
				level = Level.EASY;
			}
			this.difficulty = level;
			this.cycles = 0;
			this.points = 0;
			this.shockWave = false;
			this.ovni = new Ovni();
			this.destroyerList = new ListDestroyerAliens(level.getNum_destroyer(), level.getNum_comunes());
			this.regularList = new ListRegularAliens(level.getNum_comunes());
			this.bombList = new ListBomb(destroyerList, this.difficulty.getNum_destroyer());
			this.navi = new UCMShip(3, 0, 7, 4);
			this.win = false;
			this.lose = false;
			this.lastDir = ' ';
			this.rand = new Random(Long.parseLong(seed));
			this.seed = seed;
		}
		
		
		
		//Metodos
		
		public Random getRand() {
			return rand;
		}



		public void setRand(Random rand) {
			this.rand = rand;
		}



		public String getSeed() {
			return seed;
		}



		public void setSeed(String seed) {
			this.seed = seed;
		}



		public Level getDifficulty() {
			return difficulty;
		}
		public int getCycles() {
			return cycles;
		}
		public int getPoints() {
			return points;
		}
		public boolean getShockWave() {
			return shockWave;
		}
		
		public char getLastDir() {
			return lastDir;
		}



		public void setLastDir(char lastDir) {
			this.lastDir = lastDir;
		}



		//Strign de cada tipo de objetos
		public String characterAtToString(int i, int j) {
			int n = this.regularList.isIn(i, j);
			if(n != (-1) && n < this.regularList.getSize() && this.regularList.hpToString(n) != 0) {
				return "C[" + this.regularList.hpToString(n) + "]";
			}
			n = this.destroyerList.isIn(i,j);
			if(n != (-1) && n < this.regularList.getSize() && this.destroyerList.hpToString(n) != 0){
			  	return "D[" + this.destroyerList.hpToString(n) + "]";
			 }
			if(this.ovni.isIn(i,j) && this.ovni.isExists()){
			 	return "O[" + this.ovni.getHp() + "]";
			 }
			 if(this.navi.getLaser().isIn(i, j)) {
			 	return "oo";
			 }
			 n = this.bombList.isIn(i, j);
			 if(n != (-1) && n < this.bombList.getLength()) {
				return ".";
			 }
			 if(this.navi.isIn(i,j) && this.navi.getHp() != 0) {
				 return "^__^";
			 }
			 else if(this.navi.isIn(i,j) && this.navi.getHp() == 0) {
				 return "!xx!";
			 }
			return " ";
		}
		
		//selector de comandos
				public boolean selectCommand(String[] command) {
					if(command[0].equals("shockwave")) {
						command[0] = "w";
					}
					switch(command[0].charAt(0)) {
					case 'm':	if(command.length != 3){
						return false;
					}
					else if(navi.move(command[1], command[2])) {
						return true;
					}
					else {
						return false;
					}
					case 's': navi.shoot(navi.getX(), navi.getY());
						return true;
					case 'w': if(this.getShockWave()) {this.shock();}
						return true;
					case 'l': System.out.print("[R]egular ship: Points: 5 - Harm: 0 - Shield: 2\r\n"
							+ "[D]estroyer ship: Points: 10 - Harm: 1 - Shield: 1\r\n"
							+ "[O]vni: Points: 25 - Harm: 0 - Shield: 1\r\n"
							+ "^__^:  Harm: 1 - Shield: 3\r\n");
						return true;
					case 'e': this.setLose(true);
						return true;
					case 'h': System.out.print("move <left|right><1|2>: Moves UCM-Ship to the indicated direction.\r\n"
							+ "shoot: UCM-Ship launches a missile.\r\n"
							+ "shockWave: UCM-Ship releases a shock wave.\r\n"
							+ "list: Prints the list of available ships.\r\n"
							+ "reset: Starts a new game.\r\n"
							+ "help: Prints this help message.\r\n"
							+ "exit: Terminates the program.\r\n"
							+ "[none]: Skips one cycle.");
						return true;
					case 'n': return true;
					default: return false;
					}
				}
		
		
		//movimiento
		
		public void movement() {
			boolean bajar = false;
			if(this.getLastDir() != 'b') {
				if(this.regularList.isInX(8) || this.regularList.isInX(0)) {
					this.regularList.move('b');
					this.destroyerList.move('b');
					this.setLastDir('b');
					bajar = true;
				}
			}
			if (!bajar) {
				if(regularList.getFirstY() % 2 != 0) {
					this.regularList.move('i');
					this.destroyerList.move('i');
					this.setLastDir('i');
				}
				else {
					this.regularList.move('d');
					this.destroyerList.move('d');
					this.setLastDir('d');
				}
			}	
		}
		
		//update del juego
		public void update() {
			int n;//numero que decide las posibilidades random
			//Movimiento del misil de UCMShip
			if(navi.getLaser().isExists()) { //si hay un laser, se actualiza su posicion
				navi.getLaser().updateShoot();
				if(this.inflictDamage()) { // si colisiona con algo, hace daño y deja de existir
					navi.getLaser().setExists(false);
					
				}
			}
			//Movimiento de las bombas si existen
			for(int i = 0; i < destroyerList.getSize(); i++) {
				n = rand.nextInt(10);
				if(n < difficulty.getShooting_frec() * 10) {
					destroyerList.shoot(i);
				}
			}
			bombList.updateList();
			//daño de las bombas
			if(bombList.listDamage(navi)) {
				 navi.setHp(navi.getHp() - 1);
			}
			//si las naves llegan al borde de la pantalla o mueres, se acaba la partida
			
			if(this.getCycles() % this.difficulty.getSpeed() == 0 && this.getCycles() != 0) {
				this.movement();
			}
			
			if(this.loseCondition()) {
				this.setLose(true);
			}
			//si el ovni existe, se mueve y si no, se mira por probabilidad si se crea
			if(this.ovni.isExists()) {
				this.ovni.setY(this.ovni.getY() - 1);
				if(this.ovni.getY() < 0) {
					this.ovni.setExists(false);
				}
			}
			else {
				n = rand.nextInt(10);
				if(n > difficulty.getFrec_ovni() * 10) {
					this.ovni.setExists(true);
					this.ovni.setX(0);
					this.ovni.setY(8);
				}
			}
			this.setCycles(getCycles() + 1);
		}
		
		public ListBomb getBombList() {
			return bombList;
		}



		public void setBombList(ListBomb bombList) {
			this.bombList = bombList;
		}



		public ListDestroyerAliens getDestroyerList() {
			return destroyerList;
		}



		public void setDestroyerList(ListDestroyerAliens destroyerList) {
			this.destroyerList = destroyerList;
		}



		public ListRegularAliens getRegularList() {
			return regularList;
		}



		public void setRegularList(ListRegularAliens regularList) {
			this.regularList = regularList;
		}



		public Bomb getBomba() {
			return bomba;
		}



		public void setBomba(Bomb bomba) {
			this.bomba = bomba;
		}



		public DestroyerShip getDestructora() {
			return destructora;
		}



		public void setDestructora(DestroyerShip destructora) {
			this.destructora = destructora;
		}



		public Ovni getOvni() {
			return ovni;
		}



		public void setOvni(Ovni ovni) {
			this.ovni = ovni;
		}



		public RegularShip getRegular() {
			return regular;
		}



		public void setRegular(RegularShip regular) {
			this.regular = regular;
		}



		public UCMShip getNavi() {
			return navi;
		}



		public void setNavi(UCMShip navi) {
			this.navi = navi;
		}



		public UCMShipLaser getUcmlaser() {
			return ucmlaser;
		}



		public void setUcmlaser(UCMShipLaser ucmlaser) {
			this.ucmlaser = ucmlaser;
		}



		public GamePrinter getPrinter() {
			return printer;
		}



		public void setPrinter(GamePrinter printer) {
			this.printer = printer;
		}



		public boolean isWin() {
			return win;
		}



		public void setWin(boolean win) {
			this.win = win;
		}



		public boolean isLose() {
			return lose;
		}



		public void setLose(boolean lose) {
			this.lose = lose;
		}



		public void setCycles(int cycles) {
			this.cycles = cycles;
		}
		public void setPoints(int points) {
			this.points = points;
		}
		public void setShockWave(boolean shockWave) {
			this.shockWave = shockWave;
		}
		public void setDifficulty(Level difficulty) {
			this.difficulty = difficulty;
		}
		
		//condicion para perder la partida
		public boolean loseCondition() {
			if(!winCondition()) {
				if(this.navi.getHp() <= 0) {
					return true;
				}
				if(regularList.getSize() != 0 && destroyerList.getSize() != 0) {
					if(this.regularList.getFirstY() >= 7 || this.destroyerList.getY() >= 7 || this.regularList.getLastY() >= 7) {
						return true;
					}
				}
			}
			return false;
		}
		//Aliens restantes en la partida
		public int aliensRemaining() {
			if(this.ovni.isExists()) {
				return this.regularList.getSize() + this.destroyerList.getSize() + 1;
			}
			return this.regularList.getSize() + this.destroyerList.getSize();
		}
		//Condicion para ganar ka partida
		public boolean winCondition() {
			if(this.aliensRemaining() <= 0) {
				return true;
			}
			return false;
		}
		//informacion de la partida
		public void info() {
			System.out.print("Life: " + this.navi.getHp() + "\n");
			System.out.print("Number of cycles: " + this.getCycles() + "\n");
			System.out.print("Points: " + this.getPoints() + "\n");
			System.out.print("Remaining Aliens: " + this.aliensRemaining() + "\n");
			System.out.print("Shockwave: ");
			if(this.getShockWave()) {
				System.out.print("YES" + "\n");
			}
			else {
				System.out.print("NO" + "\n");
			}
		}
		//daño del laser
		public boolean inflictDamage() {
			int n = regularList.isIn(navi.getLaser().getX(), navi.getLaser().getY());
			if(n != (-1) && n < regularList.getSize()) {
				if(regularList.damage(n)) {
					regularList.deleteNave(n);
					this.setPoints(getPoints() + regularList.getPoints());
				}
				return true;
			}
			n = destroyerList.isIn(navi.getLaser().getX(), navi.getLaser().getY());
			if(n != (-1) && n < destroyerList.getSize()) {
				if(destroyerList.damage(n)) {
					destroyerList.deleteNave(n);
					this.setPoints(getPoints() + destroyerList.getPoints());
				}
				return true;
			}
			n = bombList.isIn(navi.getLaser().getX(), navi.getLaser().getY());
			if(n != (-1) && n < bombList.getLength()) {
				bombList.setExist(this.navi.getLaser().getX(),this.navi.getLaser().getY());
				return true;
			}
			if(ovni.isIn(navi.getLaser().getX(), navi.getLaser().getY())) {
				if(!this.getShockWave()) {
					this.setShockWave(true);
				}
				this.setPoints(this.getPoints() + ovni.getPoints());
				ovni.setExists(false);
				return true;
			}
			if(navi.getLaser().getX() <= 0) {
				return true;
			}
			return false;
		}
		//ShockWave
		public void shock() {
			int cont = 0;
			for (int i =0; i < regularList.getSize(); i++) {
				if(this.regularList.damage(i)) {
					this.setPoints(getPoints() + regularList.getPoints());
					cont++;
				}
			}
			this.regularList.setSize(regularList.getSize() - cont);
			cont = 0;
			for (int i = 0; i < destroyerList.getSize(); i++) {
				if(this.destroyerList.damage(i)){
					this.setPoints(getPoints() + destroyerList.getPoints());
					cont++;
				}
				this.destroyerList.setSize(this.destroyerList.getSize() - cont);
			}
			if(ovni.isExists()) {
				this.setPoints(this.getPoints() + ovni.getPoints());
				ovni.setExists(false);
			}
			this.setShockWave(false);
		}
		
		
}