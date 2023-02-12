package net.duckycraftmc.season8.runnables;

import net.duckycraftmc.season8.Duckycraft;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

@SuppressWarnings("deprecation")
public class CombatTagClock extends BukkitRunnable {

    private final Duckycraft plugin;

    public CombatTagClock(Duckycraft plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (plugin.getPlayersLastInCombatTime().get(player) < (System.currentTimeMillis() - 60000)) {
                plugin.getCombatTaggedPlayers().remove(player);
                player.sendMessage(ChatMessageType.ACTION_BAR,
                        new TextComponent(ChatColor.GREEN + "You are no longer in combat."));
            }
        }
    }

}
