package com.jozo.stanislav.commands;

import org.bukkit.GameMode;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;


public class Gamemode implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "[Stanislav] Error: Only players can use commands!");
            return true;
        }
        Player player = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("s")){
            player.setGameMode(GameMode.SURVIVAL);
                player.sendMessage(ChatColor.GREEN + "Gamemode set to survival.");
            return true;
        }

        if(cmd.getName().equalsIgnoreCase("c")){
            player.setGameMode(GameMode.CREATIVE);
            player.sendMessage(ChatColor.GREEN + "Gamemode set to creative.");
            return true;
        }

        return false;
    }

}
