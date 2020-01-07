package logic;

import java.util.Random;

import interfaces.IPlayerController;
import objects.*;
import utils.BoardInitializer;
import utils.Level;

public final class Game implements IPlayerController{

    /*
           
            Logic of the Game
    
    */

    //ATRIBUTTES

    public final static int DIM_X = 9;
                                        //Size of the board
    public final static int DIM_Y = 8;

    private int gameCycle;//Cycles of the game to control ship movement

    private int ammo;//Ammo for the supermisille

    private String seed;//Seed of the random

    private Level level;//Level of difficulty

    private Random rand;//Random of the game

    private boolean doExit;//Player wants to exit?

    private boolean shockWave;//Can I use shock?

    private GameObjectBoard board;//"Board" for the game

    private Laser laser;

    private Laser superLaser;

    private UCMShip navi;//Our fellow ship

    private BoardInitializer initialize = new BoardInitializer();//Creator of the board

    private int fila; //Line on where ships are

    private char printerOption;//Options for the printer 'b' for board and 's' for string

    //CONSTRUCTORS

    public Game(Level level, String seed) {
        this.level = level;
        this.seed = seed;
        this.rand = new Random(Long.parseLong(seed));
        this.shockWave = false;
        initGame();
    }

    //GETTERS

    public int getCurrentCycle(){
        return gameCycle;
    }

    public Level getLevel(){
        return level;
    }

    public Random getRand(){
        return this.rand;
    }

    public int getAmmo(){
        return this.ammo;
    }

    public void setFila(int fila){
        this.fila = fila;
    }

    public int getFila(){
        return this.fila;
    }

    public char getPrinterOption() {
		return this.printerOption;
    }
    
    public void setPrinterOption(char printerOption){
        this.printerOption = printerOption;
    }

    //METHODS

    //Init of the game, used to start and restart the game
    public void initGame(){
        this.ammo = 0;
        this.fila = 1;
        this.gameCycle = 0;
        doExit = false;
        printerOption = 'b';
        this.board = initialize.initialize(this, level);
        this.laser = new Laser(10, 10, this, false, 1);
        this.board.add(laser);
        this.superLaser = new Laser(10, 10, this, false, 2);
        this.board.add(superLaser);
        this.navi = new UCMShip(DIM_Y - 1, (DIM_X/2), this, laser, superLaser);
        this.board.add(navi);
    }


    //returns the symbol of a character at position (x,y) if it exists, if not, returns ""
    public String characterAtToString(int x, int y){
        if(board.objectAtPosition(x, y) != null) {
			return board.objectAtPosition(x, y).toString();
		}
		return "";
    }

    //Message shown at the end of the game
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
    

    //Checks if the aliens are in the bottom line or if the player has die
    private boolean aliensWin() {
        if(board.haveLanded() || navi.getHp() <= 0){
            return true;
        }
        return false;
    }

    //Checks if all aliens are dead
    private boolean playerWin() {
        if(board.aliensRemaining() <= 0){
            return true;
        }
        return false;
    }


    //Checks if the game is over
	public boolean isFinished() {
		return playerWin() || aliensWin() || doExit;
	}


    //Awards points to the player
	public void receivePoints(int points) {
        navi.setPoints(navi.getPoints() + points);
	}


    //ShockWave enabler
	public void enableShockWave() {
        this.shockWave = true;
	}


    //ShockWave Damage
    public boolean shockWave(){
        if(this.shockWave){
            board.shockDamage();
            this.shockWave = false;
            return true;
        }
        return false;
    }

    //Movement of the player ship
    public boolean move(String direction, int numCells) {
        if(direction.charAt(0) == 'l'){
            numCells = numCells * -1;
        }
        if(navi.getY() + numCells > 0 || navi.getY() + numCells < 8){
            navi.setY(navi.getY() + numCells);
            return true;
        }
        return false;
    }

    //Shoot laser or superLaser
    public boolean shootLaser(String option) {
        if(option == "supermisil"){
            if(!navi.getSuperL().isActive() && this.getAmmo() > 0){
                navi.superShoot();
                --this.ammo;
                return true;
            }
        }
        else if(option == null){
            if(!navi.getLaser().isActive()){
                navi.shoot();
                return true;
            }
        }
        return false;
    }

    //Enable UCMShip missile
    public void enableMissile() {
        navi.getLaser().setActive(false);
    }

    //Explosive ships damage
	public void explosiveDamage(int x, int y) {
        board.explosiveDamage(x, y);
	}

    //Cycle update
	public void update() {
        if(gameCycle % getLevel().getNumCyclesToMoveOneCell() == 0 && gameCycle != 0){
            this.setFila(board.move(this.getFila()));//Ships move
        }
        board.computerAction();//Shots are fired(if probability wants) and proyectiles move and do damage
        board.update();//Dead ships are removed
        ++gameCycle;
	}

    //Collision detector for weapons
	public void detectDamage(Weapon other) {
        board.detectDamage(other);
	}

	public String stringify(int i, int j) {
        if(board.objectAt(i, j) != null){
            return board.objectAt(i, j).stringify() + "\n";
        }
		return "";
	}

}