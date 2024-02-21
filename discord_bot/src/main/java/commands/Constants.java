package commands;

import java.util.Hashtable;

public class Constants {
    public static final Hashtable<String, Command> COMMAND_MAP = new Hashtable<String, Command>();

    static {
        COMMAND_MAP.put("mentalstate", new MentalState());
        COMMAND_MAP.put("rps", new RPS());
        COMMAND_MAP.put("dumb", new Dumb());
        COMMAND_MAP.put("friday", new Friday());
        COMMAND_MAP.put("swirebroke", new Swirebroke());
        COMMAND_MAP.put("pp", new PP());
        COMMAND_MAP.put("warf", new Warf());
        COMMAND_MAP.put("allcommands", new AllCommands());
        COMMAND_MAP.put("sheesh", new Sheesh());
    }
}
