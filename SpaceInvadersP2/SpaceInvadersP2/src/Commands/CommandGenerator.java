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
			move = move(),
			shock = shock()
	};
	
	public static ListCommand list() {
		String name = "List";
		String shortcut = "L";
		String details = "Prints the list of available ships";
		String help = "";
		return new ListCommand(name, shortcut, details, help);
	}
	
	public static HelpCommand help() {
		String name = "Help";
		String shortcut = "H";
		String details = "Prints this help message";
		String help = "";
		return new HelpCommand(name, shortcut, details, help);
	}
	
	public static ResetCommand reset() {
		String name = "Reset";
		String shortcut = "R";
		String details = "Starts a new game";
		String help = "";
		return new ResetCommand(name, shortcut, details, help);
	}
	
	public static UpdateCommand update() {
		String name = "Reset";
		String shortcut = "R";
		String details = "Starts a new game";
		String help = "";
		return new UpdateCommand(name, shortcut, details, help);
	}
	
	public static ExitCommand exit() {
		String name = "exit";
		String shortcut = "e";
		String details = "Exit the game";
		String help = "";
		return new ExitCommand(name, shortcut, details, help);
	}
	
	public static MoveCommand move() {
		String name = "move";
		String shortcut = "m";
		String details = "Move the ship";
		String help = "Move <RIGHT/LEFT> <1/2>";
		return new MoveCommand(name,shortcut,details, help);
	}
	
	public static ShockwaveCommand shock() {
		String name = "Shockwave";
		String shortcut = "w";
		String details = "Shoot the ShockWave";
		String help = "Deals 1 damage to every enemy on screen";
		return new ShockwaveCommand(name, shortcut, details, help);
	}
	
}
