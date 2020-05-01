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

    public void setBomb(Bomb bob){
        this.bomb = bob;
    }

    //METHODS
    @Override
    public void computerAction() {
        if(this.getBomb() == null){
            if(this.canGenerateRandomBomb(game)){
                game.alienShoot(this);
            }
        }
        else{
            if(this.bomb.getX() >= 8){
                 game.disableBomb(this.getBomb());
                 this.bomb = null;
            }
        }
        
    }
    @Override
    public String toString() {
        return "D[" + this.getHp() + "]";
    }
    @Override
    public void damage(int damage) {
        this.setHp(this.getHp() - damage);
        if(canDelete()){
            this.game.receivePoints(this.getPoints());
        }        
    }
    @Override
    public String stringify() {
        return "D " + this.getX() + ";" + this.getY() + ";" + this.getHp() +";"
				+ game.getCurrentCycle() % game.getLevel().getNumCyclesToMoveOneCell();
    }
    @Override
    public boolean canDelete() {
        return this.getHp() <= 0;
    }
    
    public boolean receiveShockWaveAttack(int damage){
        this.damage(damage);
        return true;
    }
    
}