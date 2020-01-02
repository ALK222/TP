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
		detectDamageBomb();
		for(int i = 0; i < getCurrentObjects(); ++i) {
			if(!this.objects[i].isAlive() && this.objects[i].canDelete()) {
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
		for(int i = 0; i < currentObjects; ++i) {
			this.objects[i].computerAction();
		}
	}
	
	public String toString(int x, int y) {
		if(this.getObjectInPosition(x, y) != null && this.getObjectInPosition(x, y).isAlive()) {
			return this.getObjectInPosition(x, y).toString();
		}
		return "";
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
			if(objects[i].haveLanded()) {
				return true;
			}
		}
		return false;
	}
	
	public void move() {
		boolean bajar = false;
		int i = 0;
		while(i < this.getCurrentObjects() && !bajar) {
			if(objects[i].checkBorder()) {
				bajar = true;
			}
			++i;
		}
		if(bajar) {
			for(int j = 0; j < this.getCurrentObjects(); ++j) {
				objects[j].move('b');
			}
		}
		if(objects[0].getX() % 2 == 0) {
			for(int j = 0; j <this.getCurrentObjects(); ++j) {
				objects[j].move('d');
			}
		}
		else {
			for(int j = 0; j <this.getCurrentObjects(); ++j) {
				objects[j].move('i');
			}
		}
	}

	public void shockWaveDamage() {
		for(int i = 0; i < getCurrentObjects(); ++i) {
			objects[i].receiveShockWaveAttack(1);
		}
		
	}
	
	
	public void detectDamageBomb() {
		for(int i = 0; i < getCurrentObjects(); i++) {
			if(objects[i].canAttack()) {
				searchTarget(objects[i]);
			}
		}
	}
	
	public void searchTarget(GameObject other) {
		for(int i = 0; i < getCurrentObjects(); ++i) {
			if(other.isAlien() != objects[i].isAlien()) {
				if(other.getX() == objects[i].getX() && other.getY() == objects[i].getY()) {
					other.performAttack(objects[i]);
				}
			}
		}
	}
	
	
}
