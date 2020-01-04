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

    //METHODS

    public void add(GameObject newObject){ //ADDS OBJECTS TO THE BOARD
        board[objectsOnBoard] = newObject;
        ++objectsOnBoard;
    }

    public void move() {
		boolean bajar = false;
		int i = 0;
		while(i < this.getObjectsOnBoard() && !bajar) {
			if(board[i].isOnBorder()) {
				bajar = true;
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
		if(board[0].getX() % 2 == 0) {
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
            if(board[i].isAlien() && !board[i].canAttack()){
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
        for(int i = x - 1; i < x + 1; ++i){
            for(int j = y - 1;j < y + 1; ++j){
                if(objectAt(i, j) != null) {
					objectAt(i, j).damage(1);
				}
            }
        }
	}

	public void computerAction() {
        for(int i = 0; i < getObjectsOnBoard(); ++i){
            if(!board[i].canAttack()){
               board[i].computerAction(); 
            }
            
        }
	}

	public void update() {
        computerAction();
        for(int i = 0; i < getObjectsOnBoard(); ++i){
            if(board[i].canDelete()){
                delete(i);
            }
        }
    }
    
    public void detectDamage(Weapon other) {
        for(int i = 0; i < getObjectsOnBoard(); ++i){
            if(other.isAlien() != board[i].isAlien() && board[i].isIn(other.getX(), other.getY())){
                other.damage(1);
                board[i].damage(other.getDamage());
            }
        }        
    }

    public void delete(int n) {
		if(this.getObjectsOnBoard() > 1) {
			for(int i = n; i < this.getObjectsOnBoard() - 1; ++i) {
				board[i] = board[i + 1];
			}
		}
		--this.objectsOnBoard; 
	}


}