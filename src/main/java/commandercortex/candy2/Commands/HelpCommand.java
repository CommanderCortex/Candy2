package commandercortex.candy2.Commands;

import commandercortex.candy2.Utils.Components.BaseTextComponent;
import commandercortex.candy2.Utils.PlayerMessages.Color;
import commandercortex.candy2.Utils.PlayerMessages.Messages;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player))
            sender.sendMessage("Error, This is a play only Command");

        assert sender instanceof Player;
        Player player = (Player) sender;

        String line1 = Messages.prefix+"&6&l---List Of Commands---";

        TextComponent _line1 = BaseTextComponent.LinkBaseTextComponent(Color.C(line1), Color.C("https://github.com/CommanderCortex/Candy2/"), Color.C("Click here for Plugin Development Updates"));

        player.spigot().sendMessage(_line1);

        Messages.Message(player, "/group <player> <group> || Sets a players group & permissions");

        return false;
    }
}
