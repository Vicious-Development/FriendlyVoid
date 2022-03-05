package com.drathonix.friendlyvoid;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class FriendlyVoid extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        this.getLogger().info("FriendlyVoid Successfully Initialized! Have fun not losing everything!");
    }

    @Override
    public void onDisable() {

    }
    @EventHandler
    public void onDeath(PlayerDeathEvent ev){
        EntityDamageEvent ede = ev.getEntity().getLastDamageCause();
        if(ede != null) {
            if(ede.getCause() == EntityDamageEvent.DamageCause.VOID) {
                ev.setKeepInventory(true);
                ev.setKeepLevel(true);
            }
        }
    }
}
