package commandercortex.candy2.Global;

import commandercortex.candy2.Players.GetPlayerFile;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class MuteStatus {
    public boolean getMuteStatus(Player player){
        String file = GetPlayerFile.getPlayer(player);
        File playerFile = new File(file);
        YamlConfiguration yaml = YamlConfiguration.loadConfiguration(playerFile);
        return yaml.getBoolean("Muted:");
    }

    public void setMuteStatus(Player player, boolean status){
        String file = GetPlayerFile.getPlayer(player);
        File playerFile = new File(file);
        YamlConfiguration yaml = YamlConfiguration.loadConfiguration(playerFile);
        yaml.set("Muted:", status);
        try {yaml.save(file);} catch (IOException e) {throw new RuntimeException(e);}
    }
}
