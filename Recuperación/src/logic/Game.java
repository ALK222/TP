package logic;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import exceptions.CommandExecuteException;
import exceptions.CommandMovementException;
import interfaces.GamePrinter;
import interfaces.IPlayerController;
import objects.Berserk;
import objects.Bomb;
import objects.DestroyerShip;
import objects.GameObjectBoard;
import objects.Laser;
import objects.UCMShip;
import objects.Weapon;
import utils.BoardInitializer;
import utils.Level;
import utils.Stringifier;

public final class Game implements IPlayerController {

    /*
     * 
     * Logic of the Game
     * 
     */

    // ATRIBUTTES

    public final static int DIM_X = 9;
    // Size of the board
    public final static int DIM_Y = 8;

    private int gameCycle;// Cycles of the game to control ship movement

    private int ammo;// Ammo for the supermisille

    private String seed;// Seed of the random

    private Level level;// Level of difficulty

    private Random rand;// Random of the game

    private boolean doExit;// Player wants to exit?

    private boolean shockWave;// Can I use shock?

    private GameObjectBoard board;// "Board" for the game

    private UCMShip navi;// Our fellow ship

    private BoardInitializer initialize = new BoardInitializer();// Creator of the board

    private int fila; // Line on where ships are

    private char printerOption;// Options for the printer 'b' for board and 's' for string

    // CONSTRUCTORS

    public Game(Level level, String seed) {
        this.level = level;
        this.seed = seed;
        this.rand = new Random(Long.parseLong(seed));
        this.shockWave = false;
        initGame();
    }

    // GETTERS AND SETTERS

    public int getCurrentCycle() {
        return gameCycle;
    }

    public Level getLevel() {
        return level;
    }

    public Random getRand() {
        return this.rand;
    }

