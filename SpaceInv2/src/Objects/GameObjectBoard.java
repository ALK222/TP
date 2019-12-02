package Objects;


public class GameObjectBoard {
	private GameObject[] objects;
	private int currentObjects;
	
	public GameObjectBoard (int width, int height) {
		objects = new GameObject[width * height];
		this.currentObjects = 0;
	}
	
	public void add (GameObject object) {
		objects[this.getCurrentObjects()] = object;
		this.currentObjects++;
	}
	
	public final GameObject getObjectInPosition (int x, int y) {
		for (int i = 0; i < this.currentObjects; i++) {
			if(this.objects[i].isIn(x, y)) {
				return objects[i];
			}
		}
		return null;
	}
	

	
	public int getCurrentObjects() {
		return this.currentObjects;
	}
	
	public void update() {
		// TODO implement
	}
	
	public void computerAction() {
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
