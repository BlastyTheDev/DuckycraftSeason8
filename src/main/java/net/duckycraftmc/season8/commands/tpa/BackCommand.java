package net.duckycraftmc.season8.commands.tpa;

import net.duckycraftmc.season8.Duckycraft;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

public class BackCommand implements CommandExecutor {

    private final Duckycraft plugin;

    public BackCommand(Duckycraft plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "You must be a player to use this command.");
            return true;
        }
        Player player = (Player) sender;
        if (plugin.getBackLocationsMap().get(player) == null) {
            player.sendMessage(ChatColor.RED + "You do not have any previous locations.");
            return true;
        }
        new BukkitRunnable() {
            int i = 0;
            @Override
            public void run() {
                if (i == plugin.getConfig().getInt("tp-delay")) {
                } else i++;
            }
        }.runTaskTimer(plugin, 0, 20);
        return true;
    }

}
