package me.xela.discord;


import me.xela.discord.commands.DiscordCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable(){
        saveDefaultConfig();

        new DiscordCommand(this);
    }
}