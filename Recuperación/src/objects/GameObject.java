package objects;

import interfaces.IAttack;
import logic.Game;


public abstract class GameObject implements IAttack{

    //ATRIBUTTES
    protected Game game;
    protected int x;
    protected int y;

    //CONSTRUCTORS

    public GameObject(final Game game, final int x, final int y){
        this.game = game;
        this.x = x;
        this.y = y;
    }

    public GameObject() {
        // Void constructor for the loader
        this.game = null;
        this.x = 0;
        this.y = 0;
    }

    // GETTERS AND SETTERS

    public int getX() {
        return this.x;
    }

    public void setX(final int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(final int y) {
        this.y = y;
    }

    public void setGame(final Game game) {
        //Used in loader
        this.game = game;
    }

    //METHODS

    public boolean isIn(int x, int y){
        return this.x == x && this.y == y;
    }
    
    public abstract boolean isAlien();//True if object is alien, false if not
    
    public abstract boolean isOnBorder();//Only returns true if the object in the border is an alien ship
    
    public abstract void computerAction();//Makes the computer acction each turn
    
    public abstract void move(char dir);//moves the object
    
    public abstract String toString();//returns the symbol of the object
    
    public abstract void damage(int damage);//
    
    public abstract String stringify();//String of the object with info

    public abstract boolean haveLanded();//Checks if alien ships have landed

    public abstract boolean canAttack();//returns true on weapons, false on ships

    public abstract boolean canDelete();//ships can be deleted except for the ovni, weapons not

    public abstract boolean canCount();//checks if it can be count for remaining aliens
}