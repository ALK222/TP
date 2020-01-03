package logic;

import java.util.Random;

import objects.*;
import utils.BoardInitializer;
import utils.Level;

public final class Game {

    /*
           
            Logic of the Game
    
    */

    //ATRIBUTTES
    public final static int DIM_X = 9;

    public final static int DIM_Y = 8;

    private int gameCycle;

    private int ammo;

    private String seed;

    private Level level;

    private Random rand;

    private boolean doExit;

    private GameObjectBoard board;

    private UCMShip navi;

    private BoardInitializer initialize = new BoardInitializer();

    //CONSTRUCTORS

    public Game(Level level, String seed) {
        this.level = level;
        this.seed = seed;
        this.rand = new Random(Long.parseLong(seed));
        initGame();
    }

    //GETTERS

    public int getCurrentCycle(){
        return gameCycle;
    }

    public Level getLevel(){
        return level;
    }

    //METHODS

    public void initGame(){
        this.ammo = 0;
        this.gameCycle = 0;
        doExit = false;
        this.board = initialize.initialize(this, level);
    }

    public String characterAtToString(int x, int y){
        if(board.objectAtPosition(x, y) != null) {
			return board.objectAtPosition(x, y).toString();
		}
		return "";
    }

	public String getWinnerMessage() {
		if (playerWin()){
          return "Player win!";  
        } 
		else if (aliensWin()){
           return "Aliens win!"; 
        } 
		else if (doExit){
            return "Player exits the game";
        } 
		else{
            return "This should not happen";
        } 
	}

    private boolean aliensWin() {
        if(board.haveLanded()){
            return true;
        }
        return false;
    }

    private boolean playerWin() {
        if(board.aliensRemaining() <= 0){
            return true;
        }
        return false;
    }

	public boolean isFinished() {
		return playerWin() || aliensWin() || doExit;
	}

	public void givePoints(int points) {
        navi.setPoints(navi.getPoints() + points);
	}


}