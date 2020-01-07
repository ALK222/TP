package main;

import logic.*;
import utils.Level;

public class Main {
    char[] dir = new char[2];
    
    
    public static void main(final String[] args) {
    if (args.length != 2) {
        System.out.print("Error, wrong number of arguments");
    }
    else {
        final Game game = new Game(Level.parse(args[0]), args[1]);
        final Controller c = new Controller(game);
        c.printGame();
		c.run();
		System.out.println(game.getWinnerMessage());
		}
	}
}