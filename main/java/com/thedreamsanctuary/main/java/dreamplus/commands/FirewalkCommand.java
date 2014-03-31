package com.thedreamsanctuary.main.java.dreamplus.commands;

import com.thedreamsanctuary.main.java.dreamplus.DreamPlus;
import com.thedreamsanctuary.main.java.dreamplus.listener.DPListener;
import static com.thedreamsanctuary.main.java.dreamplus.listener.DPListener.firewalk;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author Ajcool1050
 */

public class FirewalkCommand implements CommandExecutor 
{
    //This was implement for Kesaro, he asked for it okay...
    //Don't get mad at me :(
    //<5 because 5 is bigger then 3, <3 I mean <5... You get the point.
    final DreamPlus dp;
    public FirewalkCommand(DreamPlus dp)
    {
        this.dp = dp;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String string, String[] args)
    {
        if (sender instanceof Player)
        {
            Player player = (Player) sender;
            if (player.hasPermission("dreamplus.command.firewalk"))
            {
                if (!firewalk.contains(player.getName()))
                {
                   DPListener.addPlayerToList(player, firewalk);
                   player.sendMessage(ChatColor.GOLD + "Firewalk has been enabled.");
                }
                else
                {
                    DPListener.removePlayerFromList(player, firewalk);
                    player.sendMessage(ChatColor.GOLD + "Firewalk has been disabled.");
                }
            }
            else player.sendMessage(ChatColor.GOLD + "You are not able to execute that command.");
        }
        else sender.sendMessage("Must be and ingame player to execute command.");
        return false;
    }  
}
