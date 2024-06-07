package commandercortex.candy2.Commands;

import commandercortex.candy2.Permissions.GroupManager;
import commandercortex.candy2.Utils.PlayerMessages.Messages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {
    GroupManager groupManager = new GroupManager();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player))
            sender.sendMessage("Error, This is a Player Command!");

        assert sender instanceof Player;
        Player player = (Player) sender;

        if(groupManager.MODPERMS(player)){
            player.setAllowFlight(!player.getAllowFlight());
            Messages.Message(player, "&a Toggled Flight!");
        }else
            Messages.Message(player, "&cError, This Command requires Moderator Permissions!");
        return false;
    }
}
