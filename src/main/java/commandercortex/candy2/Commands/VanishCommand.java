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
        if(!(sender instanceof Player))
            sender.sendMessage("Error, This is a Player Command!");

        assert sender instanceof Player;
        Player player = (Player) sender;

        if(groupManager.MODPERMS(player)){
            player.setInvisible(!player.isInvisible());
            groupManager.TabListManager();

            if(player.isInvisible()){
                Messages.Message(player, "&aVanish toggled &bON!");
            }else{
                Messages.Message(player, "&aVanish Toggled &cOFF!");
            }
        }else
            Messages.Message(player, "&cError, This Command requires Moderator Permissions!");
        return false;
    }
}
