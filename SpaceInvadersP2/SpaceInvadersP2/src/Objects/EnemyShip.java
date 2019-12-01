package Objects;

import logic.Game;

public abstract class EnemyShip extends Ship{

	public EnemyShip(int startX, int startY, int hp, int points, Game game, boolean alien, boolean alive) {
		super(startX, startY, hp, points, game, alien, alive);
	}

}
