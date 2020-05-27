package objects;

import logic.Game;

public abstract class EnemyShip extends Ship{

    public EnemyShip(int x, int y, Game game, int points) {
        super(x, y, game, points);
    }

    public final boolean receiveMissileAttack(int damage) {
        return true;
    }


}
