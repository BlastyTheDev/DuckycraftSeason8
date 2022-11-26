package net.duckycraftmc.season8;

import org.bukkit.plugin.java.JavaPlugin;

public final class Duckycraft extends JavaPlugin {

    @Override
    public void onEnable() {
        long bootTime = System.currentTimeMillis();

        // code

        getLogger().info("[Duckycraft] Took " + (System.currentTimeMillis() - bootTime) + "ms to boot plugin.");
    }

    @Override
    public void onDisable() {
    }

}
