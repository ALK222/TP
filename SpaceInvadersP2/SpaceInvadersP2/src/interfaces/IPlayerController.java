package interfaces;

public interface IPlayerController {
	
	// PLAYER ACTIONS	
	public boolean move(String direction, int numCells );
	public boolean shootLaser();
	public boolean shockWave();
	
	// CALLBACKS
	public void receivePoints(int points);
	public void enableShockWave();
	public void enableMissile();
	
}
