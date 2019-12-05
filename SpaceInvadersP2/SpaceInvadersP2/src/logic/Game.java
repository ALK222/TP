package logic;

import interfaces.GamePrinter;
import interfaces.IPlayerController;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.String;
import java.util.Random;

import Objects.*;
import utils.*;

public class Game implements IPlayerController{
	public final static int DIM_X = 9;
	public final static int DIM_Y = 8;

	private int currentCycle;
	private String seed;
	private Level level;
	private Random rand;
	private char printerOption;
	
	private ShockWave shock;
	private SuperMisille superM;

	GameObjectBoard board;

	

	private UCMShip navi;
	private Laser laser;
	private int ammo;
	
	private boolean doExit;
	private BoardInitializer initializer;
	
	public Game (Level level, String seed){
		this.seed = seed;
		this.level = level;
		this.rand = new Random(Long.parseLong(seed));
		this.doExit = false;
		initializer = new BoardInitializer();
		initGame();
		printerOption = 'b';
	}
	
	public int getCurrentCycle() {
		return currentCycle;
	}

	public void setCurrentCycle(int currentCycle) {
		this.currentCycle = currentCycle;
	}

	public int getAmmo() {
		return ammo;
	}

	public void setAmmo(int ammo) {
		this.ammo = ammo;
	}
	
	public Random getRandom() {
		return this.rand;
	}
	
	public void setPrinterOption(char printerOption) {
		this.printerOption = printerOption;
	}
	
	public char getPrinterOption() {
		return this.printerOption;
	}
	
	public void initGame () {
		currentCycle = 0;
		board = initializer.initialize(this, level);
		laser = new Laser(0, 0, this, false, true, false);
		addObject(laser);
		navi = new UCMShip(7, 4, 3, 0, this, false, true, laser);
		addObject(navi);
		shock = new ShockWave(0, 0, this, false, true, false);
		superM = new SuperMisille(0, 0, this, false, true, false);
		addObject(superM);
		ammo = 0;
	}
	
	public boolean isDoExit() {
		return this.doExit;
	}
	
	public void setDoExit(boolean doExit) {
		this.doExit = doExit;
	}
	
	public String getSeed() {
		return seed;
	}
	
	public Level getLevel() {
		return level;
	}
	
	public void reset() {
		initGame();
	}

	public void addObject(GameObject object) {
		board.add(object);
	}
	
	public String positionToString(int x, int y ) {
		return board.toString(x, y);
	}

	public boolean isFinished() {
		return playerWin() || aliensWin() || doExit;
	}
	
	public boolean aliensWin() {
		return !navi.isAlive() || board.haveLanded();
	}
	
	private boolean playerWin () {
		if(board.aliensRemaining() <= 0) {
			return true;
		}
		return false;
	}
	
	public void update() {
		board.computerAction();
		detectSuperDamage();
		board.update();
		if(currentCycle % this.getLevel().getNumCyclesToMoveOneCell() == 0 && currentCycle != 0) {
			board.move();
		}
		currentCycle += 1;
	}
	
	
	public void exit() {
		doExit = true;
	}
	
	public String infoToString(){
	
		String info = "Life: " + this.navi.getHp() + "\n";
		info += "Number of cycles: " + this.currentCycle + "\n";
		info += "Points: " + this.navi.getPoints() + "\n";
		info += "Remaining Aliens: " + this.board.aliensRemaining() + "\n"; //contar en gameObject board cuantos aliens quedan
		info += "Shockwave: ";
		if(this.shockWave()) { // checks if shockwave is active or not
			info += "YES" + "\n";
		}
		else {
			info += "NO" + "\n";
		}
		info += "Ammo: ";
		for(int i = 0; i < ammo; ++i) {
			info += "|";
		}
		return info; 
	}
	
	public String getWinnerMessage () {
		if (playerWin()) return "Player win!";
		else if (aliensWin()) return "Aliens win!";
		else if (doExit) return "Player exits the game";
		else return "This should not happen";
	}
	
	
	
	public boolean move(String direction, int numCells ) {
		
		if(direction.equals("right")) {
			numCells *= -1;
		}
		if(navi.getY() + numCells > 0 && navi.getY() + numCells < 9) {
			navi.move(numCells);
			return true;
		}
		return false;
	}

	
	public boolean shootLaser(String option) {
		if(option == null) {
			if(!navi.getLaser().isActive()) {
				navi.shoot();
				return true;
			}
		}
		else {
			if(option == "supermisil") {
				if(this.shootSuperLaser()) {
					return true;
				}
			}
		}
		
		return false;
	}

	public boolean shockWave() {
		if(shock.isActive()) {
			return true;
		}
		return false;
	}


	public void receivePoints(int points) {
		navi.setPoints(navi.getPoints() + points);
		
	}


	public void enableShockWave() {
		this.shock.setActive(true);
		
	}


	public void enableMissile() {
		navi.getLaser().setActive(false);
		
	}

	public String characterAtToString(int x, int y) {
		if(board.getObjectInPosition(x, y) != null) {
			return board.getObjectInPosition(x, y).toString();
		}
		return "";
	}
	
	public String stringify(int x, int y) {
		if(board.getObjectInPosition(x, y) != null) {
			return board.getObjectInPosition(x, y).stringify() + "\n";
		}
		return "";
	}
	
	public void explosion(int x, int y) {
		x -= 1;
		y -= 1;
		int radio = 3;
		for(int i = 0; i < radio; ++i) {
			for(int j = 0; j < radio; ++j) {
				if(board.getObjectInPosition(x + i, y +j) != null) {
					board.getObjectInPosition(x + i, y +j).damage(1);
				}
			}
		}
		board.update();
	}
	
	public boolean useShockWave() {
		if(this.shockWave()) {
			
			board.shockWaveDamage();
			
			this.shock.setActive(false);
			
			return true;
		}
		return false;
	}
	
	
		
	public void removeAmmo() {
		ammo--;
	}
	
	
	public void saveState(String filename) throws IOException{
		GamePrinter s = new Stringifier(this);
		String str = s.toString(this);
		BufferedWriter writer = new BufferedWriter(new FileWriter(filename + ".dat", true));
		writer.append(str);
		     
		writer.close();
		
	}

	
	public boolean shootSuperLaser() {
		if(ammo > 0 && !this.superM.isActive()) {
			superM.setX(navi.getX());
			superM.setY(navi.getY());
			superM.setActive(true);
			--ammo;
			return true;
		}
		return false;
	}

	public boolean buy() {
		if(navi.getPoints() >= 20) {
			++ammo;
			navi.setPoints(navi.getPoints() - 20);
			return true;
		}
		return false;
	}
	
	public void detectSuperDamage() {
		board.searchTarget(superM);
	}
	
		
}
