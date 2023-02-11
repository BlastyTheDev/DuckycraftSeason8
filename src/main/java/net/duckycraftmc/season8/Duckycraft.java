package net.duckycraftmc.season8;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class Duckycraft extends JavaPlugin {

    private final HashMap<Player, Boolean> combatTagMap = new HashMap<>();

    @Override
    public void onEnable() {
        long bootTime = System.currentTimeMillis();
        getLogger().info("Took " + (System.currentTimeMillis() - bootTime) + "ms to start Duckycraft Season 81.");
    }

    @Override
    public void onDisable() {
    }

    public HashMap<Player, Boolean> getCombatTagMap() {
        return combatTagMap;
    }

}
