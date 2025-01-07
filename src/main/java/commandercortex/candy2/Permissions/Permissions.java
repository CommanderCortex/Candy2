package commandercortex.candy2.Permissions;

import commandercortex.candy2.Utils.PlayerMessages.Messages;
import org.bukkit.entity.Player;

public class Permissions {
    GroupManager groupManager = new GroupManager();
    public void LoadPlayerPermissions(Player player){
        if(groupManager.ADMINPERMS(player)) {
            Messages.Message(player, "&cDEBUG, This is a test command for staff members ignore");
            PermissionsManager.addPermission(player.getUniqueId(), "bukkit.command.reload");
            PermissionsManager.addPermission(player.getUniqueId(), "minecraft.command.op");
            PermissionsManager.addPermission(player.getUniqueId(), "minecraft.command.deop");

        }
    }

    //PermissionsManager.addPermission(player.getUniqueId(), "bukkit.command.reload");
}
