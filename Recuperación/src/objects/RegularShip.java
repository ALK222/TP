package objects;

import logic.Game;

public final class RegularShip extends AlienShip {

    // ATRIBUTTES

    private boolean explosive;

    //CONSTRUCTOR

    public RegularShip(int x, int y, Game game, int hp, boolean explosive) {
        super(x, y, game, hp, 5);
        this.explosive = explosive;
    }

    //METHODS

    @Override
    public void computerAction() {
        // TODO Auto-generated method stub

    }

    @Override
    public String toString() {
        if(explosive){
            return "E[" + this.getHp() + "]";
        }
        return "R[" + this.getHp() + "]";
    }

    public void damage(int damage) {
        this.setHp(this.getHp() - damage);
    }

    public String stringify() {
        if(explosive) {
			return "E " + this.getX() + ";" + this.getY() + ";" + this.getHp() +";"
					+ game.getCurrentCycle() % game.getLevel().getNumCyclesToMoveOneCell();
		}
		return "R " + this.getX() + ";" + this.getY() + ";" + this.getHp() +";"
		+ game.getCurrentCycle() % game.getLevel().getNumCyclesToMoveOneCell();
    }

    @Override
    public boolean canDelete() {
        return this.getHp() <= 0;
    }

    public boolean canCount(){
        return this.getHp() > 0;
    }

}