package logic;

import interfaces.IPlayerController;
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
	private char lastDir;
	private Random rand;

	GameObjectBoard board;

	private UCMShip navi;
	
	private boolean doExit;
	private BoardInitializer initializer;
	
	public Game (Level level, String seed){
		this.seed = seed;
		this.level = level;
		this.lastDir = 'b';
		this.rand = new Random(Long.parseLong(seed));
		this.doExit = false;
		initializer = new BoardInitializer();
		initGame();
	}
	
	public Random getRandom() {
		return this.rand;
	}
	
	public void initGame () {
		currentCycle = 0;
		board = initializer.initialize(this, level);
		navi = new UCMShip(7, 4, 3, 0, this, false, true);
		board.add(navi);
	}
	
	public boolean isDoExit() {
		return this.doExit;
	}
	
	public void setDoExit(boolean doExit) {
		this.doExit = doExit;
	}
	
	public char getLastDir() {
		return this.lastDir;
	}
	
	public void setLastDir(char lastDir) {
		this.lastDir = lastDir;
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
		return !navi.isAlive() || false;
	}
	
	private boolean playerWin () {
		return false;
	}
	
	public void update() {
		board.computerAction();
		board.update();
		currentCycle += 1;
	}
	
	/*public boolean isOnBoard(int x, int y) {

		return null ;
	}*/
	
	public void exit() {
		doExit = true;
	}
	
	public String infoToString(){
	
		String info = "Life: " + this.navi.getHp() + "\n";
		info += "Number of cycles: " + this.currentCycle + "\n";
		info += "Points: " + this.navi.getPoints() + "\n";
		info += "Remaining Aliens: " + this.board.aliensRemaining() + "\n"; //contar en gameObject board cuantos aliens quedan
		info += "Shockwave: ";
		if(this.getShockWave()) { // mirar en board si el objecto shock existe
			info += "YES" + "\n";
		}
		else {
			info += "NO" + "\n";
		}
		return info; 
	}
	
	public String getWinnerMessage () {
		if (playerWin()) return "Player win!";
		else if (aliensWin()) return "Aliens win!";
		else if (doExit) return "Player exits the game";
		else return "This should not happen";
	}


	public boolean move(int numCells) {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean shootLaser() {
		if(navi.getLaser().isAlive()) {
			navi.shoot();
			return true;
		}
		return false;
	}

	@Override
	public boolean shockWave() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void receivePoints(int points) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enableShockWave() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enableMissile() {
		// TODO Auto-generated method stub
		
	}

	public String characterAtToString(int x, int y) {
		if(board.getObjectInPosition(x, y) != null) {
			return board.getObjectInPosition(x, y).toString();
		}
		return "";
	}
	
}
