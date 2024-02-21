package driver;

import memes.MemeController;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.intent.Intent;

import commands.*;


public class Main {
    public static void main(String[] args) throws Exception{    
        DiscordApi api = new DiscordApiBuilder()
                .setToken("Token Goes Here")
                .addIntents(Intent.MESSAGE_CONTENT)
                .login().join();

        CommandController CC = new CommandController();
        MemeController MC = new MemeController();

        api.addMessageCreateListener(event -> {
            if(!event.getMessageAuthor().isBotUser()){
                String message = event.getMessageContent();
                if(message.startsWith(".")){
                    CC.executeCommand(event);
                }
                // add an else clause and run a thing which will do the informal commands
                MC.execute(event);
                System.out.println(message);
                System.out.println(event.getMessageAuthor());
            }
        });
    }
}
