package commandercortex.candy2.Players;

import commandercortex.candy2.Permissions.GroupManager;
import commandercortex.candy2.Utils.PlayerMessages.Messages;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {
    PlayerSetup playerSetup = new PlayerSetup();
    GroupManager groupManager = new GroupManager();
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent playerJoinEvent){
        Player player = playerJoinEvent.getPlayer();
        playerSetup.NewPlayer(player);
        playerJoinEvent.setJoinMessage("");
        Messages.Message(player, "&aWelcome to Cortex's Server!");
        groupManager.TabListManager();
    }
}
