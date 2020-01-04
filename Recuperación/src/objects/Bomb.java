package objects;

import logic.Game;

public final class Bomb extends Weapon {
    public Bomb(int x, int y,boolean active, int damage, Game game) {
        super(x, y, game, active, damage);
    }

    
    public boolean isAlien() {
        return true;
    }

    public void computerAction() {
        if(isActive()){
            setX(getX() + 1);
            if(this.getX() >= 8){
                setActive(false);
                setX(10);
                setY(10);
            }
            game.detectDamage(this);
        }
    }

    public void move(char dir) {

    }

    public String toString() {
        if(isActive()){
            return ".";
        }
        return "";
    }

    public void damage(int damage) {
        this.setActive(false);
		this.setX(10);
		this.setY(10);
		

    }

    public String stringify() {
        if(this.isActive()) {
			return "B ;" + this.getX() + ";" + this.getY();
		}
		return "";
    }

    public boolean canDelete() {
        return false;
    }

}