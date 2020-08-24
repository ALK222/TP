package objects;

import logic.Game;

public class Satellite extends SpaceJunk {

    public Satellite(int x, int y, Game game, int hp) {
        super(x, y, game, hp);
    }

    @Override
    public void computerAction() {
        if (game.objectNearSat(this.x, this.y)) {
            this.hp--;
        }
    }

    @Override
    public void move(char dir) {
        // Ultra lazy boi
    }

    @Override
    public String toString() {
        return "#>|<#";
    }

    @Override
    public void damage(int damage) {
        this.setHp(this.getHP() - damage);
    }

    @Override
    public String stringify() {
        return "#>|<#: " + this.getX() + ";" + this.getY() + ";" + this.getHP() + ";";
    }

    @Override
    public boolean canDelete() {
        return getHP() <= 0;
    }

}
