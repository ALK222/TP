package Commands;

public class CommandGenerator {
	
	private static Commands[] availableCommands = {
			new ListCommand("List", "L", "",""),
			new HelpCommand("Help", "H", "",""),
			new ResetCommand("Reset", "R","",""),
			new ExitCommand("Exit","E","",""),
			new UpdateCommand("Update","U","",""),
			new MoveCommand("Move", "M","",""),
			new ShockwaveCommand("ShockWave","W","","")
	};
	
	
	public static String commandHelp() {
		String show = "Los comandos disponibles son:" + System.getProperty("line.separator");
		
		for (int i = 0; i<availableCommands.length; i++) {
			show += availableCommands[i].helpText();
			show += System.getProperty("line.separator");
		}
		return show;
	}
	
	public static Commands parseCommand(String[] commandWords) {
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
