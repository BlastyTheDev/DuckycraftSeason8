package net.duckycraftmc.season8.listeners;

import net.duckycraftmc.season8.Duckycraft;
import org.bukkit.entity.Entity;
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
        Entity damagedEntity = e.getEntity();
        ItemStack weapon = player.getInventory().getItemInMainHand();
        if (weapon.getType().equals(WOODEN_HOE)) {
            damagedEntity.setVelocity(player.getLocation().getDirection().setY(0).normalize().multiply(-0.75));
        }
        if (weapon.getType().equals(STONE_HOE)) {
            damagedEntity.setVelocity(player.getLocation().getDirection().setY(0).normalize().multiply(-0.9));
        }
        if (weapon.getType().equals(IRON_HOE)) {
            damagedEntity.setVelocity(player.getLocation().getDirection().setY(0).normalize().multiply(-1));
        }
        if (weapon.getType().equals(GOLDEN_HOE)) {
            damagedEntity.setVelocity(player.getLocation().getDirection().setY(0).normalize().multiply(-1.1));
        }
        if (weapon.getType().equals(DIAMOND_HOE)) {
            damagedEntity.setVelocity(player.getLocation().getDirection().setY(0).normalize().multiply(-1.2));
        }
        if (weapon.getType().equals(NETHERITE_HOE)) {
            damagedEntity.setVelocity(player.getLocation().getDirection().setY(0).normalize().multiply(-2));
        }
    }

}
