package commands;

import java.io.IOException;

import exceptions.CommandExecuteException;
import exceptions.CommandMovementException;
import exceptions.CommandParseException;
import logic.Game;

public abstract class Command {

    // ATRIBUTTES

    protected final String name;

    protected final String shortcut;

    protected final String details;

    protected final String help;

    protected static final String incorrectNumArgsMsg = "Incorrect number of arguments";

    protected static final String incorrectArgsMsg = "Incorrect argument format";

    public Command(String name, String shorcut, String details, String help) {
        this.name = name;
        this.shortcut = shorcut;
        this.details = details;
        this.help = help;
    }

    public boolean matchCommandName(String name) {
        return this.shortcut.equalsIgnoreCase(name) || this.name.equalsIgnoreCase(name);
    }

    public String helpText() {
        return details + "(" + shortcut + ") : " + help + "\n";
    }

    public abstract boolean execute(Game game) throws CommandExecuteException, IOException;

    public abstract Command parse(String[] commandWord) throws CommandParseException, CommandMovementException;

}