package net.duckycraftmc.season8.listeners;

import net.duckycraftmc.season8.Duckycraft;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

@SuppressWarnings("deprecation")
public class PlayerDeathListener implements Listener {

    private final Duckycraft plugin;

    public PlayerDeathListener(Duckycraft plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        Player player = e.getPlayer();
        if (plugin.getCombatTaggedPlayers().contains(player)) {
            e.setDeathMessage(player.getName() + " really thought they could combat log without consequence.");
            plugin.getCombatTaggedPlayers().remove(player);
        }
    }

}
