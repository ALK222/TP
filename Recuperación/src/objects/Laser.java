package objects;

import logic.Game;

public final class Laser extends Weapon {

    //CONSTRUCTOR

    public Laser(int x, int y, Game game, boolean active, int damage) {
        super(x, y, game, active, damage);
    }

    //METHODS

    public boolean isAlien() {
        return false;
    }

    public void computerAction() {
        if(isActive()){
            setX(getX() - 1);
            game.detectDamage(this);
            if(this.getX() < 0){
                setActive(false);
                setX(10);
                setY(10);
            }
        }
    }

    public void move(char dir) {
    }

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

    public void damage(int damage) {
        this.setActive(false);
		this.setX(10);
        this.setY(10);
    }

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