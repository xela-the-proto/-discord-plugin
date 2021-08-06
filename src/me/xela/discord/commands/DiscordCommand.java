package me.xela.discord.commands;

import me.xela.discord.Main;
import me.xela.discord.utils.utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DiscordCommand implements CommandExecutor {

    private Main plugin;

    public DiscordCommand(Main plugin){
        this.plugin = plugin;
        plugin.getCommand("discord").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)){
            commandSender.sendMessage("only players can run this command");
            return true;
        }

        Player p = (Player) commandSender;

        if (p.hasPermission("discord.use")){
            p.sendMessage(utils.chat(plugin.getConfig().getString("messageToPlayer").replace("<player>",p.getName())));
            return true;
        }else{
            p.sendMessage("you do not have the permission to execute this command");
        }
        return false;
    }
}
