package Objects;

import logic.Game;

public abstract class EnemyShip extends Ship{

	public EnemyShip(int startX, int startY, int hp, int points, Game game, boolean alien, boolean alive) {
		super(startX, startY, hp, points, game, alien, alive);
	}
	
	public void move(char dir) {
		switch (dir) {
		case 'b':this.setX(this.getX() + 1);
			break;
		case 'i':this.setY(this.getY() - 1);
			break;
		case 'd':this.setY(this.getY() + 1);
			break;
		}
	}
	
	
	public boolean receiveMissileAttack(int damage) {
		this.damage(damage);
		return true;
	}
}
