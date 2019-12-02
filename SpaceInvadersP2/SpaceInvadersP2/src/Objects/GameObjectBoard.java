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
		for(int i = 0; i < getCurrentObjects(); ++i) {
			if(!this.objects[i].isAlive() && this.objects[i].isAlien()) {
				delete(i);
			}
		}
	}
	
	public void delete(int n) {
		if(this.getCurrentObjects() > 1) {
			for(int i = n; i < this.getCurrentObjects() - 1; ++i) {
				objects[i] = objects[i + 1];
			}
		}
		this.setCurrentObjects(getCurrentObjects() - 1); 
	}
	
	public void setCurrentObjects(int currentObjects) {
		this.currentObjects = currentObjects;
	}

	public void computerAction() {
		/*for(int i = 0; i < currentObjects; ++i) {
			this.objects[i].computerAction();
		}*/
		move();
	}
	
	public String toString(int x, int y) {
		return this.getObjectInPosition(x, y).toString();
	}

	public final int aliensRemaining() {
		int aliensRemaining = 0;
		for(int i = 0; i < this.currentObjects; i++) {
			if(objects[i].isAlien()) {
				if(objects[i].isAlive()) {
					++aliensRemaining;
				}
			}
		}
		return aliensRemaining;
	}
	
	public final boolean haveLanded() {
		for(int i = 0; i < currentObjects; i++) {
			if(objects[i].isAlien() && objects[i].getX() >= 7) {
				return true;
			}
		}
		return false;
	}
	
	public void move() {
		for(int x = 0; x < 9; ++x) {
			if(getObjectInPosition(x, 0) != null) {
				if(getObjectInPosition(x, 0).getClass() == RegularShip.class || getObjectInPosition(x, 0).getClass() == DestroyerShip.class) {
					for (int i = 0; i < currentObjects; ++i) {
						if(objects[0].getClass() == RegularShip.class || objects[0].getClass() == DestroyerShip.class) {
							objects[i].move('b');
						}
					}
					break;
				}
			}
			if(getObjectInPosition(x, 8) != null) {
				if(getObjectInPosition(x, 8).getClass() == RegularShip.class || getObjectInPosition(x, 8).getClass() == DestroyerShip.class) {
					for (int i = 0; i < currentObjects; ++i) {
						if(objects[0].getClass() == RegularShip.class || objects[0].getClass() == DestroyerShip.class) {
							objects[i].move('b');
						}
					}
					break;
				}
			}
		}
		if(objects[0].getX() % 2 == 0) {
			for (int i = 0; i < currentObjects; ++i) {
				if(objects[0].getClass() == RegularShip.class || objects[0].getClass() == DestroyerShip.class) {
					objects[i].move('d');
				}
			}
		}
		else {
			for (int i = 0; i < currentObjects; ++i) {
				if(objects[0].getClass() == RegularShip.class || objects[0].getClass() == DestroyerShip.class) {
					objects[i].move('i');
				}
			}
		}
	}

}
