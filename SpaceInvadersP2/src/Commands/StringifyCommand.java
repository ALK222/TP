package Commands;

import exceptions.CommandExecuteException;
import exceptions.CommandParseException;
import logic.Game;

public class StringifyCommand extends Commands{
	public StringifyCommand(String name, String shortcut, String details2, String help) {
		super(name, shortcut, details2, help);
	}

	
	public boolean execute(Game game) throws CommandExecuteException {
		if(game.getPrinterOption() == 'b') {
			game.setPrinterOption('s');
		}
		else {
			game.setPrinterOption('b');
		}
		return false;
	}

	
	public Commands parse(String[] commandWord) throws CommandParseException {
		if(commandWord.length != 1) {
			System.out.print(Commands.incorrectNumArgsMsg);
			return null;
		}
		else if (commandWord[0].equalsIgnoreCase("Stringify") || commandWord[0].equalsIgnoreCase("c")) {
			return new StringifyCommand("Stringify", "C", "", "Stringify: changes the game perspective");
		}
		return null;
	}


}
