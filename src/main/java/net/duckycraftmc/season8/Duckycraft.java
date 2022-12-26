package net.duckycraftmc.season8;

import net.duckycraftmc.season8.listeners.QuestCompletionListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Duckycraft extends JavaPlugin {

    @Override
    public void onEnable() {
        long bootTime = System.currentTimeMillis();

        getServer().getPluginManager().registerEvents(new QuestCompletionListener(this), this);

        getLogger().info("[Duckycraft] Took " + (System.currentTimeMillis() - bootTime) + "ms to boot plugin.");
    }

    @Override
    public void onDisable() {
    }

}
