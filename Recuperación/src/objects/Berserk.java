package objects;

import java.util.Random;

import logic.Game;

public class Berserk extends AlienShip {

    public Berserk(int x, int y, Game game, int hp) {
        super(x, y, game, hp, 5);
    }

    @Override
    public void computerAction() {
        Random a = new Random();
        int chance = a.nextInt(10);
        if (canDelete()) {
            game.explosiveDamage(this.getX(), this.getY());
        }
        if (chance < 3) {
            this.setHp(this.getHp() + 1);
        }
    }

    @Override
    public void move(char dir) {
        //
    }

    @Override
    public String toString() {
        return "BE[" + getHp() + "]";
    }

    @Override
    public void damage(int damage) {
        this.setHp(this.getHp() - damage);
    }

    @Override
    public String stringify() {
        return "BE " + this.getX() + ";" + this.getY() + ";" + this.getHp() + ";"
                + game.getCurrentCycle() % game.getLevel().getNumCyclesToMoveOneCell();
    }

    @Override
    public boolean canDelete() {
        return getHp() <= 0;
    }

}
