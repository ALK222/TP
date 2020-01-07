package commands;

import exceptions.CommandParseException;
import logic.Game;

public class HelpCommand extends Command{
	
	
	//CONSTRUCTOR
		public HelpCommand (String name, String shortcut, String details, String help) {
			super(name, shortcut, details, help);
		}

		
		public boolean execute(Game game) {
			System.out.print(CommandGenerator.commandHelp());
			return false;
		}
		
		
		public Command parse(String[] commandWord) throws CommandParseException {
			if(!matchCommandName(commandWord[0])){
				return null;
			}
			else if(commandWord.length != 1){
				throw new CommandParseException(Command.incorrectNumArgsMsg);
			}
			return new HelpCommand(name, shortcut, details, help);
		}
}
