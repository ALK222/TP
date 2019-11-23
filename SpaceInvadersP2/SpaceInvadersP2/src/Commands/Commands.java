package Commands;

import logic.Game;

public abstract class Commands {
	
	//ATTRIBUTES
	
	protected final String name;
	protected final String shortcut;
	private final String details;
	private final String help;
	
	protected static final String incorrectNumArgsMsg = "Incorrect number of arguments";
	protected static final String IncorrectArgsMsg = "Incorrect argument format";
	
	//CONSTRUCTOR
	public Commands(String name, String shortcut, String details, String help) {
		this.name = name;
		this.shortcut = shortcut;
		this.details = details;
		this.help = help;
	}
	
	public abstract boolean execute(Game game);
	
	public abstract Commands Parse(String[] commandWord);
	
	protected boolean matchCommandName(String name) {
		return this.shortcut.equalsIgnoreCase(name) ||this.name.equalsIgnoreCase(name);
	}
	
	public String helpText() {
		return details + ": " + help + "\n";
	}
}
