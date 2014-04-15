package com.thedreamsanctuary.main.java.dreamplus;

import com.thedreamsanctuary.main.java.dreamplus.commands.DreamEmoteCommand;
import com.thedreamsanctuary.main.java.dreamplus.commands.DreamTrailCommand;
import com.thedreamsanctuary.main.java.dreamplus.commands.DreamGlowCommand;
import com.thedreamsanctuary.main.java.dreamplus.commands.GetOtherDrunkCommand;
import com.thedreamsanctuary.main.java.dreamplus.commands.GetOtherJoeCommand;
import com.thedreamsanctuary.main.java.dreamplus.commands.DreamHelmetCommand;
import com.thedreamsanctuary.main.java.dreamplus.commands.GetMeDrunkCommand;
import com.thedreamsanctuary.main.java.dreamplus.commands.GetMeJoeCommand;
import com.thedreamsanctuary.main.java.dreamplus.listener.DPListener;
import com.thedreamsanctuary.main.java.dreamplus.commands.FirewalkCommand;
import static com.thedreamsanctuary.main.java.dreamplus.listener.DPListener.glows;
import static com.thedreamsanctuary.main.java.dreamplus.listener.DPListener.trails;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Ajcool1050
 */

public class DreamPlus extends JavaPlugin
{
    protected static final Logger log = Logger.getLogger("Minecraft");
    final DPListener listener = new DPListener(this);
    
    @Override
    public void onEnable()
    {
        Bukkit.getServer().getPluginManager().registerEvents(listener, this);
        
        log.severe("THE LOVE IS STRONG IN THIS ONE!");
        
        DPListener.loadMap(this, "trail", trails);
        DPListener.loadMap(this, "glow", glows);
        
        getCommand("firewalk").setExecutor(new FirewalkCommand(this));
        getCommand("getmedrunk").setExecutor(new GetMeDrunkCommand(this));
        getCommand("getotherdrunk").setExecutor(new GetOtherDrunkCommand(this));
        getCommand("getmejoe").setExecutor(new GetMeJoeCommand(this));
        getCommand("getotherjoe").setExecutor(new GetOtherJoeCommand(this));
        getCommand("dhelm").setExecutor(new DreamHelmetCommand(this));
        getCommand("dglow").setExecutor(new DreamGlowCommand(this));
        getCommand("dtrail").setExecutor(new DreamTrailCommand(this));
        getCommand("me").setExecutor(new DreamEmoteCommand(this));
    }
    
    @Override
    public void onDisable()
    {
        log.severe("THE LOVE IS WEEK IN THIS ONE!");
        
        DPListener.saveMap(this, "trail", trails);
        DPListener.saveMap(this, "glow", glows);
    }
}