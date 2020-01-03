package utils;

import logic.Game;
import objects.*;

public final class BoardInitializer{
    
    //ATRIBUTTES
    private Level level;

    private Game game;

    private GameObjectBoard board;


    public GameObjectBoard initialize(Game game, Level level){
        this.level = level;
        this.game = game;
        this.board = new GameObjectBoard(Game.DIM_X, Game.DIM_Y);

        initRegularShips();
        initDestroyerShips();
        addOvni();
        return board;
    }


    public void addOvni(){
        board.add(new Ovni(0, 0, game, 20, false));
    }

    public void initRegularShips(){
        int x = 1;
        int y = 6;
        for(int i = 0; i < level.getNumRowsOfRegularAliens(); ++i){
            for(int j = 0; j < level.getNumRegularAliensPerRow(); ++j){
                board.add(new RegularShip(x + i, y - j, game, 2, false));
            }
        }
    }

    public void initDestroyerShips(){
        int x = 1 + level.getNumRowsOfRegularAliens();
        int y = 5;
        if(level.getNumDestroyerAliens() > 2){
            ++y;
        }
        for(int i = 0; i < level.getNumDestroyerAliens(); ++i){
            Bomb bomb = new Bomb(10, 10,false, 1, game);
            board.add(new DestroyerShip(x, y- i, game, 1, bomb));
            board.add(bomb);
        }

    }
}