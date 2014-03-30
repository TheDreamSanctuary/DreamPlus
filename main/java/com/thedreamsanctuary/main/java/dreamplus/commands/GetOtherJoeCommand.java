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

public class GetOtherJoeCommand implements CommandExecutor 
{
    final DreamPlus dp;
    public GetOtherJoeCommand(DreamPlus dp)
    {
        this.dp = dp;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String string, String[] args)
    {
        if (sender instanceof Player)
        {
            Player player = (Player) sender;
            if (player.hasPermission("voxelplus2.command.getotherjoe"))
            {
                if (args.length == 2)
                {
                    Player receiver = player.getServer().getPlayer(args[0]);
                    if (receiver != null) 
                    {
                        if (isInt(args[1]))
                        {
                            int seconds = Integer.parseInt(args[1]);
                            DPFood.drinkCoffee(receiver, seconds);
                            
                            Random random = new Random();
                            int number = random.nextInt(50) + 1;
                            if (number == 1) 
                            {
                                receiver.sendMessage(ChatColor.DARK_GRAY + "["
                                        + ChatColor.DARK_AQUA + "Jomeaga"
                                        + ChatColor.DARK_GRAY + " -> "
                                        + ChatColor.GRAY + "You"
                                        + ChatColor.DARK_GRAY + "]"
                                        + ChatColor.AQUA + " WHAT?!");
                            }
                            
                            player.sendMessage(ChatColor.GOLD + receiver.getName() + " sure did enjoy their SparkRoast Coffee");
                        }
                        else player.sendMessage(ChatColor.GOLD + "Usage: /getotherjoe [player] [seconds]");
                    }
                    else player.sendMessage(ChatColor.GOLD + "That player could not be found.");                   
                }
                else player.sendMessage(ChatColor.GOLD + "Usage: /getotherjoe [player] [seconds]");
            }
            else player.sendMessage(ChatColor.GOLD + "You are not able to execute that command.");
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
