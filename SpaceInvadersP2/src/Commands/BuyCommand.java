package Commands;

import exceptions.CommandExecuteException;
import exceptions.CommandParseException;
import logic.Game;

public class BuyCommand extends Commands {

	public BuyCommand(String name, String shortcut, String details2, String help) {
		super(name, shortcut, details2, help);
	}

	
	public boolean execute(Game game) throws CommandExecuteException {
		if(game.buy()) {
			return true;
		}
		System.out.println("No se pudo comprar el supermisil.\n");
		return false;
	}

	
	public Commands parse(String[] commandWord) throws CommandParseException {
		if(commandWord.length != 1) {
			System.out.print(Commands.incorrectNumArgsMsg);
			return null;
		}
		else if (commandWord[0].equalsIgnoreCase("Buy") || commandWord[0].equalsIgnoreCase("b")) {
			return new BuyCommand("Buy", "B", "", "Buy: buys a supermisille.");
		}
		return null;
	}

}
