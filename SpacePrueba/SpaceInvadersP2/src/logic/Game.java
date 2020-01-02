package logic;

import java.util.Random;

import objects.*;
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

    private GameObjectBoard board;

    private BoardInitializer initialize = new BoardInitializer();

    //CONSTRUCTORS

    public Game(Level level, String seed) {
        this.level = level;
        this.seed = seed;
        this.rand = new Random(Long.parseLong(seed));
        initGame();
    }

    //METHODS

    public void initGame(){
        this.ammo = 0;
        this.gameCycle = 0;
        this.board = initialize;
    }

    public String characterAtToString(int x, int y){
        if(board.objectAtPosition(x, y) != null) {
			return board.objectAtPosition(x, y).toString();
		}
		return "";
    }


}