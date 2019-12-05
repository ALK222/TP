package Objects;

import logic.Game;

public class ShockWave extends Weapon{

	public ShockWave(int startX, int startY, Game game, boolean alien, boolean alive, boolean active) {
		super(startX, startY, game, alien, alive, active, 1);
	}
	
	public void damage(int damage) {
		
	}

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		
	}

	public String toString() {
		return "";
	}

	@Override
	public void move(char dir) {
		// TODO Auto-generated method stub
		
	}

	public String stringify() {
		// TODO Auto-generated method stub
		return "";
	}


}
