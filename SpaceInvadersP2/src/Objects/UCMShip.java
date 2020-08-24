package objects;

import logic.Game;

public final class UCMShip extends Ship {

    // ATRIBUTTES

    private int hp;

    private Laser laser;

    private Laser superL;

    private boolean shockWave;

    public UCMShip(int x, int y, Game game, Laser laser, Laser superL) {
        super(x, y, game, 0);
        this.hp = 3;
        this.laser = laser;
        this.superL = superL;
        this.shockWave = false;
    }

    // SETTERS AND GETTERS

    public int getHp() {
        return this.hp;
    }

    public Laser getLaser() {
        return this.laser;
    }

    public Laser getSuperL() {
        return this.superL;
    }

    public void setSockWave(boolean shockWave) {
        this.shockWave = shockWave;
    }

    public boolean getSockWave() {
        return this.shockWave;
    }

    // METHODS

    public void computerAction() {
        if (getLaser() != null && getLaser().getX() <= 0) {
            game.enableMissile(this.getLaser());
            this.laser = null;
        }
        if (getSuperL() != null && getSuperL().getX() <= 0) {
            game.enableSuperMissile(this.getSuperL());
            this.laser = null;
        }
    }

    @Override
    public void move(char dir) {
        // Not used
    }

    public String toString() {
        if (this.hp > 0) {
            return "<" + this.getHp() + ">";
        }
        return "!xx!";
    }

    public void damage(int damage) {
        this.hp -= damage;
    }

    public String stringify() {
        return "P " + this.getX() + ";" + this.getY() + ";" + this.hp + ";" + points + ";" + this.getSockWave() + ";"
                + game.getAmmo();
    }

    public boolean canDelete() {
        return false;
    }

    public boolean canCount() {
        return false;
    }

    public void setSuperLaser(Laser sl) {
        this.superL = sl;
    }

    public void setLaser(Laser laser2) {
        this.laser = laser2;
    }

}