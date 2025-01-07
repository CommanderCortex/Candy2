package commandercortex.candy2.Commands;

import commandercortex.candy2.Permissions.GroupManager;
import commandercortex.candy2.Utils.PlayerMessages.Messages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VanishCommand implements CommandExecutor {
    GroupManager groupManager = new GroupManager();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("Error, This is a Player Command!");
            return false;
        }

        Player player = (Player) sender;

        if (!groupManager.MODPERMS(player)) {
            Messages.Message(player, "&cError, This Command requires Moderator Permissions!");
            return false;
        }

        if (player.isInvisible()){
            Messages.Message(player, "&aVanish Toggled &cOFF!");
            player.setInvisible(false);
        }else {
            Messages.Message(player, "&aVanish toggled &bON!");
            player.setInvisible(true);
        }
        groupManager.TabListManager();
        return false;
    }
}
