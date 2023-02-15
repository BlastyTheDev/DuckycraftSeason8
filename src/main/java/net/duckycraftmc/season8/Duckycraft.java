package net.duckycraftmc.season8;

import net.duckycraftmc.season8.commands.tpa.TpaAcceptCommand;
import net.duckycraftmc.season8.commands.tpa.TpaDenyCommand;
import net.duckycraftmc.season8.commands.tpa.TpaRequestCommand;
import net.duckycraftmc.season8.listeners.EntityDamageByEntityListener;
import net.duckycraftmc.season8.listeners.PlayerJoinQuitListener;
import net.duckycraftmc.season8.listeners.PlayerMoveListener;
import net.duckycraftmc.season8.runnables.CombatTagClock;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class Duckycraft extends JavaPlugin {

    private final List<Player> comabatTaggedPlayers = new ArrayList<>();
    private final HashMap<Player, Long> playersLastInCombatTime = new HashMap<>();

    private final HashMap<Player, Player> tpaMap = new HashMap<>();
    private final HashMap<Player, Location> backLocationsMap = new HashMap<>();
    private final List<Player> teleportingPlayers = new ArrayList<>();

    @Override
    public void onEnable() {
        long bootTime = System.currentTimeMillis();

        getServer().getPluginManager().registerEvents(new EntityDamageByEntityListener(this), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinQuitListener(this), this);
        getServer().getPluginManager().registerEvents(new PlayerMoveListener(this), this);

        // Tpa
        if (getConfig().getBoolean("tpa-enabled")) {
            getServer().getPluginCommand("tpa").setExecutor(new TpaRequestCommand(this));
            getServer().getPluginCommand("tpaccept").setExecutor(new TpaAcceptCommand(this));
            getServer().getPluginCommand("tpdeny").setExecutor(new TpaDenyCommand(this));
        }

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

    public HashMap<Player, Player> getTpaMap() {
        return tpaMap;
    }

    public HashMap<Player, Location> getBackLocationsMap() {
        return backLocationsMap;
    }

    public List<Player> getTeleportingPlayers() {
        return teleportingPlayers;
    }

}
