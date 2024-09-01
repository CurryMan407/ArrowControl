package org.curryman.arrowcontrol;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.ChatColor;

public class ArrowControl extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {

        this.saveDefaultConfig();
        String darkPurple = "\033[0;35m";
        String lightPurple = "\033[1;35m";
        String reset = "\033[0m";


        Bukkit.getPluginManager().registerEvents(this, this);
        getLogger().info(darkPurple + "------------------------------------" + reset);
        getLogger().info(lightPurple + "Arrow Control" + reset);
        getLogger().info(lightPurple + "Plugin Enabled Successfully" + reset);
        getLogger().info(lightPurple + "Arrows will now be controlled" + reset);
        getLogger().info(lightPurple + "Developed by CurryMan" + reset);
        getLogger().info(lightPurple + "Made for Fusion Network" + reset);
        getLogger().info(darkPurple + "------------------------------------" + reset);
    }
    @Override
    public void onDisable() {
        String darkPurple = "\033[0;35m";
        String lightPurple = "\033[1;35m";
        String reset = "\033[0m";


        Bukkit.getPluginManager().registerEvents(this, this);
        getLogger().info(darkPurple + "------------------------------------" + reset);
        getLogger().info(lightPurple + "Arrow Control" + reset);
        getLogger().info(lightPurple + "Plugin Disabled Successfully" + reset);
        getLogger().info(lightPurple + "Developed by CurryMan" + reset);
        getLogger().info(lightPurple + "Made for Fusion Network" + reset);
        getLogger().info(darkPurple + "------------------------------------" + reset);
    }
    @EventHandler
    public void onArrowShoot(EntityShootBowEvent event) {

        FileConfiguration config = this.getConfig();
        if (!config.getBoolean("enabled", true)) {
            return;
        }


        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();


            ItemStack consumable = event.getConsumable();


            if (consumable != null && consumable.getItemMeta() instanceof PotionMeta) {

                event.setCancelled(true);




                if (config.getBoolean("send-message", true)) {
                    player.sendMessage(ChatColor.DARK_RED + "Shooting tipped arrows is disabled on this server");
                }
            }
        }
    }
}
