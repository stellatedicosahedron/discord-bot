package commands;

import org.javacord.api.event.message.MessageCreateEvent;

import java.util.List;

public class PP extends Command{
    public PP(){
        super(0);
    }
    public void executeCommand(MessageCreateEvent event, List<String> args) throws CommandException {
        checkArguments(args);
        String link2 = "https://media.discordapp.net/attachments/863447524543430656/996278823433797672/IMG_2137.gif";
        String link = "https://cdn.discordapp.com/attachments/759043688063303750/1136809984282333225/IMG_0433.jpg";
        event.getChannel().sendMessage(link2);
    }
}