    public int getAmmo() {
        return this.ammo;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getFila() {
        return this.fila;
    }

    public char getPrinterOption() {
        return this.printerOption;
    }

    public void setPrinterOption(char printerOption) {
        this.printerOption = printerOption;
    }

    public void setExit(boolean exit) {
        this.doExit = exit;
    }

    public String getSeed() {
        return this.seed;
    }

    // METHODS

    // Init of the game, used to start and restart the game
    public void initGame() {
        this.ammo = 0;
        this.fila = 1;
        this.gameCycle = 0;
        doExit = false;
        printerOption = 'b';
        this.board = initialize.initialize(this, level);
        this.navi = new UCMShip(DIM_Y - 1, (DIM_X / 2), this, null, null);
        board.add(navi);
    }

    // returns the symbol of a character at position (x,y) if it exists, if not,
    // returns ""
    public String characterAtToString(int x, int y) {
        return board.toString(x, y);
    }

    // Message shown at the end of the game
    public String getWinnerMessage() {
        if (playerWin()) {
            return "Player win!";
        } else if (aliensWin()) {
            return "Aliens win!";
        } else if (doExit) {
            return "Player exits the game";
        } else {
            receivePoints(100000000);
            return "You found a bug, I'll give you 100000000 points";
        }
    }

    // Checks if the aliens are in the bottom line or if the player has die
    private boolean aliensWin() {
        if (board.haveLanded() || navi.getHp() <= 0) {
            return true;
        }
        return false;
    }

    // Checks if all aliens are dead
    private boolean playerWin() {
        if (board.aliensRemaining() <= 0) {
            return true;
        }
        return false;
    }

    // Checks if the game is over
    public boolean isFinished() {
        return playerWin() || aliensWin() || doExit;
    }

    // Awards points to the player
    public void receivePoints(int points) {
        navi.setPoints(navi.getPoints() + points);
    }

    // ShockWave enabler
    public void enableShockWave() {
        this.shockWave = true;
    }

    // ShockWave Damage
    public void shockWave() throws CommandExecuteException {
        if (this.shockWave) {
            board.shockDamage();
            this.shockWave = false;
        } else {
            throw new CommandExecuteException("Shockwave is not ready");
        }
    }

    // Movement of the player ship
    public void move(String direction, int numCells) throws CommandMovementException {
        if (numCells < 1 && numCells > 2) {// (Not looking for exact values so maximun steps can be increased)
            throw new CommandMovementException("Incorrect speed, please check the value");
        }
        if (direction.charAt(0) == 'l') {
            numCells = numCells * -1;
        }
        if (navi.getY() + numCells > 0 || navi.getY() + numCells < 8) {
            navi.setY(navi.getY() + numCells);
        } else {
            throw new CommandMovementException("I can not go there");
        }

    }

    // Shoot laser or superLaser
    public void shootLaser(String option) throws CommandExecuteException {
        if (option != null) {
            if (navi.getSuperL() != null) {
                throw new CommandExecuteException("Super Missile is active");
            } else if (this.getAmmo() <= 0) {
                throw new CommandExecuteException("No ammo available");
            } else {
                this.naviSuperShoot();
            }
        } else {
            if (navi.getLaser() != null) {
                throw new CommandExecuteException("Misile is active");
            } else {
                this.naviShoot();
            }
        }
    }

    private void naviShoot() {
        navi.setLaser(new Laser(navi.getX(), navi.getY(), this, true, 1));
        this.board.add(navi.getLaser());
    }

    private void naviSuperShoot() {
        navi.setSuperLaser(new Laser(navi.getX(), navi.getY(), this, true, 2));
        this.board.add(navi.getSuperL());
    }

    // Enable UCMShip missile
    public void enableMissile(Laser laser) {
        board.delete(laser);
        laser = null;
        navi.setLaser(null);
    }

    public void enableSuperMissile(Laser laser) {
        board.delete(laser);
        laser = null;
        navi.setSuperLaser(null);
    }

    // Explosive ships damage
    public void explosiveDamage(int x, int y) {
        board.explosiveDamage(x, y);
    }

    // Cycle update
    public void update() {
        if (gameCycle % getLevel().getNumCyclesToMoveOneCell() == 0 && gameCycle != 0) {
            this.setFila(board.move(this.getFila()));// Ships move
        }
        board.computerAction();// Shots are fired(if probability wants) and proyectiles move and do damage
        board.update();// Dead ships are removed
        ++gameCycle;
    }

    // Collision detector for weapons
    public void detectDamage(Weapon other) {
        board.detectDamage(other);
    }

    public String stringify(int i, int j) {
        return board.stringify(i, j);
    }

    public void buy() throws CommandExecuteException {
        if (navi.getPoints() >= 20) {
            ++this.ammo;
            navi.setPoints(navi.getPoints() - 20);
        } else {
            throw new CommandExecuteException("Not enought points to buy a super missile");
        }
    }

    public String infoToString() {
        String info = "Life: " + this.navi.getHp() + "\n";
        info += "Number of cycles: " + this.gameCycle + "\n";
        info += "Points: " + this.navi.getPoints() + "\n";
        info += "Remaining Aliens: " + this.board.aliensRemaining() + "\n"; // contar en gameObject board cuantos aliens
                                                                            // quedan
        info += "Shockwave: ";
        if (this.shockWave) { // checks if shockwave is active or not
            info += "YES" + "\n";
        } else {
            info += "NO" + "\n";
        }
        info += "Ammo: ";
        for (int i = 0; i < ammo; ++i) {
            info += "|";
        }
        return info;
    }

    public void saveState(String filename) throws IOException {
        GamePrinter s = new Stringifier(this);
        String str = s.toString(this);
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename + ".dat", true));
        writer.append(str);
        writer.close();
    }

    public void alienShoot(DestroyerShip ds) {
        if (board.supNear(ds.getX(), ds.getY())) {
            ds.setBomb(new Bomb(ds.getX(), ds.getY(), true, 2, this));
        } else {
            ds.setBomb(new Bomb(ds.getX(), ds.getY(), true, 1, this));
        }
        board.add(ds.getBomb());
    }

    public void disableBomb(Bomb bomb) {
        board.delete(bomb);
        bomb = null;
    }

    public boolean objectNearSat(int x, int y) {
        return !board.isEmpty(x, y);
    }

    public void addBerserk(int x, int y) {
        board.add(new Berserk(x, y, this, 1));
    }
}
