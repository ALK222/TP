package objects;

import logic.Game;

public final class Bomb extends Weapon {

    //CONSTRUCTOR
    
    public Bomb(int x, int y,boolean active, int damage, Game game) {
        super(x, y, game, active, damage);
    }

    //METHODS
    @Override
    public void computerAction() {
        setX(getX() + 1);
        game.detectDamage(this);
    }
    @Override
    public void move(char dir) {

    }

    public String toString() {
        if(isActive()){
            return ".";
        }
        return "";
    }
    @Override
    public void damage(int damage) {
        game.disableBomb(this);
    }
    @Override
    public String stringify() {
        if(this.isActive()) {
			return "B ;" + this.getX() + ";" + this.getY();
		}
		return "";
    }
    @Override
    public boolean canAttack(){
        return true;
    }

}