package objects;

import logic.Game;

public final class UCMShip extends Ship {

    //ATRIBUTTES

    private int hp;

    private Laser laser;

    private Laser superL;

    private boolean shockWave;

    public UCMShip(int x, int y, Game game, Laser laser, Laser superL) {
        super(x, y, game, 0);
        this.hp = 3;
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

    public Laser getSuperL(){
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
    public void computerAction() {
        this.getLaser().computerAction();
        this.getSuperL().computerAction();
    }

    @Override
    public void move(char dir) {
        //Not used
    }

    public String toString() {
        if(this.hp > 0){
            return "<"+ this.getHp() +">";
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

    public void shoot(){
        this.getLaser().setActive(true);
        this.getLaser().setX(this.getX());
        this.getLaser().setY(this.getY());
    }

    public void superShoot(){
        this.getSuperL().setActive(true);
        this.getSuperL().setX(this.getX());
        this.getSuperL().setY(this.getY());
    }

}