package objects;

import interfaces.IExecuteRandomActions;
import logic.Game;

public final class Ovni extends Ship implements IExecuteRandomActions{
    
    // ATRIBUTTES
    
    private boolean active;
    
    //CONSTRUCTORES

    public Ovni(int x, int y, Game game, int points, boolean active) {
        super(x, y, game, points);
        this.active = active;
    }

    //SETTERS AND GETTERS
    
    public void setActive(boolean active){
        this.active = active;
    }

    public boolean isActive(){
        return this.active;
    }

    //METHODS

    public boolean isAlien() {
        return true;
    }

    public boolean isOnBorder() {
        return false;
    }

    public void computerAction() {
        if(!this.active){
            if(this.canGenerateRandomOvni(game)){
                this.setActive(true);
                this.setX(8);
                this.setX(0);
            }
        }
        else{
            this.setY(this.getY() - 1);
        }
        if(this.getY() <= 0 || this.getY() >= 8){
            this.setActive(false);
        }
    }

    public void move(char dir) {
        //not used
    }

    public String toString() {
        if(this.isActive()){
            return "O[" + 1 + "]";
        }
        return "";
    }

    public void damage(int damage) {
        this.setActive(false);
        this.game.enableShockWave();
        this.game.receivePoints(this.points);
    }

    public String stringify() {
		if(isActive()) {
			return "O[" + 1 + "]";
		}
		return "";
    }

    public boolean haveLanded() {
        return false;
    }

    public boolean canDelete() {
        return false;
    }

    public boolean canCount() {
        if(isActive()){
            return true;
        }
        return false;
    }

    public boolean reciveShockAttack(int damage){
        this.damage(damage);
        return true;
    }
}