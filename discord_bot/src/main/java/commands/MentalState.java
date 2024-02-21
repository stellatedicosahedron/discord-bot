package commands;

import org.javacord.api.event.message.MessageCreateEvent;

import java.io.File;
import java.util.List;

public class MentalState extends Command{
    public MentalState(){
        super(0);
    }

    @Override
    public void executeCommand(MessageCreateEvent event, List<String> args) throws CommandException {
        checkArguments(args);
        String link = "https://cdn.discordapp.com/attachments/787934255984541719/1006810786531905627/mentalstate.gif";
        event.getChannel().sendMessage(link);
        // event.getChannel().sendMessage(new File("images/mentalstate.gif"));
    }
}
