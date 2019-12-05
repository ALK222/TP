package Commands;

import exceptions.CommandParseException;

public class CommandGenerator {
	
	private static Commands[] availableCommands = {
			//List of all commands
			new ListCommand("List", "L", "","List: shows information of the game"),
			new HelpCommand("Help", "H", "","Help: shows help"),
			new ResetCommand("Reset", "R","","Reset: resets the game"),
			new ExitCommand("Exit","E","","Exit: exits the game"),
			new UpdateCommand("Update","U","","Update: updates the game"),
			new MoveCommand("Move", "m", "", "Move: moves the ship", "", "0"),
			new ShockwaveCommand("ShockWave","W","","Shockwave: deals 1 damage to all ships"),
			new SaveCommand ("Save", "S", "", "", "Save: saves the current state of the ga,e"),
			new ShootCommand ("Shoot", "F", "", "", "shoot: shots a laser, if you put supermisil in the command shoots a supermisille"),
			new BuyCommand("Buy", "B", "", "Buy: buys a supermisille for 20 points"),
			new StringifyCommand("Stringify", "C", "", "Stringify: changes the game perspective")
	};
	
	
	public static String commandHelp() {
		//shows al commands
		String show = "Los comandos disponibles son:" + System.getProperty("line.separator");
		
		for (int i = 0; i<availableCommands.length; i++) {
			show += availableCommands[i].helpText();
			show += System.getProperty("line.separator");
		}
		return show;
	}
	

	public static Commands parseCommand(String[] commandWords) throws CommandParseException{
		//parse commands
		int i = 0;
		boolean ok = false;
		while (!ok && i<availableCommands.length) {
			if (availableCommands[i].parse(commandWords) == null) {
				i++;
			}
			else {
				return availableCommands[i].parse(commandWords);
			}
		}
		return null;
	}


	
}
