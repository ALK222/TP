package objects;

import logic.Game;

public class ZombieShip extends AlienShip {

    public ZombieShip(int x, int y, Game game, int hp) {
        super(x, y, game, hp, 0);
    }

    @Override
    public void computerAction() {
        if (canDelete()) {
            game.addBerserk(this.x, this.y);
        }
    }

    @Override
    public String toString() {
        return "Z[" + getHp() + "]";
    }

    @Override
    public void damage(int damage) {
        this.setHp(this.getHp() - damage);
    }

    @Override
    public String stringify() {
        return "Z " + this.getX() + ";" + this.getY() + ";" + this.getHp() + ";"
                + game.getCurrentCycle() % game.getLevel().getNumCyclesToMoveOneCell();
    }

    @Override
    public boolean canDelete() {
        return this.getHp() <= 0;
    }

}
