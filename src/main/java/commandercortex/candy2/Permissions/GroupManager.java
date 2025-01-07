package commandercortex.candy2.Permissions;

import commandercortex.candy2.Players.GetPlayerFile;
import commandercortex.candy2.Utils.PlayerMessages.Color;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class GroupManager extends Groups {
    public int getGroup(Player player){
        String file = GetPlayerFile.getPlayer(player);
        File playerFile = new File(file);
        YamlConfiguration yaml = YamlConfiguration.loadConfiguration(playerFile);
        return yaml.getInt("Group:");
    }
    public void setGroup(Player player, int group){
        String file = GetPlayerFile.getPlayer(player);
        File playerFile = new File(file);
        YamlConfiguration yaml = YamlConfiguration.loadConfiguration(playerFile);
        yaml.set("Group:", group);
        try {yaml.save(file);} catch (IOException e) {throw new RuntimeException(e);}
    }
    public String GroupPrefix(int group){
        if(group == Developer)
            return Color.C("&7[&4&lDEV&r&7] &r");
        if(group == Admin)
            return Color.C("&7[&4&lADMIN&r&7] &r");
        if(group == Moderator)
            return Color.C("&7[&6&lMOD&r&7] &r");
        return "";
    }
    public void TabListManager(){
        for(Player player : Bukkit.getOnlinePlayers()){
            Scoreboard scoreboard = Objects.requireNonNull(Bukkit.getScoreboardManager()).getNewScoreboard();
            for (Player player1 : Bukkit.getOnlinePlayers()){
                if(player1.isInvisible()){
                    scoreboard.resetScores(player1.getDisplayName());
                    continue; //Skip adding invisible players
                }
                String prefix = GroupPrefix(getGroup(player));
                Team team = scoreboard.registerNewTeam(player1.getDisplayName());
                team.setPrefix(prefix);
                team.addEntry(player1.getDisplayName());
            }
            player.setScoreboard(scoreboard);
        }
    }
    public boolean ADMINPERMS(Player player){
        return getGroup(player)>= 95 || player.isOp();
    }
    public boolean MODPERMS(Player player){
        return getGroup(player)>= 90 || player.isOp();
    }
}
