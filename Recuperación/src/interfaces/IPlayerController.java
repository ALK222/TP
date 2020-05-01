package interfaces;

import exceptions.CommandExecuteException;
import objects.Laser;

public interface IPlayerController {
	
	// PLAYER ACTIONS	
	public boolean move(String direction, int numCells );
	public boolean shootLaser(String option) throws CommandExecuteException;
	public boolean shockWave();
	
	// CALLBACKS
	public void receivePoints(int points);
	public void enableShockWave();
	public void enableMissile(Laser laser);
	
}