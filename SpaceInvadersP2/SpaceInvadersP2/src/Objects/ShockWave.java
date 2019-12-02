package Objects;

import logic.Game;

public class ShockWave extends Weapon{

	public ShockWave(int startX, int startY, Game game, boolean alien, boolean alive) {
		super(startX, startY, game, alien, alive);
	}
	
	@Override
	public void damage(GameObject target) {
		
	}

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void move(char dir) {
		// TODO Auto-generated method stub
		
	}

}
