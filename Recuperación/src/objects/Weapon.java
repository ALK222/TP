package objects;

import logic.Game;

public abstract class Weapon extends GameObject {

    /*
    
            Blueprint for all weapons in this game
    
    */


    //ATRIBUTTES

    protected int damage;

    protected boolean active;

    protected boolean delete;

    //CONSTRUCTOR

    public Weapon(int x, int y, Game game, boolean active, int damage){
        super(game, x, y);
        this.damage = damage;
        this.active = active;
        this.delete = false;
    }

    //SETTERS AND GETTERS

    public void setDamage(int damage){
        this.damage = damage;
    }

    public int getDamage(){
        return this.damage;
    }
    
    public boolean isActive(){
        return this.active;
    }

    public void setActive(boolean active){
        this.active = active;
    }

    public boolean canDelete(){
        return delete;
    }

    public void setDelete(boolean delete){
        this.delete = delete;
    }

    //METHODS

    public boolean canAttack(){
        return true;
    }

    public boolean canCount(){
        return false;
    }
}