package memes;

import org.javacord.api.event.message.MessageCreateEvent;

public class Xnopyt implements Meme{
    public void execute(MessageCreateEvent event){
        String message = event.getMessageContent();
        String link = "https://www.youtube.com/watch?v=ldQE2nvYPdU";
        if(message.contains("xnopyt")){
            event.getChannel().sendMessage(link);
        }
    }
}