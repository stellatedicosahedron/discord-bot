package memes;

import org.javacord.api.event.message.MessageCreateEvent;

interface Meme {
    void execute(MessageCreateEvent event);
}
