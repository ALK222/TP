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
        if(this.getX() >= 8){
            setActive(false);
            setX(10);
            setY(10);
        }
    }

    public void move(char dir) {
        setX(getX() - 1);

    }

    public String toString() {
        if(isActive()){
            return "|";
        }
        return "";
    }

    public void damage(int damage) {
        this.setActive(false);
		this.setX(10);
        this.setY(10);
    }

    public String stringify() {
        if(isActive()){
         return "S " + this.getX() + ";" + this.getY();
        }
		return "";
    }
    
}