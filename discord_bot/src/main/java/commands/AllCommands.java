package commands;

import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;

import java.awt.*;
import java.util.List;

public class AllCommands extends Command{
    public AllCommands(){
        super(0);
    }

    public void executeCommand(MessageCreateEvent event, List<String> args) throws CommandException {
        checkArguments(args);
        String out = "";
        for(String entry : Constants.COMMAND_MAP.keySet()){
            out += entry + "\n";
        }
        String message = out.substring(0, out.length() - 1);
        new MessageBuilder()
                .setEmbed(new EmbedBuilder()
                        .setTitle("Here's a list of all commands")
                        .setDescription(message)
                        .setColor(Color.PINK)
                )
                .send(event.getChannel());
    }
}
