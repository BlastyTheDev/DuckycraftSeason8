package net.duckycraftmc.season8.commands.tpa;

import net.duckycraftmc.season8.Duckycraft;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class TpaRequestCommand implements CommandExecutor {

    private final Duckycraft plugin;

    public TpaRequestCommand(Duckycraft plugin) {
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
        if (args.length != 1) {
            sender.sendMessage(ChatColor.RED + "Usage: /tpa <player>");
            return true;
        }
        Player requester = (Player) sender;
        if (Bukkit.getPlayer(args[0]) == null) {
            requester.sendMessage(ChatColor.RED + "That player does not exist/is not online.");
            return true;
        }
        Player target = Bukkit.getPlayer(args[0]);
        assert target != null;
        if (plugin.getTpaMap().get(target) == requester) {
            requester.sendMessage(ChatColor.RED + "You have already sent a teleport request to " +
                    ChatColor.YELLOW + target.getName());
            return true;
        }
        plugin.getTpaMap().put(target, requester);
        requester.sendMessage(ChatColor.GREEN + "You have sent a teleport request to " +
                ChatColor.YELLOW + target.getName());
        target.playSound(target.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100, 1);
        target.sendMessage(ChatColor.GREEN + "You have received a teleport request from " +
                ChatColor.YELLOW + requester.getName());
        target.sendMessage(ChatColor.GREEN + "Use " + ChatColor.YELLOW + "/tpaccept" +
                ChatColor.GREEN + " to accept\n" +
                "Use " + ChatColor.YELLOW + "/tpdeny" + ChatColor.GREEN + " to deny");
        return true;
    }

}
