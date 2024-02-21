package commands;

import org.javacord.api.event.message.MessageCreateEvent;

import java.util.List;

public class Swirebroke extends Command{
    public Swirebroke(){
        super(0);
    }

    public void executeCommand(MessageCreateEvent event, List<String> args) throws CommandException {
        checkArguments(args);
        String link = "https://cdn.discordapp.com/emojis/760515832089804831.webp?size=128&quality=lossless";
        event.getChannel().sendMessage(link);
    }
}
