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
	private Random rand;
	private Level level;
	private char lastDir;

	GameObjectBoard board;

	private UCMShip navi;
	
	private boolean doExit;
	private BoardInitializer initializer;
	
	public Game (Level level, Random random){
		this.rand = random;
		this.level = level;
		this.lastDir = 'b';
		initializer = new BoardInitializer();
		initGame();
	}
	
	public void initGame () {
		currentCycle = 0;
		board = initializer.initialize(this, level);
		navi = new UCMShip(DIM_X / 2, DIM_Y - 1, 3, 0, this, false);
		board.add(navi);
	}
	
	public char getLastDir() {
		return this.lastDir;
	}
	
	public void setLastDir(char lastDir) {
		this.lastDir = lastDir;
	}
	
	public Random getRandom() {
		return rand;
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
		return !navi.isAlive() || AlienShip.haveLanded();
	}
	
	private boolean playerWin () {
		return AlienShip.allDead();
	}
	
	public void update() {
		board.computerAction();
		board.update();
		currentCycle += 1;
	}
	
	public boolean isOnBoard(int x, int y) {

		return /* condición de rango sobre las coordenadas */ ;
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

	@Override
	public boolean shootLaser() {
		// TODO Auto-generated method stub
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
	
	// TODO implementar los métodos del interfaz IPlayerController
}
