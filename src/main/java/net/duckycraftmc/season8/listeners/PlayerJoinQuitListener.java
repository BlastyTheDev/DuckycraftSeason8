package net.duckycraftmc.season8.listeners;

import net.duckycraftmc.season8.Duckycraft;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerJoinQuitListener implements Listener {

    private final Duckycraft plugin;

    public PlayerJoinQuitListener(Duckycraft plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        if (plugin.getCombatTaggedPlayers().contains(player))
            player.setHealth(0);
    }

}
