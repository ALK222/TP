package objects;

import interfaces.IExecuteRandomActions;
import logic.Game;

public abstract class AlienShip extends EnemyShip implements IExecuteRandomActions {

    // ATRIBUTTES

    private int hp;

    // CONSTRUCTOR

    public AlienShip(int x, int y, Game game, int hp, int points) {
        super(x, y, game, points);
        this.hp = hp;
    }

    // SETTERS AND GETTERS

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return this.hp;
    }

    // METHODS
    @Override
    public boolean haveLanded() {
        return this.getX() >= 7;
    }

    @Override
    public boolean isOnBorder() {
        return this.getY() <= 0 || this.getY() >= 8;
    }

    @Override
    public void move(char dir) {
        switch (dir) {
            case 'b':
                this.setX(this.getX() + 1);
                break;
            case 'i':
                this.setY(this.getY() - 1);
                break;
            case 'd':
                this.setY(this.getY() + 1);
                break;
        }
    }

}