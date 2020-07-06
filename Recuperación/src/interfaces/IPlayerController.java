package interfaces;

import exceptions.CommandExecuteException;
import exceptions.CommandMovementException;
import objects.Laser;

public interface IPlayerController {

	// PLAYER ACTIONS
	public void move(String direction, int numCells) throws CommandMovementException;

	public void shootLaser(String option) throws CommandExecuteException;

	public void shockWave() throws CommandExecuteException;

	// CALLBACKS
	public void receivePoints(int points);

	public void enableShockWave();

	public void enableMissile(Laser laser);

}