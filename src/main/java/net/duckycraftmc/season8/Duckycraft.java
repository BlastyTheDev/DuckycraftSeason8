package net.duckycraftmc.season8;

import net.duckycraftmc.season8.listeners.EntityDamageByHoeListener;
import net.duckycraftmc.season8.listeners.PlayerDamageByPlayerListener;
import net.duckycraftmc.season8.listeners.PlayerJoinQuitListener;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class Duckycraft extends JavaPlugin {

    private final HashMap<Player, Boolean> combatTagMap = new HashMap<>();

    @Override
    public void onEnable() {
        long bootTime = System.currentTimeMillis();

        getServer().getPluginManager().registerEvents(new PlayerDamageByPlayerListener(this), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinQuitListener(this), this);
        getServer().getPluginManager().registerEvents(new EntityDamageByHoeListener(this), this);

        getLogger().info("Took " + (System.currentTimeMillis() - bootTime) + "ms to start Duckycraft Season 8.");
    }

    @Override
    public void onDisable() {
    }

    public HashMap<Player, Boolean> getCombatTagMap() {
        return combatTagMap;
    }

}
