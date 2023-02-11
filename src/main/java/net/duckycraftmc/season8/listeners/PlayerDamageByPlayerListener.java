package net.duckycraftmc.season8.listeners;

import net.duckycraftmc.season8.Duckycraft;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

@SuppressWarnings("deprecation")
public class PlayerDamageByPlayerListener implements Listener {

    private final Duckycraft plugin;

    public PlayerDamageByPlayerListener(Duckycraft plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
        if (!(e.getDamager() instanceof Player)) return;
        if (!(e.getEntity() instanceof Player)) return;

        final Player player = (Player) e.getEntity();
        final Player damager = (Player) e.getDamager();

        plugin.getCombatTagMap().put(player, true);
        plugin.getCombatTagMap().put(damager, true);

        player.sendMessage(ChatMessageType.ACTION_BAR,
                new TextComponent(ChatColor.RED + "You are now in combat. DO NOT DISCONNECT"));
        damager.sendMessage(ChatMessageType.ACTION_BAR,
                new TextComponent(ChatColor.RED + "You are now in combat. DO NOT DISCONNECT"));
    }

}
