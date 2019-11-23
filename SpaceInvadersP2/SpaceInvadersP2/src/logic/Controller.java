package logic;


import interfaces.IExecuteRandomActions;
import java.util.Scanner;

public class Controller implements IExecuteRandomActions{
	
	private Game game;
	private Scanner in;
	
	public void run() {
		while(!game.isFinished()){
			System.out.println(PROMPT);
			String[]  words = in.nextLine().toLowerCase().trim().split ("\\s+");
			Command command = CommandGenerator.parse(words);
			if(command != null) {+
				if(command.execute(game))
					System.out.println(game);
			}
			else{
				System.out.format(unknownCommandMsg);
			}
		}
	}
	
}
