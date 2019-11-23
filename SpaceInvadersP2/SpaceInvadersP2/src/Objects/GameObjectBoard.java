package Objects;


public class GameObjectBoard {
	private GameObject[] objects;
	private int currentObjects;
	
	public GameObjectBoard (int width, int height) {
		// TODO implement
	}
	
	private int getCurrentObjects () {
		return currentObjects;
	}
	
	public void add (GameObject object) {
		// TODO implement
	}
	
	private GameObject getObjectInPosition (int x, int y) {
		for (int i = 0; i < this.currentObjects; i++) {
			if(this.GameObjects[i].)
		}
	}
	
	private int getIndex( /* coordinadas */ ) {
		// TODO implement
	}

	private void remove (GameObject object) {
		// TODO implement
	}
	
	public void update() {
		// TODO implement
	}
	
	private void checkAttacks(GameObject object) {
		// TODO implement
	}
	
	public void computerAction() {
		// TODO implement
	}
	
	private void removeDead() {
		// TODO implement
	}

	public String toString(int x, int y) {
		return this.getObjectInPosition(x, y).toString();
	}

}
