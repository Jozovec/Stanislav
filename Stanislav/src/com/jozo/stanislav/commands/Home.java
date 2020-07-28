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


public class Home implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "[Stanislav] Error: Only players can use commands!");
            return true;
        }
        Player player = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("home")){
            try {
                File file = new File(Stanislav.main.getDataFolder(), "homes.yml");
                YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

                Location hubPos = new Location(Stanislav.main.getServer().getWorld(config.getString(player.getUniqueId() + ".home.world")), config.getDouble(player.getUniqueId() +  ".home.x"), config.getDouble(player.getUniqueId() + ".home.y"), config.getDouble(player.getUniqueId() + ".home.z"), config.getInt(player.getUniqueId() + ".home.yaw"), 0);
                player.teleport(hubPos);
                player.sendMessage(ChatColor.GREEN + "Teleporting home...");
            }catch (Exception ex){
                player.sendMessage(ChatColor.RED + "Home not set!");
            }
            return true;
        }

        if(cmd.getName().equalsIgnoreCase("sethome")){
            File file = new File(Stanislav.main.getDataFolder(), "homes.yml");
            YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

            config.set(player.getUniqueId() + ".home.world", player.getLocation().getWorld().getName());
            config.set(player.getUniqueId() + ".home.x", player.getLocation().getBlockX() + 0.5);
            config.set(player.getUniqueId() + ".home.y", player.getLocation().getBlockY());
            config.set(player.getUniqueId() + ".home.z", player.getLocation().getBlockZ() + 0.5);
            config.set(player.getUniqueId() + ".home.yaw", Math.round(player.getLocation().getYaw()));

            try {
                config.save(file);
                player.sendMessage(ChatColor.GREEN + "Home set to your current position.\n" + ChatColor.LIGHT_PURPLE + player.getLocation().getWorld().getName() + " X:" + (player.getLocation().getBlockX() + 0.5) + " Y:" + player.getLocation().getBlockY() + " Z:" + (player.getLocation().getBlockZ() + 0.5));
            } catch (Exception ex) {
                player.sendMessage(ChatColor.RED + "Error while saving configuration file!");
                ex.printStackTrace();
            }
            return true;
        }

        return false;
    }

}
