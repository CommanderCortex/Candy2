package commandercortex.candy2.Global;

import commandercortex.candy2.Permissions.GroupManager;
import commandercortex.candy2.Utils.PlayerMessages.Color;
import commandercortex.candy2.Utils.PlayerMessages.Messages;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class ChatFunctions implements Listener {
    GroupManager groupManager = new GroupManager();
    MuteStatus muteStatus = new MuteStatus();
    @EventHandler
    public void Chat(AsyncPlayerChatEvent chatEvent){

        chatEvent.setCancelled(true);
        Player player = chatEvent.getPlayer();
        String Message = chatEvent.getMessage();
        String DisplayName = player.getDisplayName();
        String PlayerPrefix = groupManager.GroupPrefix(groupManager.getGroup(player));

        String FormattedMessage = "&7[&eChat&r&7] &r>> " + PlayerPrefix + "&7[&r" + DisplayName + "&7]&r" + " &a>> &r"+ Message;

        if(player.isInvisible()) {
            Messages.Message(player, "&cError&r, You can't send messages will in Vanish!");
            return;
        }
        if(muteStatus.getMuteStatus(player)){
            Messages.Message(player, "&cError&r, You can't send messages well Muted!");
            return;
        }
        Bukkit.broadcastMessage(Color.C(FormattedMessage));
    }
}
