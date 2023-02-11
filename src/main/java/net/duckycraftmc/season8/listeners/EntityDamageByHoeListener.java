package net.duckycraftmc.season8.listeners;

import net.duckycraftmc.season8.Duckycraft;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import static org.bukkit.Material.*;

public class EntityDamageByHoeListener implements Listener {

    private final Duckycraft plugin;

    public EntityDamageByHoeListener(Duckycraft plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void entityDamageByEntityEvent(EntityDamageByEntityEvent e) {
        if (!(e.getDamager() instanceof Player)) return;
        Player player = (Player) e.getDamager();
        ItemStack weapon = player.getInventory().getItemInMainHand();
        if (weapon.equals(WOODEN_HOE)) {
        }
        if (weapon.equals(STONE_HOE)) {
        }
        if (weapon.equals(IRON_HOE)) {
        }
        if (weapon.equals(GOLDEN_HOE)) {
        }
        if (weapon.equals(DIAMOND_HOE)) {
        }
        if (weapon.equals(NETHERITE_HOE)) {
        }
    }

}
