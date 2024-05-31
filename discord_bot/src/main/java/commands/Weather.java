package commands;

import org.javacord.api.event.message.MessageCreateEvent;

import com.google.gson.Gson;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import java.util.List;
import java.util.Map;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.io.IOException;
import java.net.*;

public class Weather extends Command{
    public Weather(){
        super(1);
    }

    public void executeCommand(MessageCreateEvent event, List<String> args) throws CommandException {
        checkArguments(args);
        String city = args.get(0);
        String link = String.format("http://api.openweathermap.org/data/2.5/weather?q=%s,ca&APPID=[API KEY GOES HERE]&units=metric", city);
        try {
            HttpRequest req = HttpRequest.newBuilder().uri(new URI(link)).GET().build();
            HttpClient httpClient = HttpClient.newHttpClient();
            try {
                java.net.http.HttpResponse<String> response = httpClient.send(req, BodyHandlers.ofString());
                Gson gson = new Gson();
                Type type = new TypeToken<Map<String, Object>>(){}.getType();
                Map<String, Object> map = gson.fromJson(response.body(), type);
                String text = map.get("main").toString();
                String temp = text.substring(6, 10);
                event.getChannel().sendMessage("It is currently "+ temp + " degrees in " + city);
            } catch (IOException e) {
                // wtf
                e.printStackTrace();
            } catch (InterruptedException e) {
                // wtf
                e.printStackTrace();
            }
        } catch (URISyntaxException e) {
            System.out.println("papayahands");
        }
    }
}
