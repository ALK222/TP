package objects;

import interfaces.IExecuteRandomActions;
import logic.Game;

public final class Ovni extends EnemyShip implements IExecuteRandomActions {

    // ATRIBUTTES

    private boolean active;

    // CONSTRUCTORES

    public Ovni(int x, int y, Game game, int points, boolean active) {
        super(x, y, game, points);
        this.active = active;
    }

    // SETTERS AND GETTERS

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return this.active;
    }

    // METHODS
    @Override
    public void computerAction() {
        if (!this.active) {
            if (this.canGenerateRandomOvni(game)) {
                this.setActive(true);
                this.setX(0);
                this.setY(8);
            }
        } else {
            this.setY(this.getY() - 1);
        }
        if (this.getY() < 0 || this.getY() > 8) {
            this.setActive(false);
        }
    }

    @Override
    public void move(char dir) {
        // not used
    }

    @Override
    public String toString() {
        if (this.isActive()) {
            return "O[" + 1 + "]";
        }
        return "";
    }

    @Override
    public void damage(int damage) {
        this.setActive(false);
        this.game.enableShockWave();
        this.game.receivePoints(this.points);
    }

    @Override
    public String stringify() {
        if (isActive()) {
            return "O[" + 1 + "]";
        }
        return "";
    }

    @Override
    public boolean canDelete() {
        return false;
    }

    @Override
    public boolean canCount() {
        return isActive();
    }

    public boolean receiveShockWaveAttack(int damage) {
        this.damage(damage);
        return true;
    }
}