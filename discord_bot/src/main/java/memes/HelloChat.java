package memes;

import org.javacord.api.event.message.MessageCreateEvent;

public class HelloChat implements Meme{
    public void execute(MessageCreateEvent event){
        String message = event.getMessageContent();
        String link = "https://media.discordapp.net/attachments/665028812051841065/1133092337174724700/AmiyaJumpscare.gif";
        if(message.contains("hello chat")){
            event.getChannel().sendMessage(link);
        }
    }
}
