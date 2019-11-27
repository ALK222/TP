package Commands;

import logic.Game;

public class ShockwaveCommand extends Commands{

	public ShockwaveCommand(String name, String shortcut, String details, String help) {
		super(name, shortcut, details, help);
	}

	@Override
	public boolean execute(Game game) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Commands Parse(String[] commandWord) {
		// TODO Auto-generated method stub
		return null;
	}

}
