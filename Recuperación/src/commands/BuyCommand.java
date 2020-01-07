package commands;


import exceptions.CommandExecuteException;
import exceptions.CommandParseException;
import logic.Game;

public class BuyCommand extends Command {

	public BuyCommand(String name, String shortcut, String details, String help) {
		super(name, shortcut, details, help);
	}

	
	public boolean execute(Game game) throws CommandExecuteException {
		if(!game.buy()){
			throw new CommandExecuteException("Not enought points to buy a super missile");
		}
		return false;
	}

	
	public Command parse(String[] commandWord) throws CommandParseException {
		if(!matchCommandName(commandWord[0])){
			return null;
		}
		else if(commandWord.length != 1){
			throw new CommandParseException(Command.incorrectNumArgsMsg);
		}
		return new BuyCommand(name, shortcut, details, help);
	}

}
