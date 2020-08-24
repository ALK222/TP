package objects;

import logic.Game;

public abstract class SpaceJunk extends GameObject {

    /*
     * NEUTRAL OBJECTS: can be damaged by everyone
     * 
     */

    protected int hp;

    public SpaceJunk(int x, int y, Game game, int hp) {
        super(game, x, y);
        this.hp = hp;
    }

    public int getHP() {
        return this.hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public boolean receiveMissileAttack(int damage) {
        return true;
    }

    @Override
    public boolean receiveBombAttack(int damage) {
        return true;
    }

    @Override
    public boolean receiveShockWaveAttack(int damage) {
        return false;
    }

    @Override
    public boolean canAttack() {
        return false;
    }

}
