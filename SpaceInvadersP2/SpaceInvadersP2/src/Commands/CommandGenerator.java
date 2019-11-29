package Commands;

public class CommandGenerator {
	private static ListCommand List;
	private static HelpCommand help;
	private static ResetCommand Reset;
	private static ExitCommand exit;
	private static UpdateCommand update;
	private static MoveCommand move;
	private static ShockwaveCommand shock;
	
	
	private static Commands[] availableCommands = {
			List = list(),
			help = help(),
			Reset = reset(),
			exit = exit(),
			update = update(),
			move = move(String parameters),
			shock = shock();
	};
	
	public static ListCommand list() {
		String name = "List";
		String shortcut = "L";
		String details = "";
		String help = "Shows the list of Commands";
		return new ListCommand(name, shortcut, details, help);
	}
	
	public static HelpCommand help() {
		String name = "Help";
		String shortcut = "H";
		String details = "";
		String help = "Prints this help message";
		return new HelpCommand(name, shortcut, details, help);
	}
	
	public static ResetCommand reset() {
		String name = "Reset";
		String shortcut = "R";
		String details = "";
		String help = "Starts a new game";
		return new ResetCommand(name, shortcut, details, help);
	}
	
	public static UpdateCommand update() {
		String name = "Reset";
		String shortcut = "R";
		String details = "";
		String help = "Updates the game";
		return new UpdateCommand(name, shortcut, details, help);
	}
	
	public static ExitCommand exit() {
		String name = "exit";
		String shortcut = "e";
		String details = "";
		String help = "Exit the game";
		return new ExitCommand(name, shortcut, details, help);
	}
	
	public static MoveCommand move(String[] parameters) {
		String name = "move";
		String shortcut = "m";
		String[] details = parameters;
		String help = "Move the ship: ";
		return new MoveCommand(name,shortcut,details, help);
	}
	
	public static ShockwaveCommand shock() {
		String name = "Shockwave";
		String shortcut = "w";
		String details = "";
		String help = "Deals 1 damage to every enemy on screen";
		return new ShockwaveCommand(name, shortcut, details, help);
	}
	
	public static Commands parse(String[] command) {
		
		return null;
		
	}
	
}
