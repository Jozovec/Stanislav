package com.jozo.stanislav.commands;
import com.jozo.stanislav.Stanislav;

import org.bukkit.Location;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;


public class Hub implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "[Stanislav] Error: Only players can use commands!");
            return true;
        }
        Player player = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("hub")){
            try {
                File file = new File(Stanislav.main.getDataFolder(), "hubPos.yml");
                YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

                Location hubPos = new Location(Stanislav.main.getServer().getWorld(config.getString("hub.world")), config.getDouble("hub.x"), config.getDouble("hub.y"), config.getDouble("hub.z"), config.getInt("hub.yaw"), 0);
                player.teleport(hubPos);
                player.sendMessage(ChatColor.GREEN + "Teleporting to the hub...");
            }catch (Exception ex){
                player.sendMessage(ChatColor.RED + "Hub not set!");
            }
            return true;
        }

        if(cmd.getName().equalsIgnoreCase("sethub")){
            if(!(player.getName().equalsIgnoreCase("Whop"))) {
                player.sendMessage(ChatColor.RED + "You are not allowed to use this command!");
                return true;
            }
            File file = new File(Stanislav.main.getDataFolder(), "hubPos.yml");
            YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

            config.set("hub.world", player.getLocation().getWorld().getName());
            config.set("hub.x", player.getLocation().getBlockX() + 0.5);
            config.set("hub.y", player.getLocation().getBlockY());
            config.set("hub.z", player.getLocation().getBlockZ() + 0.5);
            config.set("hub.yaw", Math.round(player.getLocation().getYaw()));

            try {
                config.save(file);
                player.sendMessage(ChatColor.GREEN + "Hub set to your current position.\n" + ChatColor.LIGHT_PURPLE + player.getLocation().getWorld().getName() + " X:" + (player.getLocation().getBlockX() + 0.5) + " Y:" + player.getLocation().getBlockY() + " Z:" + (player.getLocation().getBlockZ() + 0.5));
            } catch (Exception ex) {
                player.sendMessage(ChatColor.RED + "Error while saving configuration file!");
                ex.printStackTrace();
            }
            return true;
        }

        return false;
    }

}
