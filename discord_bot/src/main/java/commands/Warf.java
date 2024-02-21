package commands;

import org.javacord.api.event.message.MessageCreateEvent;

import java.util.List;

public class Warf extends Command{
    public Warf(){
        super(0);
    }

    public void executeCommand(MessageCreateEvent event, List<String> args) throws CommandException {
        checkArguments(args);
        // image source: https://twitter.com/HarlequinWheels/status/1529874302400491522/photo/1
        String link = "https://cdn.discordapp.com/attachments/787934255984541719/1009637303574069358/stand_back.png";
        event.getChannel().sendMessage(link);
    }
}
