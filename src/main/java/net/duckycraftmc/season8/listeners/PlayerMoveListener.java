package net.duckycraftmc.season8.listeners;

import net.duckycraftmc.season8.Duckycraft;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveListener implements Listener {

    private final Duckycraft plugin;

    public PlayerMoveListener(Duckycraft plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        Player player = e.getPlayer();
        if (plugin.getTeleportingPlayers().contains(player)) {
            plugin.getTeleportingPlayers().remove(player);
            player.sendMessage(ChatColor.RED + "You have moved, and your teleport has been cancelled.");
        }
    }

}
