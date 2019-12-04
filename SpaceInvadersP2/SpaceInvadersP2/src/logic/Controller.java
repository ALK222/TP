package logic;


import interfaces.GamePrinter;
import interfaces.IExecuteRandomActions;
import utils.BoardPrinter;
import utils.Stringifier;

import java.util.Scanner;

import Commands.CommandGenerator;
import Commands.Commands;
import exceptions.CommandExecuteException;
import exceptions.CommandParseException;

public class Controller implements IExecuteRandomActions{
	
	//ATTRIBUTES
	
	private Game game;
	private Scanner in;
	private GamePrinter b;
	private GamePrinter s;
	private char printerOption;
	private String prompt = "Command >";
	private String unknownCommandMsg = "Unknown command, please put a valid command";
	
	//CONSTRUCTOR
	
	public Controller(Game g) {
		this.game = g;
		this.in = new Scanner(System.in);
		this.b = new BoardPrinter(game, 8, 9);
		this.s = new Stringifier(game);
		printerOption = 's';
	}
	
	
	public void run() {
		while(!game.isFinished()){
			System.out.print(prompt);
			String[]  words = in.nextLine().trim().split ("\\s+");
			try{
				Commands command = CommandGenerator.parseCommand(words);
				if(command != null) {
					if(command.execute(game)) printGame();
				}
				else
					System.out.println(unknownCommandMsg);
			}
			catch(CommandParseException | CommandExecuteException ex) {
				System.out.format((ex).getMessage() +"%n%n");
			}
		}
	}
	
	
	public void printGame() {
		if(this.printerOption == 'b') {
			b.setGame(game);
			System.out.println(b.toString(game));
		}
		else {
			s.setGame(game);
			System.out.println(s.toString(game));
		}
	}
	
}
