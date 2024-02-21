package commands;

import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;

import java.awt.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

public class RPS extends Command{
    private static final Hashtable<List<String>, Integer> RPStable = new Hashtable<>();
    private static final String[] options = {"rock", "paper", "scissors"};

    static{
        ArrayList<String> rr = new ArrayList<>(); rr.add("rock"); rr.add("rock"); RPStable.put(rr, 0);
        ArrayList<String> pp = new ArrayList<>(); pp.add("paper"); pp.add("paper"); RPStable.put(pp, 0);
        ArrayList<String> ss = new ArrayList<>(); ss.add("scissors"); ss.add("scissors"); RPStable.put(ss, 0);
        ArrayList<String> rp = new ArrayList<>(); rp.add("rock"); rp.add("paper"); RPStable.put(rp, -1);
        ArrayList<String> ps = new ArrayList<>(); ps.add("paper"); ps.add("rock"); RPStable.put(ps, -1);
        ArrayList<String> sr = new ArrayList<>(); sr.add("scissors"); sr.add("rock"); RPStable.put(sr, -1);
        ArrayList<String> rs = new ArrayList<>(); rs.add("rock"); rs.add("scissors"); RPStable.put(rs, 1);
        ArrayList<String> pr = new ArrayList<>(); pr.add("paper"); pr.add("rock"); RPStable.put(pr, 1);
        ArrayList<String> sp = new ArrayList<>(); sp.add("scissors"); sp.add("paper"); RPStable.put(sp, 1);
    }

    public RPS(){
        super(1);
    }
    public void executeCommand(MessageCreateEvent event, List<String> args) throws CommandException {
        checkArguments(args);
        Random rand = new Random();
        int n = rand.nextInt(3);
        String playerChoice = args.get(0);
        String enemyChoice = options[n];
        ArrayList<String> pair = new ArrayList<>();
        pair.add(playerChoice);
        pair.add(enemyChoice);
        try{
            Integer winValue = RPStable.get(pair);
            makeEmbed(event, playerChoice, enemyChoice, winValue);
        }
        catch(NullPointerException e){
            event.getChannel().sendMessage("incorrect argument provided");
        }
    }

    private void makeEmbed(MessageCreateEvent event, String player, String enemy, Integer winValue){
        new MessageBuilder()
                .setEmbed(new EmbedBuilder()
                        .setTitle("Rock Paper Scissors!")
                        .setDescription("You played: "+ player + "\n" +
                                "I play: " + enemy + "\n\n"+
                                winMessage(winValue))
                        .setColor(Color.PINK)
                )
                .send(event.getChannel());
    }

    private String winMessage(Integer winValue){
        if(winValue == 0){
            return "**It's a draw!**";
        }
        else if(winValue == -1){
            return "**I win!**";
        }
        else{
            return "**You win!**";
        }
    }
}
