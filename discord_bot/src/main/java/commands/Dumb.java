package commands;

import org.javacord.api.event.message.MessageCreateEvent;

import java.io.File;
import java.util.List;

public class Dumb extends Command{
    public Dumb(){
        super(0);
    }
    public void executeCommand(MessageCreateEvent event, List<String> args) throws CommandException{
        checkArguments(args);
        String link = "https://cdn.discordapp.com/attachments/787934255984541719/1007308975794028564/dumb.gif";
        event.getChannel().sendMessage(link);
        // event.getChannel().sendMessage(new File("images/dumb.gif"));
    }
}
