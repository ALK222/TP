package objects;

import logic.Game;

public final class Ovni extends Ship {
    
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
        if(this.getY() <= 0 || this.getY() >= 8){
            this.setActive(false);
        }
    }

    public void move(char dir) {
        --this.y;

    }

    public String toString() {
        if(this.isActive()){
            return "O[" + 1 + "]";
        }
        return "";
    }

    public void damage(int damage) {
        this.setActive(false);
        this.game.enableShock();
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
}