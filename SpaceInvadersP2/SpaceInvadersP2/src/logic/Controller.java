package logic;


import interfaces.GamePrinter;
import interfaces.IExecuteRandomActions;
import utils.BoardPrinter;

import java.util.Scanner;

import Commands.CommandGenerator;
import Commands.Commands;
import exceptions.CommandExecuteException;

public class Controller implements IExecuteRandomActions{
	
	//ATTRIBUTES
	
	private Game game;
	private Scanner in;
	private GamePrinter b;
	private String prompt = "Command >";
	private String unknownCommandMsg = "Unknown command, please put a valid command";
	
	//CONSTRUCTOR
	
	public Controller(Game g) {
		this.game = g;
		this.in = new Scanner(System.in);
		this.b = new BoardPrinter(game, 8, 9);
	}
	
	
	public void run() {
		System.out.println(b.toString(game));
		while(!game.isFinished()){
			System.out.print(prompt);
			String[]  words = in.nextLine().trim().split ("\\s+");
			try{
				Commands command = CommandGenerator.parseCommand(words);
				if(command != null) {
					if(command.execute(game)) System.out.println(b.toString(game));
				}
				else
					System.out.println(unknownCommandMsg);
			}
			catch(CommandParseException | CommandExecuteException ex) {
				System.out.format((ex).getMessage() +"%n%n");
			}
		}
	}
	
}
