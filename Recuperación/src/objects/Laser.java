package objects;

import logic.Game;

public final class Laser extends Weapon {

    //CONSTRUCTOR

    public Laser(int x, int y, Game game, boolean active, int damage) {
        super(x, y, game, active, damage);
    }

    //METHODS
    @Override
    public boolean isAlien() {
        return false;
    }
    @Override
    public void computerAction() {
            setX(getX() - 1);
            game.detectDamage(this);
    }
    @Override
    public void move(char dir) {
    }
    @Override
    public String toString() {
        if(isActive()){
            if(damage > 1){
                return superLaserString();
            }
            else{
                return laserString();
            }
        }
        return "";
    }

    public String laserString(){
        return "ºº";
    }

    public String superLaserString(){
        return "^";
    }
    @Override
    public void damage(int damage) {
        if(this.damage == 1)  game.enableMissile(this);
        else game.enableSuperMissile(this);
    }
    @Override
    public String stringify() {
        if(isActive()){
            if(this.damage > 1){
                return this.stringiSuper();
            }
            else{
                return this.stringiLaser();
            }
        }
		return "";
    }

    public String stringiLaser(){
        return "M " + this.getX() + ";" + this.getY();
    }

    public String stringiSuper(){
        return "S " + this.getX() + ";" + this.getY();
    }
    
}