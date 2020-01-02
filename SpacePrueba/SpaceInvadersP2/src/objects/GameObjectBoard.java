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

    public GameObject objectAtPosition(int x, int y){
        boolean found = false;
        int i = 0;
        while(i < objectsOnBoard && !found){
            if(board[i].isIn(x, y)){
                found = true;
            }
        }

        if(found){
            return board[i];
        }

        return null;
    }


}