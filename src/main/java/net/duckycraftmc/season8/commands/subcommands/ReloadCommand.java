package net.duckycraftmc.season8.commands.subcommands;

import net.duckycraftmc.season8.Duckycraft;
import net.duckycraftmc.season8.commands.CommandManager;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class ReloadCommand extends CommandManager {

    @Override
    public String getName() {
        return "reload";
    }

    @Override
    public String getDesc() {
        return "Reloads the Duckycraft plugin's configuration file.";
    }

    @Override
    public void execute(CommandSender sender, String[] args, Duckycraft plugin) {
        sender.sendMessage(ChatColor.RED + "Attempting to reload config.yml...");
        plugin.reloadConfig();
        sender.sendMessage(ChatColor.GREEN + "Reload Successful.");
    }

}
