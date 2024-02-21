package commands;


import org.javacord.api.event.message.MessageCreateEvent;

import java.util.List;

/**
 * This is a superclass for all necessary commands needed in the program
 */

public abstract class Command {
    private final int expectedArguments;


    public Command(int expectedArguments){
        this.expectedArguments = expectedArguments;
    }

    abstract public void executeCommand(MessageCreateEvent event, List<String> args) throws CommandException;

    public void checkArguments(List<String> arguments) throws CommandException{
        if(arguments.size() != expectedArguments){
            throw new CommandException("wrong number of arguments provided");
        }
    }
}
