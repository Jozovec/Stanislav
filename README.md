# Stanislav
Stanislav is a Minecraft Spigot Plugin for Minecraft 1.16.1 Servers.

### Commands
/hub : Teleports player to the hub  
/sethub : For now, only a player named **Whop** can set the hub location (changing in a future update)  
/home : Teleports player to his home  
/sethome : Sets player's home to his current coordinates  
/s : Sets player's gamemode to survival  
/c : Sets player's gamemode to creative  
/standa : Shows help list  
/recipes : Shows custom recipes  

### Custom Recipes
**Stone Brick Multiplier**  
  Stone Bricks are hard to get, if you're building a castle, you need a lot of those. If you have a Iron Golem farm, you probably don't know what to do with Iron Ingots.  
  Well, combine them:  
  
  In a 2x2 crafting square, put Stone Bricks to opposite corners, and fill the empty corners with Iron Ingots.  
  Results in 6x Stone Bricks.  

**Crafting Diamonds**  
  Diamonds are now simple to make!  
  Put Coal into a furnace to compress it into a Diamond.  
  The action takes a minute, and returns 2.5 xp.  

## Getting Standa
First, create a server based on the Bukkit API (Spigot, PaperMC, CraftBukkit...). If you don't know how to do that, well... fuck you...  
Once the server works, make sure it's stopped, and copy **Stanilav.jar** to your **plugins** folder.  
If you want to modify the code, download IntelliJ, Eclipse or any other java IDE. Create a new project (preferably same name as source folder: *Stanislav*), and copy the contents from **Stanislav/** to your project's root. You will probably need to add a Spigot API 1.16.1 dependency to use the commands (can be found in **Spigot APIs/**). Modify the code, and build it into a **.jar** file. Put the build in your plugins folder and enjoy your new plugin!
