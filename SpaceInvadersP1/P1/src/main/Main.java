package main;

import logic.*;
import controller.*;
import utils.*;

public class Main {

	public static void main(String[] args) {
		if(args.length != 2) {
			System.out.print("error");
		}
		else {
			
			Game game = new Game(args[0], args[1]);
			Controller c = new Controller(game);
			c.run();
		}
		
		
	}

}
