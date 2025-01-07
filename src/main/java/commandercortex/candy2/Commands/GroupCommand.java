package commandercortex.candy2.Commands;

import commandercortex.candy2.Permissions.GroupManager;
import commandercortex.candy2.Permissions.Groups;
import commandercortex.candy2.Utils.PlayerMessages.Messages;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GroupCommand implements CommandExecutor {
    GroupManager groupManager = new GroupManager();
    Groups groups = new Groups();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("Error, This is a Player Command!");
            return false;
        }

        Player player = (Player) sender;
        Player target = Bukkit.getPlayer(args[0]);

        if(!groupManager.ADMINPERMS(player)) {
            Messages.Message(player, "&cError, This Command requires Administrator Permissions!");
            return false;
        }

        if (target == null || !target.isOnline()) {
            Messages.Message(player, "&cError, Player Not Found?!");
            return false;
        }

        switch (args[1]) {
            case "Developer":
                groupManager.setGroup(target, groups.Developer);
                Messages.Message(player, "Set " + target.getDisplayName() + "'s group to Developer");
                break;
            case "Admin":
                groupManager.setGroup(target, groups.Admin);
                Messages.Message(player, "Set " + target.getDisplayName() + "'s group to Admin");
                break;
            case "Mod":
                groupManager.setGroup(target, groups.Moderator);
                Messages.Message(player, "Set " + target.getDisplayName() + "'s group to Moderator");
                break;
            case "Default":
                groupManager.setGroup(target, groups.Default);
                Messages.Message(player, "Set " + target.getDisplayName() + "'s group to Default");
                break;
            default:
                Messages.Message(player, "&cError, Group Not Found?!");
        }
        groupManager.TabListManager();
        return false;
    }
}
