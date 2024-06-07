package commandercortex.candy2.Utils.PlayerMessages;

import commandercortex.candy2.Utils.Components.BaseTextComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;



public class Messages {
    public static String prefix = "&7[&b&lCandy&r&7] &r-> &r";
    public static String debug = "&7[&cDEBUG&r&7] ";

    public static void Message(Player player, String message){
        TextComponent local = BaseTextComponent.LinkBaseTextComponent(ChatColor.translateAlternateColorCodes('&', prefix + message), "https:://www.github.com/CommanderCortex/", net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', "&a&lThis plugin is still in Development, Click here for updates!"));
        player.spigot().sendMessage(local);
    }
    public static void DebugMessage(Player player, String message){
        TextComponent local = BaseTextComponent.LinkBaseTextComponent(ChatColor.translateAlternateColorCodes('&', debug+prefix + message), "https:://www.github.com/CommanderCortex/", net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', "&a&lThis plugin is still in Development, Click here for updates!"));
        player.spigot().sendMessage(local);
    }
}
