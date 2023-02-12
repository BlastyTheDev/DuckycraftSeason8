package net.duckycraftmc.season8;

import net.duckycraftmc.season8.listeners.EntityDamageByHoeListener;
import net.duckycraftmc.season8.listeners.PlayerDamageByPlayerListener;
import net.duckycraftmc.season8.listeners.PlayerJoinQuitListener;
import net.duckycraftmc.season8.runnables.CombatTagClock;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SuppressWarnings("deprecation")
public final class Duckycraft extends JavaPlugin {

    private final List<Player> comabatTaggedPlayers = new ArrayList<>();
    private final HashMap<Player, Long> playersLastInCombatTime = new HashMap<>();

    @Override
    public void onEnable() {
        long bootTime = System.currentTimeMillis();

        getServer().getPluginManager().registerEvents(new PlayerDamageByPlayerListener(this), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinQuitListener(this), this);
        getServer().getPluginManager().registerEvents(new EntityDamageByHoeListener(this), this);

        getServer().getScheduler().runTaskTimer(this, new CombatTagClock(this), 0, 1);

        getLogger().info("Took " + (System.currentTimeMillis() - bootTime) + "ms to start Duckycraft Season 8.");
    }

    @Override
    public void onDisable() {
    }

    public List<Player> getCombatTaggedPlayers() {
        return comabatTaggedPlayers;
    }

    public HashMap<Player, Long> getPlayersLastInCombatTime() {
        return playersLastInCombatTime;
    }

}
