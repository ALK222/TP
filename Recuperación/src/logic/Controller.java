package logic;

import java.util.Scanner;

import utils.BoardPrinter;
import interfaces.GamePrinter;;


public class Controller{

	/*
	
			Logic behind the game
	
	*/
	
	//ATTRIBUTES
	
	private Game game;
	private Scanner in;
	private GamePrinter printer;
	private String prompt = "Command >";
	
	//CONSTRUCTOR
	
	public Controller(Game g) {
		this.game = g;
		this.in = new Scanner(System.in);
		this.printer = new BoardPrinter(game, 8, 9);
	}
	
	
	public void run() {
		while(!game.isFinished()){
			// System.out.print(prompt);
			// String[]  words = in.nextLine().trim().split ("\\s+");
			// try{
			// 	Commands command = CommandGenerator.parseCommand(words);
			// 	if(command != null) {
			// 		if(command.execute(game)) {
						game.update();
						printGame();
					}
				// }
			// }
		// 	catch(CommandParseException | CommandExecuteException ex) {
		// 		System.out.format((ex).getMessage() +"%n%n");
		// 	}
		// }
	}
	
	
	public void printGame() {
		/*if(game.getPrinterOption() == 'b') {
			this.printer = new BoardPrinter(this.game, 8, 9);
			System.out.println(printer.toString(game));
		}
		else {
			this.printer = new Stringifier(game);
			System.out.println(printer.toString(game));
		}*/
		this.printer = new BoardPrinter(this.game, 8, 9);
		System.out.println(printer.toString(game));
	}
	

}

