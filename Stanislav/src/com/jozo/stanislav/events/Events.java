package com.jozo.stanislav.events;
import com.jozo.stanislav.Stanislav;

import org.bukkit.Location;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.inventory.ItemStack;

public class Events implements Listener {

    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        player.sendMessage(ChatColor.GREEN + "Welcome " + ChatColor.LIGHT_PURPLE +  player.getName() + ChatColor.GREEN + "!\nType " + ChatColor.LIGHT_PURPLE + "/standa" + ChatColor.GREEN + " for help!");
    }

    @EventHandler
    public static void onWeatherChange(WeatherChangeEvent event){
        event.setCancelled(event.toWeatherState());
    }

    @EventHandler
    public static void onPlayerSleep(PlayerBedEnterEvent event){
        Player player = event.getPlayer();
        player.sendMessage(ChatColor.GRAY + "Good night everybody!");
    }

}
