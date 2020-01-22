package objects;

import logic.Game;

public final class DestroyerShip extends AlienShip {

    //ATRIBUTTES

    private Bomb bomb;

    //CONSTRUCTOR

    public DestroyerShip(int x, int y, Game game, int hp, Bomb bomb) {
        super(x, y, game, hp, 10);
        this.bomb = bomb;
    }

    //GETTERS AND SETTERS

    public Bomb getBomb(){
        return this.bomb;
    }

    //METHODS

    public void computerAction() {
        if(!this.getBomb().isActive()){
            if(this.canGenerateRandomBomb(game)){
                this.shoot();
            }
        }
        this.bomb.computerAction();
    }

    public String toString() {
        return "D[" + this.getHp() + "]";
    }

    public void damage(int damage) {
        this.setHp(this.getHp() - damage);
        if(canDelete()){
            this.game.receivePoints(this.getPoints());
            this.getBomb().setDelete(true);
        }        
    }

    public String stringify() {
        return "D " + this.getX() + ";" + this.getY() + ";" + this.getHp() +";"
				+ game.getCurrentCycle() % game.getLevel().getNumCyclesToMoveOneCell();
    }

    public boolean canDelete() {
        return this.getHp() <= 0;
    }

    public void shoot(){
        this.getBomb().setActive(true);
        this.getBomb().setX(this.getX());
        this.getBomb().setY(this.getY());
    }
    
}