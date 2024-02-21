package commands;

import org.javacord.api.event.message.MessageCreateEvent;

import java.io.File;
import java.util.List;

public class Sheesh extends Command{
    public Sheesh(){
        super(0);
    }

    public void executeCommand(MessageCreateEvent event, List<String> args) throws CommandException {
        checkArguments(args);
        String link = "https://cdn.discordapp.com/attachments/665028812051841065/1136693115198111927/Sheesh.mov";
        String link2 = "https://cdn.discordapp.com/attachments/665028812051841065/1063591540267700375/fumofriday2.mp4";
        event.getChannel().sendMessage(link);
    }
}
