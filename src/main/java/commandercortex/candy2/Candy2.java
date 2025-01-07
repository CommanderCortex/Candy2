package commandercortex.candy2;

import commandercortex.candy2.Commands.*;
import commandercortex.candy2.Files.PluginConfig;
import commandercortex.candy2.Files.PluginFiles;
import commandercortex.candy2.Global.ChatFunctions;
import commandercortex.candy2.Players.PlayerJoin;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permissible;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public final class Candy2 extends JavaPlugin {

    PluginFiles pluginFiles = new PluginFiles();
    PluginConfig pluginConfig = new PluginConfig();

    @Override
    public void onEnable() {
        System.out.println("Candy is now loading!");

        FileHandler();
        EventsHandler();
        CommandHandler();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public void FileHandler(){
        pluginFiles.Path_to_Candy();
        pluginFiles.Path_to_Players();
        pluginFiles.Path_to_Config();

        pluginConfig.ConfigFile();
        pluginConfig.Status();
    }
    public void EventsHandler(){
        Bukkit.getPluginManager().registerEvents(new PlayerJoin(), this);
        Bukkit.getPluginManager().registerEvents(new ChatFunctions(), this);
    }
    public void CommandHandler(){
        Objects.requireNonNull(Bukkit.getPluginCommand("group")).setExecutor(new GroupCommand());
        Objects.requireNonNull(Bukkit.getPluginCommand("fly")).setExecutor(new FlyCommand());
        Objects.requireNonNull(Bukkit.getPluginCommand("gm")).setExecutor(new GamemodeCommand());
        Objects.requireNonNull(Bukkit.getPluginCommand("v")).setExecutor(new VanishCommand());
        Objects.requireNonNull(Bukkit.getPluginCommand("cc")).setExecutor(new ClearChat());
        Objects.requireNonNull(Bukkit.getPluginCommand("help")).setExecutor(new HelpCommand());
        Objects.requireNonNull(Bukkit.getPluginCommand("mute")).setExecutor(new MuteCommand());
        Objects.requireNonNull(Bukkit.getPluginCommand("unmute")).setExecutor(new UnMuteCommand());
    }
}
