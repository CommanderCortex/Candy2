package commandercortex.candy2.Commands;

import commandercortex.candy2.Permissions.GroupManager;
import commandercortex.candy2.Utils.PlayerMessages.Messages;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommand implements CommandExecutor {
    GroupManager groupManager = new GroupManager();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player))
            sender.sendMessage("Error, This is a Player Command!");

        assert sender instanceof Player;
        Player player = (Player) sender;
        Player target = Bukkit.getPlayer(args[0]);

        if(groupManager.ADMINPERMS(player)){
            if(target != null && target.isOnline()){
                switch (args[1]){
                    case "c":
                        target.setGameMode(GameMode.CREATIVE);
                        Messages.Message(player, "Set "+player.getDisplayName()+"'s Gamemode to Creative");
                        break;
                    case "s":
                        target.setGameMode(GameMode.SURVIVAL);
                        Messages.Message(player, "Set "+player.getDisplayName()+"'s Gamemode to Survival");
                        break;
                    case "a":
                        target.setGameMode(GameMode.ADVENTURE);
                        Messages.Message(player, "Set "+player.getDisplayName()+"'s Gamemode to Adventure");
                        break;
                    default:
                        Messages.Message(player,"&cError, Gamemode Not Found?!" );
                }
            }else
                Messages.Message(player, "&cError, Player Not Found?!");
        }else
            Messages.Message(player, "&cError, This Command requires Administrator Permissions!");
        return false;
    }
}
