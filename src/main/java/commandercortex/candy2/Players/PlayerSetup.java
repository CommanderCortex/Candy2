package commandercortex.candy2.Players;

import commandercortex.candy2.Files.PluginConfig;
import commandercortex.candy2.Utils.PlayerMessages.Messages;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

@SuppressWarnings("ResultOfMethodCallIgnored")
public class PlayerSetup {
    public void NewPlayer(Player player){
        String file = "plugins/candy/players/" + player.getUniqueId() + ".yml";
        File _file = new File(file);
        if(!_file.exists())
            try {_file.createNewFile();} catch (IOException e) {throw new RuntimeException(e);}
        YamlConfiguration yaml = YamlConfiguration.loadConfiguration(_file);
        yaml.addDefault("Name:", player.getName());
        yaml.addDefault("Group:", 0);
        yaml.options().copyDefaults(true);
        try {yaml.save(_file);} catch (IOException e) {throw new RuntimeException(e);}

        if(PluginConfig.CurrentStatus == 1) {
            Messages.Message(player, "&aYour Player Data has been updated!&c @" + file);
        }else{
            Messages.Message(player, "&aYour Player Data has been updated!");
        }
    }
}
