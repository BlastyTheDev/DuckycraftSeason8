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

@SuppressWarnings("deprecation")
public class EntityDamageByEntityListener implements Listener {

    private final Duckycraft plugin;

    public EntityDamageByEntityListener(Duckycraft plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
        if (!(e.getDamager() instanceof Player)) return;

        Player damager = (Player) e.getDamager();

        Entity damagedEntity = e.getEntity();
        ItemStack weapon = damager.getInventory().getItemInMainHand();

        switch (weapon.getType()) {
            case WOODEN_HOE:
                damagedEntity.setVelocity(damager.getLocation().getDirection().setY(0).normalize().multiply(-0.75));
            case STONE_HOE:
                damagedEntity.setVelocity(damager.getLocation().getDirection().setY(0).normalize().multiply(-0.9));
            case IRON_HOE:
                damagedEntity.setVelocity(damager.getLocation().getDirection().setY(0).normalize().multiply(-1));
            case GOLDEN_HOE:
                damagedEntity.setVelocity(damager.getLocation().getDirection().setY(0).normalize().multiply(-1.1));
            case DIAMOND_HOE:
                damagedEntity.setVelocity(damager.getLocation().getDirection().setY(0).normalize().multiply(-1.2));
            case NETHERITE_HOE:
                damagedEntity.setVelocity(damager.getLocation().getDirection().setY(0).normalize().multiply(-2));
        }

        if (!(e.getEntity() instanceof Player)) return;

        Player player = (Player) e.getEntity();

        switch (weapon.getType()) {
            case WOODEN_SHOVEL:
            case STONE_SHOVEL:
            case IRON_SHOVEL:
            case GOLDEN_SHOVEL:
            case DIAMOND_SHOVEL:
            case NETHERITE_SHOVEL:
        }

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
