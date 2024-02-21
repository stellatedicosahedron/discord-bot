package memes;

import org.javacord.api.event.message.MessageCreateEvent;

import java.util.ArrayList;

public class MemeController {
    public void execute(MessageCreateEvent event){
        for(Meme m : Constants.memes){
            m.execute(event);
        }
    }
}
