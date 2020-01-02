package main;

import logic.Controller;
import logic.Game;
import utils.Level;

public class Main {
	
	public static void main(String[] args) {
		if(args.length != 2) {
			System.out.print("error");
		}
		else {
			
			Game game = new Game(Level.parse(args[0]), args[1]);
			Controller c = new Controller(game);
			c.printGame();
			c.run();
			System.out.println(game.getWinnerMessage());
		}
		
		
	}
}
