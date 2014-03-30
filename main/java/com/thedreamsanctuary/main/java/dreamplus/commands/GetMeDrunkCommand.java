package com.thedreamsanctuary.main.java.dreamplus.commands;

import com.thedreamsanctuary.main.java.dreamplus.DreamPlus;
import com.thedreamsanctuary.main.java.dreamplus.executors.DPFood;
import java.util.Random;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author Ajcool1050
 */

public class GetMeDrunkCommand implements CommandExecutor 
{
    final DreamPlus dp;
    public GetMeDrunkCommand(DreamPlus dp)
    {
        this.dp = dp;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String string, String[] args)
    {
        if (sender instanceof Player)
        {
            Player player = (Player) sender;
            if (player.hasPermission("voxelplus2.command.getmedrunk"))
            {
                if (args.length == 1)
                {
                    if (isInt(args[0]))
                    {
                        Random random = new Random();
                        int number = random.nextInt(50) + 1;
                        if (number == 1) 
                        {
                            player.sendMessage(ChatColor.DARK_GRAY + "["
                                    + ChatColor.DARK_AQUA + "Kesaro"
                                    + ChatColor.DARK_GRAY + " -> "
                                    + ChatColor.GRAY + "You"
                                    + ChatColor.DARK_GRAY + "]"
                                    + ChatColor.AQUA + " u fukin wot m8 ill bash ur fkin hed in i swer on me mum");
                        }
                        
                        int num = Integer.parseInt(args[0]);
                        DPFood.drinkLager(player, num);
                    }
                    else player.sendMessage(ChatColor.GOLD + "Usage: /getmedrunk [seconds]");  
                }
                else player.sendMessage(ChatColor.GOLD + "Usage: /getmedrunk [seconds]");
            }
            else player.sendMessage("You are not able to execute that command.");
        }
        else sender.sendMessage("Must be and ingame player to execute command.");
        return false;
    }
    
    private static boolean isInt(String s) 
    {
        try 
        {
            Integer.parseInt(s);
        } 
        catch (NumberFormatException nfe) 
        {
            return false;
        }
        return true;
    }
}
