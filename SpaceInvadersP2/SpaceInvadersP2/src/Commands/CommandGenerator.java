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
	}
	
	public static ListCommand list() {
		ListCommand l;
		String name = "List";
		String shortcut = "L";
		String details = "Prints the list of available ships";
		String help = "";
		return l = new ListCommand(name, shortcut, details, help);
	}
	
	public static HelpCommand help() {
		HelpCommand h;
		String name = "Help";
		String shortcut = "H";
		String details = "Prints this help message";
		String help = "";
		return h = new HelpCommand(name, shortcut, details, help);
	}
	
	public static ResetCommand reset() {
		ResetCommand h;
		String name = "Reset";
		String shortcut = "R";
		String details = "Starts a new game";
		String help = "";
		return h = new ResetCommand(name, shortcut, details, help);
	}
	
	public static UpdateCommand update() {
		UpdateCommand h;
		String name = "Reset";
		String shortcut = "R";
		String details = "Starts a new game";
		String help = "";
		return h = new UpdateCommand(name, shortcut, details, help);
	}
	
	
}
