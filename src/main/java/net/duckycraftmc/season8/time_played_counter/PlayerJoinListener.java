package net.duckycraftmc.season8.time_played_counter;

import net.duckycraftmc.season8.Duckycraft;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    private final Duckycraft plugin;

    public PlayerJoinListener(Duckycraft plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
    }

}
