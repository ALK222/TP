package objects;

import logic.Game;

public final class UCMShip extends Ship {

    //ATRIBUTTES

    private int hp;

    private Laser laser;

    private SuperLaser superL;

    private boolean shockWave;

    public UCMShip(int x, int y, Game game, Laser laser, SuperLaser superL) {
        super(x, y, game, 0);
        this.laser = laser;
        this.superL = superL;
        this.shockWave = false;
    }

    //SETTERS AND GETTERS

    public int getHp(){
        return this.hp;
    }

    public Laser getLaser(){
        return this.laser;
    }

    public SuperLaser getSuperL(){
        return this.superL;
    }

    public void setSockWave(boolean shockWave){
        this.shockWave = shockWave;
    }

    public boolean getSockWave(){
        return this.shockWave;
    }

    //METHODS

    public boolean isAlien() {
        return false;
    }

    public boolean isOnBorder() {
        return false;
    }
    @Override
    public void computerAction() {
        //Me da a mi que no
    }

    @Override
    public void move(char dir) {
    }

    @Override
    public String toString() {
        if(this.hp > 0){
            return "^_^";
        }
        return "!xx!";
    }

    public void damage(int damage) {
        this.hp -= damage;
    }

    public String stringify() {
        return "P " + this.getX() + ";" + this.getY() + ";" + this.hp +";"
				+ points + this.getSockWave() + ";" + game.getAmmo();
    }

    public boolean haveLanded() {
        return false;
    }

    public boolean canDelete() {
        return false;
    }

    public boolean canCount() {
        return false;
    }

}