package com.thedreamsanctuary.main.java.dreamplus.commands;

import com.thedreamsanctuary.main.java.dreamplus.DreamPlus;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author Ajcool1050
 */

public class DreamEmoteCommand implements CommandExecutor 
{
    final DreamPlus dp;
    public DreamEmoteCommand(DreamPlus dp)
    {
        this.dp = dp;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String string, String[] args)
    {
        if (sender instanceof Player)
        {
            Player player = (Player) sender;
            
            if (player.hasPermission("dreamplus.command.me"))
            {
                if (args.length < 1) player.sendMessage(ChatColor.GOLD + "Usage: /me [Message]");
                else
                {
                    String msg = "";
                    for (String str : args) msg = (msg + str + " ");
                    Bukkit.broadcastMessage(ChatColor.DARK_GRAY + "* "
                            + player.getName() + " " 
                            + ChatColor.translateAlternateColorCodes('&', msg));
                }
            }
            else player.sendMessage(ChatColor.GOLD + "You are not able to execute that command.");
        }
        else sender.sendMessage("Must be and ingame player to execute command.");
        return false; 
    }   
}
