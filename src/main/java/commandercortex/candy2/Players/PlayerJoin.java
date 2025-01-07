package commandercortex.candy2.Players;

import commandercortex.candy2.Candy2;
import commandercortex.candy2.Permissions.GroupManager;
import commandercortex.candy2.Permissions.Permissions;
import commandercortex.candy2.Permissions.PermissionsManager;
import commandercortex.candy2.Utils.PlayerMessages.Messages;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {
    PlayerSetup playerSetup = new PlayerSetup();
    GroupManager groupManager = new GroupManager();
    Permissions permissions = new Permissions();


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent playerJoinEvent){
        Player player = playerJoinEvent.getPlayer();
        playerSetup.NewPlayer(player);
        playerJoinEvent.setJoinMessage("");
        permissions.LoadPlayerPermissions(player);

        Messages.Message(player, "&aWelcome to Cortex's Server!");
        if(player.isInvisible()){
            player.setInvisible(false);
        }
        groupManager.TabListManager();
    }
}
