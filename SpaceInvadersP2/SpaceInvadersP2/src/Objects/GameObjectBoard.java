package Objects;


public class GameObjectBoard {
	private GameObject[] objects;
	private int currentObjects;
	
	public GameObjectBoard (int width, int height) {
		// TODO implement
	}
	
	private final int getCurrentObjects() {
		return currentObjects;
	}
	
	public void add (GameObject object) {
		// TODO implement
	}
	
	private final GameObject getObjectInPosition (int x, int y) {
		for (int i = 0; i < this.currentObjects; i++) {
			if(this.objects[i].isIn(x, y)) {
				return objects[i];
			}
		}
		return null;
	}
	
	private final int getIndex(int x, int y ) {
		for(int i = 0; i < currentObjects; i++) {
			if(objects[i].isIn(x, y)) {
				return i;
			}
		}
		return -1;
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

	public final int aliensRemaining() {
		int aliensRemaining = 0;
		for(int i = 0; i < this.currentObjects; i++) {
			if(objects[i].isAlien()) {
				aliensRemaining++;
			}
		}
		return aliensRemaining;
	}

}
