package com.jozo.stanislav;

import org.bukkit.plugin.java.JavaPlugin;

import com.jozo.stanislav.commands.Hub;
import com.jozo.stanislav.commands.Home;
import com.jozo.stanislav.commands.Gamemode;
import com.jozo.stanislav.commands.Help;
import com.jozo.stanislav.events.Events;
import com.jozo.stanislav.recipes.RecipeManager;

public class Stanislav extends JavaPlugin {

    public static Stanislav main;

    @Override
    public void onEnable(){
        main = this;
        Hub hub = new Hub();
        Home home = new Home();
        Gamemode gamemode = new Gamemode();
        Help help = new Help();
        getServer().getPluginManager().registerEvents(new Events(), this);
        getCommand("hub").setExecutor(hub);
        getCommand("sethub").setExecutor(hub);
        getCommand("home").setExecutor(home);
        getCommand("sethome").setExecutor(home);
        getCommand("s").setExecutor(gamemode);
        getCommand("c").setExecutor(gamemode);
        getCommand("recipes").setExecutor(help);
        getCommand("standa").setExecutor(help);

        RecipeManager.loadRecipes();
        getServer().getConsoleSender().sendMessage("[Stanislav] Initialized!");
    }

    @Override
    public void onDisable(){
        getServer().getConsoleSender().sendMessage("[Stanislav] Stopped!");
    }

}
