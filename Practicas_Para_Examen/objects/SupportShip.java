package objects;

import logic.Game;

public class SupportShip extends AlienShip {

    public SupportShip(int x, int y, Game game, int hp) {
        super(x, y, game, hp, 15);
    }

    @Override
    public void computerAction() {
        // Lazy boi
    }

    @Override
    public String toString() {
        return "S[" + this.getHp() + "]";
    }

    @Override
    public void damage(int damage) {
        this.setHp(this.getHp() - damage);
        if (canDelete()) {
            game.receivePoints(this.getPoints());
        }
    }

    @Override
    public String stringify() {
        return "S " + this.getX() + ";" + this.getY() + ";" + this.getHp() + ";"
                + game.getCurrentCycle() % game.getLevel().getNumCyclesToMoveOneCell();
    }

    @Override
    public boolean canDelete() {
        return this.getHp() <= 0;
    }

    @Override
    public boolean canCount() {
        return this.getHp() > 0;
    }

    @Override
    public boolean receiveShockWaveAttack(int damage) {
        this.damage(damage);
        return true;
    }

}
