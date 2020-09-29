package utils;

import java.util.Random;

import interfaces.IExecuteRandomActions;
import logic.Game;
import objects.DestroyerShip;
import objects.GameObjectBoard;
import objects.Ovni;
import objects.RegularShip;
import objects.Satellite;
import objects.SupportShip;
import objects.ZombieShip;

public final class BoardInitializer implements IExecuteRandomActions {

    // ATRIBUTTES
    private Level level;

    private Game game;

    private GameObjectBoard board;

    public GameObjectBoard initialize(Game game, Level level) {
        this.level = level;
        this.game = game;
        this.board = new GameObjectBoard(Game.DIM_X, Game.DIM_Y);

        initRegularShips();
        initDestroyerShips();
        addOvni();
        generateSat();
        return board;
    }

    public void generateSat() {
        int total = game.getLevel().getNumberSatellyte();
        Random rand = new Random();
        for (int i = 0; i < total; i++) {
            int x = rand.nextInt(Game.DIM_X);
            int y = rand.nextInt(Game.DIM_Y);
            if (board.isEmpty(x, y)) {
                if (x == Game.DIM_X - 1) {
                    x = 6;
                }
                board.add(new Satellite(x, y, game, 1));
            }
        }
    }

    public void addOvni() {
        board.add(new Ovni(0, 0, game, 20, false));
    }

    public void initRegularShips() {
        int x = 1;
        int y = 6;
        for (int i = 0; i < level.getNumRowsOfRegularAliens(); ++i) {
            for (int j = 0; j < level.getNumRegularAliensPerRow(); ++j) {
                if (generateZombie(game)) {
                    board.add(new ZombieShip(x + i, y - j, game, 2));
                }
                board.add(new RegularShip(x + i, y - j, game, 2, false));
            }
        }
    }

    public void initDestroyerShips() {
        int x = 1 + level.getNumRowsOfRegularAliens();
        int y = 5;
        if (level.getNumDestroyerAliens() > 2) {
            ++y;
        }
        for (int i = 0; i < level.getNumDestroyerAliens(); ++i) {
            if (generateSup(game)) {
                board.add(new DestroyerShip(x, y - i, game, 1, null));
            } else {
                board.add(new SupportShip(x, y - i, game, 3));
            }
        }

    }
}
