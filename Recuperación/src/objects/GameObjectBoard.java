package objects;

public final class GameObjectBoard{
    /*
    
            The space, where al ships and weapons are
    
    */

    //ATRIBUTTES

    private GameObject[] board;
    private int objectsOnBoard;

    //CONSTRUCTOR

    public GameObjectBoard(int width, int heigth){
        this.board = new GameObject[width*heigth];
        this.objectsOnBoard = 0;
    }

    //GETTERS AND SETTERS

    public int getObjectsOnBoard(){
        return this.objectsOnBoard;
    }

    public int getIndex(GameObject ob){
        boolean found = false;
        int index = 0;
        while (!found && index < board.length){
            if(this.board[index].equals(ob)){
                return index;
            }
            else{
                ++index;
            }
        }
        return -1;
    }

    //METHODS

    public void add(GameObject newObject){ //ADDS OBJECTS TO THE BOARD
        board[objectsOnBoard] = newObject;
        ++objectsOnBoard;
    }

    public int move(int fila) {
		boolean bajar = false;
		int i = 0;
		while(i < this.getObjectsOnBoard() && !bajar) {
			if(board[i].isOnBorder()) {
                bajar = true;
                fila += 1;
			}
			++i;
		}
		if(bajar) {
			for(int j = 0; j < this.getObjectsOnBoard(); ++j) {
				if(!board[j].canAttack()){
                    board[j].move('b');
                }
			}
		}
		if(fila % 2 == 0) {
			for(int j = 0; j <this.getObjectsOnBoard(); ++j) {
				if(!board[j].canAttack()){
                    board[j].move('d');
                }
			}
		}
		else {
			for(int j = 0; j <this.getObjectsOnBoard(); ++j) {
				if(!board[j].canAttack()){
                    board[j].move('i');
                }
			}
        }
        return fila;
	}

    public GameObject objectAtPosition(int x, int y){
        boolean found = false;
        int i = 0;
        while(i < objectsOnBoard && !found){
            if(board[i].isIn(x, y)){
                found = true;
                --i;
            }
            ++i;
        }

        if(found){
            return board[i];
        }

        return null;
    }

	public boolean haveLanded() {
        for(int i = 0; i < objectsOnBoard; ++i){
            if(board[i].haveLanded() && board[i].isAlien()){
                return true;
            }
        }
		return false;
	}

	public int aliensRemaining() {
        int totalAliens = 0;
        for (int i = 0; i < objectsOnBoard; ++i){
            if(board[i].canCount()){
                ++totalAliens;
            }
        }
		return totalAliens;
	}

	public void shockDamage() {
        for(int i = 0; i < objectsOnBoard; ++i){
            board[i].receiveShockWaveAttack(1);
        }
	}

    public GameObject objectAt(int x, int y){
        for(int i = 0; i < objectsOnBoard; ++i){
            if(board[i].isIn(x, y)){
                return board[i];
            }
        }
        return null;
    }

	public void explosiveDamage(int x, int y) {
        x -= 1;
        y -= 1;
        int radius = 3;
        for(int i = 0; i < radius; ++i){
            for(int j = 0; j < radius; ++j){
                if(objectAt(x + i, y + j) != null) {
					objectAt(x + i, y + j).damage(1);
				}
            }
        }
	}

	public void computerAction() {
        for(int i = 0; i < getObjectsOnBoard(); ++i){
               board[i].computerAction();             
        }
	}

	public void update() {
        for(int i = getObjectsOnBoard() - 1; i >= 0; --i) {
			if(this.board[i].canDelete()) {
				delete(i);
			}
		} 
    }
    
    public void detectDamage(Weapon other) {
        int damage = other.getDamage();
        if(other != null){
            for(int i = 0; i < getObjectsOnBoard(); ++i){
                if(other != null){
                    if(other.isAlien() != board[i].isAlien() && board[i].isIn(other.getX(), other.getY())){
                        board[i].damage(damage);
                        other.damage(1);
                    }
                }
                
            }   
        }
    }

    public void delete(int n) {
		for(int i = n; i < this.getObjectsOnBoard(); ++i) {
			board[i] = board[i + 1];
		}
		--this.objectsOnBoard; 
	}


}