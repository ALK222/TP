package Commands;

import logic.Game;

public class ExitCommand extends Commands{

	public ExitCommand(String name, String shortcut, String details, String help) {
		super(name, shortcut, details, help);
	}


	public boolean execute(Game game) {
		game.setDoExit(true);
		return false;
	}

	@Override
	public Commands Parse(String[] commandWord) {
		// TODO Auto-generated method stub
		return null;
	}

}
