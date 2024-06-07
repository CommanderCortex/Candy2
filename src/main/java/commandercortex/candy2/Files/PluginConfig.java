package commandercortex.candy2.Files;

import commandercortex.candy2.Players.GetPlayerFile;
import commandercortex.candy2.Utils.PlayerMessages.Messages;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class PluginConfig {
    public void ConfigFile(){
        String file = "plugins/candy/config/config.yml";
        File _file = new File(file);
        if(!_file.exists())
            try {_file.createNewFile();} catch (IOException e) {throw new RuntimeException(e);}
        YamlConfiguration yaml = YamlConfiguration.loadConfiguration(_file);
        yaml.addDefault("PluginLoadStatus:", 0);
        yaml.options().copyDefaults(true);
        try {yaml.save(_file);} catch (IOException e) {throw new RuntimeException(e);}
    }

    public static int getConfigStatus(){
        String file = "plugins/candy/config/config.yml";
        File _file = new File(file);
        YamlConfiguration yaml = YamlConfiguration.loadConfiguration(_file);
        return yaml.getInt("PluginLoadStatus:");
    }

    public void Status(){
        if(CurrentStatus == 1){
            System.out.println("Loading in DEBUG MODE!! - SET STATUS TO 0 FOR PRODUCTION");
        }else{
            System.out.println("Candy Loading in Production Mode, for Debugging set status to 1 in config");
        }
    }
    public static int CurrentStatus = getConfigStatus();
}
