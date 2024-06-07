package commandercortex.candy2.Players;

import org.bukkit.entity.Player;

public class GetPlayerFile {
    public static String getPlayer(Player player){
        return "plugins/candy/players/" + player.getUniqueId() + ".yml";
    }
}
