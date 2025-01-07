package commandercortex.candy2.Commands;

import commandercortex.candy2.Permissions.GroupManager;
import commandercortex.candy2.Utils.PlayerMessages.Messages;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearChat implements CommandExecutor {
    public void clear(){
        for(int i=0; i<256; i++)
            Bukkit.broadcastMessage("");
    }
    GroupManager groupManager = new GroupManager();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player))
            sender.sendMessage("Error, This is a Player Command!");

        assert sender instanceof Player;
        Player player = (Player) sender;

        if(!groupManager.MODPERMS(player))
            Messages.Message(player, "&cError, This Command requires Moderator Permissions!");

        clear();
        return false;
    }
}
