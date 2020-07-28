package com.jozo.stanislav.commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;


public class Help implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "[Stanislav] Error: Only players can use commands!");
            return true;
        }
        Player player = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("standa")){
            player.sendMessage(ChatColor.GREEN + "Stanislav Help:\n" + ChatColor.LIGHT_PURPLE + "/hub : Teleports you to the hub\n/sethub : [ADMIN] Sets the hub to your current location\n/home : Teleports you to your home\n/sethome : Sets your home to your current location\n/s : Sets your gamemode to survival\n/c : Sets your gamemode to creative\n/recipes : Shows custom recipes list\n/standa : Shows this list");
            return true;
        }

        if(cmd.getName().equalsIgnoreCase("recipes")){
            player.sendMessage(ChatColor.GREEN + "Custom Recipes:\nMultiplying stone bricks:" + ChatColor.LIGHT_PURPLE + "\nxx  xx  xx\n SB  II  xx \n II  SB  xx \nSB : Stone Brick\nII : Iron Ingot\n\n" + ChatColor.GREEN + "Compressing Diamond:\n" + ChatColor.LIGHT_PURPLE + "Put coal in a furnace to compress it into a diamond.\nAction takes one minute."
            );
            return true;
        }

        return false;
    }

}

