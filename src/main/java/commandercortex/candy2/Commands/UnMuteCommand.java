package commandercortex.candy2.Commands;

import commandercortex.candy2.Global.MuteStatus;
import commandercortex.candy2.Permissions.GroupManager;
import commandercortex.candy2.Utils.PlayerMessages.Messages;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UnMuteCommand implements CommandExecutor {
    GroupManager groupManager = new GroupManager();
    MuteStatus muteStatus = new MuteStatus();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("Error, This is a Player Command!");
            return false;
        }

        Player player = (Player) sender;
        Player target = Bukkit.getPlayer(args[0]);

        if(!groupManager.MODPERMS(player)) {
            Messages.Message(player, "&cError, This Command requires Administrator Permissions!");
            return false;
        }

        if(target == null || !target.isOnline()) {
            Messages.Message(player, "&cError, Player Not Found?!");
            return false;
        }

        muteStatus.setMuteStatus(target, false);
        Messages.Message(player, "&aUn-Muted player: " + target.getDisplayName());

        return false;
    }
}
