package Commands;

import logic.Game;

public class HelpCommand extends Commands{
	
	
	//CONSTRUCTOR
		public HelpCommand (String name, String shortcut, String details, String help) {
			super(name, shortcut, details, help);
		}

		@Override
		public boolean execute(Game game) {
			System.out.print(CommandGenerator.commandHelp());
			return false;
		}
		
		@Override
		public Commands parse(String[] commandWord) {
			if(commandWord.length != 1) return null;
			else if (commandWord[0].equalsIgnoreCase("help") || commandWord[0].equalsIgnoreCase("h")) {
				return new HelpCommand("Help", "H", "", "Help message");
			}
			else {
				return null;
			}
		}
}
