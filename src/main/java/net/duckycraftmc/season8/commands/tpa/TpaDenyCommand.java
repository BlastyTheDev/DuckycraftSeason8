package net.duckycraftmc.season8.commands.tpa;

import net.duckycraftmc.season8.Duckycraft;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class TpaDenyCommand implements CommandExecutor {

    private final Duckycraft plugin;

    public TpaDenyCommand(Duckycraft plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!plugin.getConfig().getBoolean("tpa-enabled")) {
            sender.sendMessage(ChatColor.RED + "Duckycraft Tpa is disabled.");
            return true;
        }
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "You must be a player to use this command.");
            return true;
        }
        Player player = (Player) sender;
        if (plugin.getTpaMap().get(player) == null) {
            player.sendMessage(ChatColor.RED + "You do not have any incoming teleport requests.");
            return true;
        }
        Player requester = plugin.getTpaMap().get(player);
        plugin.getTpaMap().remove(player);
        requester.sendMessage(ChatColor.YELLOW + player.getName() + ChatColor.RED + " has rejected your teleport request.");
        player.sendMessage(ChatColor.GREEN + "You have rejected " + ChatColor.YELLOW + requester.getName() +
                ChatColor.GREEN + "'s teleport request.");
        return true;
    }

}
