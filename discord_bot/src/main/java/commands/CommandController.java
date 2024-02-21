package commands;

import org.javacord.api.event.message.MessageCreateEvent;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandController{

    public void executeCommand(MessageCreateEvent event){
        String input = event.getMessageContent().substring(1);
        List<String> args = getArgs(input);
        String[] split = input.split(" ");
        try{
            Command command = Constants.COMMAND_MAP.get(split[0]);
            command.executeCommand(event, args);
        }
        catch(NullPointerException e){
            event.getChannel().sendMessage("command not found");
            System.out.println("command not found");
        }
        catch(CommandException e){
            event.getChannel().sendMessage(e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    private List<String> getArgs(String command){
        String[] split = command.split(" ");
        List<String> args = new ArrayList<>();
        if(split.length > 1){
            args.addAll(Arrays.asList(split).subList(1, split.length));
        }
        return args;
    }
}
