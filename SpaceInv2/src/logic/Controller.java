package logic;


import interfaces.IExecuteRandomActions;
import utils.BoardPrinter;

import java.util.Scanner;

import Commands.CommandGenerator;
import Commands.Commands;

public class Controller implements IExecuteRandomActions{
	
	//ATTRIBUTES
	
	private Game game;
	private Scanner in;
	private BoardPrinter b;
	
	//CONSTRUCTOR
	
	public Controller(Game g) {
		this.game = g;
		this.in = new Scanner(System.in);
		this.b = new BoardPrinter(game, 8, 9);
	}
	
	
	public void run() {
		while(!game.isFinished()){
			this.b = new BoardPrinter(game, 8, 9);
			System.out.print(b);
			String[]  words = in.nextLine().toLowerCase().trim().split ("\\s+");
			Commands command = CommandGenerator.parseCommand(words);
			if(command != null) {
				if(command.execute(game))
					System.out.println(game);
			}
			else{
				//System.out.format(unknownCommandMsg);
			}
		}
	}
	
}
