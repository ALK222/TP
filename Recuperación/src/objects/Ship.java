package objects;

import logic.Game;

public abstract class Ship extends GameObject{

    //ATRIBUTTES

    protected int points;
    
    //CONSTRUCTOR

    public Ship(int x, int y, Game game, int points){
        super(game, x, y);
        this.points = points;
    }

    //SETTERS AND GETTERS

    public int getPoints(){
        return this.points;
    }

    public void setPoints(int points){
        this.points = points;
    }

    //METHODS

    public boolean canAttack(){
        return false;
    }
}