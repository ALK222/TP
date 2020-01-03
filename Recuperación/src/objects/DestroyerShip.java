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
        // TODO Auto-generated method stub

    }

    public String toString() {
        return "D[" + this.getHp() + "]";
    }

    public void damage(int damage) {
        this.setHp(this.getHp() - damage);
        if(canDelete()){
            this.game.givePoints(this.getPoints());
            this.getBomb().setDelete(true);
        }        
    }

    public String stringify() {
        return "D " + this.getX() + ";" + this.getY() + ";" + this.getHp() +";"
				+ game.getCurrentCycle() % game.getLevel().getNumCyclesToMoveOneCell();
    }

    @Override
    public boolean canDelete() {
        return this.getHp() <= 0;
    }

    @Override
    public boolean canCount() {
        return true;
    }
    
}