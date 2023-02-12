package net.duckycraftmc.season8.listeners;

import net.duckycraftmc.season8.Duckycraft;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import static org.bukkit.Material.*;
import static org.bukkit.Material.NETHERITE_HOE;

@SuppressWarnings("deprecation")
public class EntityDamageByEntityListener implements Listener {

    private final Duckycraft plugin;

    public EntityDamageByEntityListener(Duckycraft plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
        if (!(e.getDamager() instanceof Player)) return;
        Player player = (Player) e.getEntity();

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

        if (!(e.getEntity() instanceof Player)) return;

        Player damager = (Player) e.getDamager();

        plugin.getCombatTaggedPlayers().add(player);
        plugin.getCombatTaggedPlayers().add(damager);

        plugin.getPlayersLastInCombatTime().put(player, System.currentTimeMillis());
        plugin.getPlayersLastInCombatTime().put(damager, System.currentTimeMillis());

        player.sendMessage(ChatMessageType.ACTION_BAR,
                new TextComponent(ChatColor.RED + "You are now in combat. DO NOT DISCONNECT"));
        damager.sendMessage(ChatMessageType.ACTION_BAR,
                new TextComponent(ChatColor.RED + "You are now in combat. DO NOT DISCONNECT"));
    }

}
